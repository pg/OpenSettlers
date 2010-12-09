package soc.gwtClient.game.widgets.standard.bitmap;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

import soc.common.actions.gameAction.turnActions.TurnAction;
import soc.common.game.Player;
import soc.common.game.VictoryPointsChangedEvent;
import soc.common.game.VictoryPointsChangedEventHandler;
import soc.gwtClient.game.abstractWidgets.AbstractActionWidget;
import soc.gwtClient.game.abstractWidgets.IGamePanel;

public class BitmapClaimVictoryWidget extends AbstractActionWidget implements VictoryPointsChangedEventHandler
{
    PushButton btnClaimVictory = new PushButton(new Image("icons/48/Cup48.png"));
    
    public BitmapClaimVictoryWidget(IGamePanel gamePanel, Player player)
    {
        super(gamePanel, player);
        
        player.getVictoryPoints().addVictoryPointsChangedListener(this);
    }

    @Override
    public Widget asWidget()
    {
        return btnClaimVictory;
    }

    @Override
    protected void updateEnabled()
    {
        btnClaimVictory.setEnabled(enabled);
    }

    @Override
    public void onVictoryPointsChanged(VictoryPointsChangedEvent event)
    {
        if (gamePanel.getGame().getGameSettings().getBoardSettings().getVpToWin() >= 
            player.getVictoryPoints().getTotalPoints())
        {
            setEnabled(true);
            return;
        }
        
        setEnabled(false);
    }
}