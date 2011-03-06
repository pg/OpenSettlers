package soc.common.actions.gameAction.turns;

import soc.common.actions.gameAction.AbstractGameAction;
import soc.common.game.Game;
import soc.common.game.phases.GamePhase;
import soc.common.game.phases.turnPhase.TurnPhase;
import soc.common.game.player.GamePlayer;
import soc.common.internationalization.I18n;
import soc.common.views.behaviour.gameWidget.GameBehaviour;
import soc.common.views.behaviour.gameWidget.factories.GameBehaviourFactory;
import soc.common.views.behaviour.gameWidget.factories.ReceiveGameBehaviourFactory;
import soc.common.views.behaviour.gameWidget.received.ReceiveGameBehaviour;
import soc.common.views.meta.Icon;
import soc.common.views.meta.IconImpl;
import soc.common.views.meta.Meta;
import soc.common.views.widgetsInterface.actions.ActionWidget;
import soc.common.views.widgetsInterface.actions.ActionWidgetFactory;

public class StartingPlayerDetermined extends AbstractGameAction
{
    private static final long serialVersionUID = 4916570503194938187L;
    private static transient Meta meta = new Meta()
    {
        private Icon icon = new IconImpl(null, null, null, null);

        @Override
        public Icon icon()
        {
            return icon;
        }

        @Override
        public String getName()
        {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getLocalizedName()
        {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getDescription()
        {
            // TODO Auto-generated method stub
            return null;
        }

    };
    private int diceRoll;
    private GamePlayer gameStarter;

    /** @return the gameStarter */
    public GamePlayer getGameStarter()
    {
        return gameStarter;
    }

    /** @param gameStarter
     *            the gameStarter to set */
    public StartingPlayerDetermined setGameStarter(GamePlayer gameStarter)
    {
        this.gameStarter = gameStarter;

        return this;
    }

    /** @return the diceRoll */
    public int getDiceRoll()
    {
        return diceRoll;
    }

    /** @param diceRoll
     *            the diceRoll to set */
    public StartingPlayerDetermined setDiceRoll(int diceRoll)
    {
        this.diceRoll = diceRoll;
        return this;
    }

    @Override
    public boolean isAllowed(TurnPhase turnPhase)
    {
        return false;
    }

    @Override
    public boolean isAllowed(GamePhase gamePhase)
    {
        return gamePhase.isDetermineFirstPlayer();
    }

    @Override
    public String getToDoMessage()
    {
        return I18n.get().actions().noToDo();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * soc.common.actions.gameAction.AbstractGameAction#perform(soc.common.game
     * .Game)
     */
    @Override
    public void perform(Game game)
    {
        // TODO: It would be nice if players are re-ordered such that the
        // highroller starts, and the player after the highroller comes second,
        // etc.
        game.setStartPlayer(gameStarter);
        game.advanceTurn();
        message = "Starting player determined: "
                        + game.getStartPlayer().getUser().getName();
        super.perform(game);
    }

    @Override
    public ActionWidget createActionWidget(
                    ActionWidgetFactory actionWidgetFactory)
    {
        return null;
    }

    @Override
    public GameBehaviour getNextActionBehaviour(
                    GameBehaviourFactory gameBehaviourFactory)
    {
        return gameBehaviourFactory
                        .createStartingPlayerDeterminedBehaviour(this);
    }

    @Override
    public ReceiveGameBehaviour getOpponentReceiveBehaviour(
                    ReceiveGameBehaviourFactory receiveGameBehaviourFactory)
    {
        return receiveGameBehaviourFactory
                        .createStartingPlayerDeterminedBehaviour(this);
    }

    @Override
    public ReceiveGameBehaviour getReceiveBehaviour(
                    ReceiveGameBehaviourFactory receiveGameBehaviourFactory)
    {
        return receiveGameBehaviourFactory
                        .createStartingPlayerDeterminedBehaviour(this);
    }

    @Override
    public GameBehaviour getSendBehaviour(
                    GameBehaviourFactory gameBehaviourFactory)
    {
        return gameBehaviourFactory
                        .createStartingPlayerDeterminedBehaviour(this);
    }

    @Override
    public Meta getMeta()
    {
        return meta;
    }

}
