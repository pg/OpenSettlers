package soc.gwtClient.game.widgets.standard.bitmap.actions;

import soc.common.actions.gameAction.turnActions.AbstractTurnAction;
import soc.common.actions.gameAction.turnActions.EndTurn;
import soc.common.game.GamePhaseChangedEvent;
import soc.common.game.GamePhaseChangedEventHandler;
import soc.common.game.TurnChangedEvent;
import soc.common.game.TurnChangedEventHandler;
import soc.common.game.gamePhase.turnPhase.TurnPhaseChangedEvent;
import soc.common.game.gamePhase.turnPhase.TurnPhaseChangedHandler;
import soc.common.game.player.GamePlayer;
import soc.gwtClient.game.abstractWidgets.AbstractActionWidget;
import soc.gwtClient.game.abstractWidgets.GamePanel;
import soc.gwtClient.images.Resources;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class EndTurnBitmapWidget extends AbstractActionWidget implements
        GamePhaseChangedEventHandler, TurnChangedEventHandler,
        TurnPhaseChangedHandler
{
    public PushButton btnEndTurn = new PushButton(new Image(Resources.icons()
            .endTurn()));
    private EndTurn endTurn = new EndTurn();

    public EndTurnBitmapWidget(final GamePanel gamePanel,
            final GamePlayer player)
    {
        super(gamePanel, player);

        endTurn.setPlayer(player);

        gamePanel.getGame().addTurnChangedEventHandler(this);
        gamePanel.getGame().addGamePhaseChangedEventHandler(this);
        gamePanel.getGame().addTurnPhaseChangedHandler(this);

        btnEndTurn.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                gamePanel.startAction((AbstractTurnAction) new EndTurn()
                        .setPlayer(player));
            }
        });
    }

    @Override
    public Widget asWidget()
    {
        return btnEndTurn;
    }

    @Override
    protected void updateEnabled()
    {
        checkEnabled();
    }

    private void enableUI()
    {
        btnEndTurn.setEnabled(true);
    }

    private void disableUI()
    {
        btnEndTurn.setEnabled(false);
    }

    private void checkEnabled()
    {
        if (enabled && player.isOnTurn())
        {
            if (gamePanel.getGame().isAllowed(endTurn))
            {
                enableUI();
                return;
            }
        }

        disableUI();
    }

    @Override
    public void onGamePhaseChanged(GamePhaseChangedEvent event)
    {
        checkEnabled();
    }

    @Override
    public void onTurnChanged(TurnChangedEvent event)
    {
        checkEnabled();
    }

    @Override
    public void onTurnPhaseChanged(TurnPhaseChangedEvent event)
    {
        checkEnabled();
    }
}
