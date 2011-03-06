package soc.common.board.hexes;

import soc.common.annotations.SeaFarers;
import soc.common.board.chits.Chit;
import soc.common.internationalization.I18n;
import soc.common.views.meta.Icon;
import soc.common.views.meta.IconImpl;
import soc.common.views.meta.Meta;
import soc.gwtClient.images.Resources;

import com.google.gwt.resources.client.ImageResource;

@SeaFarers
public class DiscoveryHex extends AbstractHex
{
    private static final long serialVersionUID = -4658204654937855497L;
    private static transient Meta meta = new Meta()
    {
        private Icon icon = new IconImpl(Resources.icons().discoveryHex32(),
                        null, null, null);

        @Override
        public Icon icon()
        {
            return icon;
        }

        @Override
        public String getName()
        {
            return "DiscoveryHex";
        }

        @Override
        public String getLocalizedName()
        {
            return I18n.get().constants().discoveryHex();
        }

        @Override
        public String getDescription()
        {
            return I18n.get().constants().discoveryHexDescription();
        }
    };

    /*
     * (non-Javadoc)
     * 
     * @see soc.common.board.hexes.Hex#Copy()
     */
    @Override
    public Hex copy()
    {
        DiscoveryHex result = new DiscoveryHex();

        result.setTerritory(territory);

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see soc.common.board.hexes.Hex#getColor()
     */
    @Override
    public String getColor()
    {
        return "White";
    }

    /*
     * (non-Javadoc)
     * 
     * @see soc.common.board.hexes.Hex#isBuildableLand()
     */
    @Override
    public boolean isBuildableLand()
    {
        return false;
    }

    /*
     * Pieces on a sea side can't build
     * 
     * @see soc.common.board.hexes.Hex#isBuildableSea()
     */
    @Override
    public boolean isBuildableSea()
    {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see soc.common.board.hexes.Hex#isPartOfGame()
     */
    @Override
    public boolean isPartOfGame()
    {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see soc.common.board.hexes.Hex#isPiratePlaceable()
     */
    @Override
    public boolean isPiratePlaceable()
    {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see soc.common.board.hexes.Hex#isRobberPlaceable()
     */
    @Override
    public boolean isRobberPlaceable()
    {
        return false;
    }

    @Override
    public boolean canHaveChit()
    {
        return false;
    }

    @Override
    public boolean hasChit()
    {
        return false;
    }

    @Override
    public boolean canHaveResource()
    {
        return false;
    }

    @Override
    public Chit getChit()
    {
        return null;
    }

    @Override
    public Hex setChit(Chit chit)
    {
        return this;
    }

    @Override
    public Meta getMeta()
    {
        return meta;
    }

    @Override
    public ImageResource getTexture()
    {
        return Resources.images().discoveryHex();
    }
}