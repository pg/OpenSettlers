package soc.gwtClient.lobby;

import soc.common.game.Game;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class GameCell extends AbstractCell<Game>
{

    @Override
    public void render(com.google.gwt.cell.client.Cell.Context context,
            Game value, SafeHtmlBuilder sb)
    {
        sb.append(SafeHtmlUtils.fromString(value.getGameSettings().getName()));
    }

}
