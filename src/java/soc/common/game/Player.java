package soc.common.game;

import soc.common.board.pieces.City;
import soc.common.board.pieces.PlayerPiece;
import soc.common.board.pieces.PlayerPieceList;
import soc.common.board.pieces.Town;
import soc.common.board.ports.Port;
import soc.common.board.ports.PortList;
import soc.common.board.resources.Clay;
import soc.common.board.resources.Ore;
import soc.common.board.resources.Resource;
import soc.common.board.resources.ResourceList;
import soc.common.board.resources.Sheep;
import soc.common.board.resources.Timber;
import soc.common.board.resources.Wheat;
import soc.common.game.developmentCards.DevelopmentCard;
import soc.common.game.developmentCards.DevelopmentCardList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends User
{
    // Hand resource cards
    private ResourceList resources;
    
    // Maximum cards the player may have in his hand
    // This is player specific, as a wall may increase this number
    private int maximumCardsInHandWhenSeven;

    // Stock of the player: list of roads, ships, towns, cities, knights etc a 
    // player has in stock
    private PlayerPieceList stock = new PlayerPieceList();
    
    private PlayerPieceList towns = new PlayerPieceList();
    private PlayerPieceList cities = new PlayerPieceList();
    private PlayerPieceList roads = new PlayerPieceList();

    // Keep track of being on turn
    private boolean isOnTurn=false;
    
    // List of ports the player has developed
    private PortList ports;
    
    // Development cards in hand 
    private DevelopmentCardList developmentCards;

    // Played development cards 
    private DevelopmentCardList playedDevelopmentCards;
    
    public void removeResources(ResourceList resources)
    {
        resources.subtractResources(resources);
    }
    
    public void addResources(ResourceList resources)
    {
        resources.addAll(resources);
    }
    
    public void useDevelopmentCard(DevelopmentCard developmentCard)
    {
        // Get rid of the card in our list of devcards 
        developmentCards.remove(developmentCard);
        
        // only place it in stock when we should
        if (developmentCard.keepInStock())
        {
            playedDevelopmentCards.add(developmentCard);
        }
    }
    public void addDevelopmentCard(DevelopmentCard developmentCard)
    {
        developmentCards.add(developmentCard);
    }
    
    public int getDevelopmentCardsCount()
    {
        return developmentCards.size();
    }
    
    public int getResourcesCount()
    {
        return resources.size();
    }
    
    /**
     * @return the isOnTurn
     */
    public boolean isOnTurn()
    {
        return isOnTurn;
    }

    /**
     * @return the stock
     */
    public PlayerPieceList getStock()
    {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public Player setStock(PlayerPieceList stock)
    {
        this.stock = stock;
    
        // Enables fluent interface usage
        // http://en.wikipedia.org/wiki/Fluent_interface
        return this;
    }

    /**
     * @return the towns
     */
    public PlayerPieceList getTowns()
    {
        return towns;
    }

    /**
     * @return the cities
     */
    public PlayerPieceList getCities()
    {
        return cities;
    }

    /**
     * @return the roads
     */
    public PlayerPieceList getRoads()
    {
        return roads;
    }

    /**
     * @return the ports
     */
    public PortList getPorts()
    {
        return ports;
    }

    /**
     * @return the developmentCards
     */
    public DevelopmentCardList getDevelopmentCards()
    {
        return developmentCards;
    }    
    
    /*
     * Returns amount of gold a player can trade for at the bank using given ResourceList
     */
    public int amountGold(ResourceList resourcesToTradeWith)
    {
        return ports.amountGold(resourcesToTradeWith);
    }    
    
    /*
     * Returns amount of gold a player can trade for
     */
    public int amountGold()
    {
        return ports.amountGold(this.resources);
    }
    
    /**
     * @param isOnTurn the isOnTurn to set
     */
    public Player setOnTurn(boolean isOnTurn)
    {
        this.isOnTurn = isOnTurn;
    
        // Enables fluent interface usage
        // http://en.wikipedia.org/wiki/Fluent_interface
        return this;
    }


    public int getMaximumCardsInHandWhenSeven()
    {
        return maximumCardsInHandWhenSeven;
    }

    public void setMaximumCardsInHandWhenSeven(int maximumCardsInHandWhenSeven)
    {
        this.maximumCardsInHandWhenSeven = maximumCardsInHandWhenSeven;
    }

    public ResourceList getResources()
    {
        return resources;
    }

    public void setResources(ResourceList resources)
    {
        this.resources = resources;
    }
    
}
