package soc.common.board.chits;

import soc.common.internationalization.I18n;
import soc.common.views.meta.Icon;
import soc.common.views.meta.IconImpl;
import soc.common.views.meta.Meta;
import soc.gwtClient.images.Resources;

public class Chit6 extends AbstractChit
{
    private static final long serialVersionUID = 7264719532207840869L;
    private static Meta meta = new Meta()
    {
        private Icon icon = new IconImpl(Resources.icons().soldier(), null,
                        null, null);

        @Override
        public Icon icon()
        {
            return icon;
        }

        @Override
        public String getName()
        {
            return "Chit6";
        }

        @Override
        public String getLocalizedName()
        {
            return I18n.get().constants().chit6();
        }

        @Override
        public String getDescription()
        {
            return I18n.get().constants().chit6Description();
        }

    };

    @Override
    public Meta getMeta()
    {
        return meta;
    }
    @Override
    public Chit copy()
    {
        return new Chit6();
    }

    @Override
    public int getChance()
    {
        return 6;
    }

    @Override
    public int getNumber()
    {
        return 5;
    }

}
