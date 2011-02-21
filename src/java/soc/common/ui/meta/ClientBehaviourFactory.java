package soc.common.ui.meta;

import soc.gwtClient.game.behaviour.gameWidget.factories.GameBehaviourFactory;
import soc.gwtClient.game.behaviour.gameWidget.factories.ReceiveGameBehaviourFactory;

public interface ClientBehaviourFactory
{
    public ReceiveGameBehaviourFactory getOpponentReceiveBehaviourFactory();

    public ReceiveGameBehaviourFactory getReceiveBehaviourFactory();;

    public GameBehaviourFactory getSendBehaviourFactory();

    public GameBehaviourFactory getNextActionBehaviourFactory();
}
