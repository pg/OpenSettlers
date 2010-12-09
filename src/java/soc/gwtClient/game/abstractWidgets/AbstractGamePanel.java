package soc.gwtClient.game.abstractWidgets;

import soc.common.actions.gameAction.GameAction;
import soc.common.actions.gameAction.turnActions.TurnAction;
import soc.common.board.pieces.PlayerPiece;
import soc.common.client.behaviour.GameBehaviourFactory;
import soc.common.client.behaviour.IBehaviourFactory;
import soc.common.client.behaviour.game.IGameBehaviour;
import soc.common.client.visuals.game.IGameBoardVisual;
import soc.common.game.Game;
import soc.common.game.Player;
import soc.common.server.IGameServerCallback;
import soc.gwtClient.game.ICenterWidget;
import soc.gwtClient.game.dialogs.NewGameDialog;

public abstract class AbstractGamePanel 
    implements IGamePanel, ICenterWidget, IGameServerCallback
{
    protected IServer server;
    protected Game game;
    protected NewGameDialog newGameWindow;
    protected IActionsWidget buildPallette;
    protected IBankStockPanel bankStockPanel;
    protected IBankTradeUI bankTradeUI;
    protected IBehaviourFactory gameBehaviourFactory;
    protected IGameBoardVisual gameVisual;
    protected TurnAction performingAction;
    protected IPlayersWidget playersWidget;
    protected IGameBoardVisual gameBoard;
    
    public AbstractGamePanel(Game game)
    {
        this.game=game;
        
        gameBehaviourFactory = new GameBehaviourFactory();
        
        bankStockPanel = createBankStockPanel();
        buildPallette = createActionsWidget();
        playersWidget = createPlayersWidget();
        gameBoard = createGameBoard(500,500, game.getBoard());
    }
    
    /* (non-Javadoc)
     * @see soc.common.server.IGameServerCallback#receive(soc.common.actions.gameAction.GameAction)
     */
    @Override
    public void receive(GameAction action)
    {
        // perform the action
        game.getCurrentPhase().performAction(action, game);
        
    }
    
    @Override
    public Game getGame()
    {
        return game;
    }

    @Override
    public void performAction(TurnAction turnAction)
    {
        // Create a behaviour based on our action
        IGameBehaviour gameBehaviour = gameBehaviourFactory.createBehaviour(turnAction);
        
        
        if (gameBehaviour == null)
        {
            // no behaviour found for the action, send the action right away
            server.sendAction(turnAction);
        }
        else
        {
            // Tell our GameVisual it needs to display the behaviour
            gameVisual.setBehaviour(gameBehaviour);
            
            // Keep a reference to the action we are currently performing
            performingAction = turnAction;
        }
    }

    @Override
    public void requestBankTrade(PlayerPiece piece, Player player)
    {
        bankTradeUI.setPiece(piece);
        bankTradeUI.show();
    }
}
