package soc.gwtClient.game.abstractWidgets;

import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.IsWidget;

public interface IGameBoardWidget extends IsWidget
{
    public ComplexPanel createRootPanel();
}
