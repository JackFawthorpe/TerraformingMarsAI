package main.Models;

import main.Enums.DLC;
import main.Enums.PlayerAction;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidActionException;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Base card for all project cards
 */
public abstract class BaseCard {

    /**
     * Title of the card
     */
    protected String title;

    /**
     * Tags on the card
     */
    protected List<Tag> tags;

    /**
     * The Action associated with playing the card
     */
    protected PlayerAction playCardAction;

    /**
     * If the card has an action
     * Must be overwritten within the child class
     */
    protected boolean blueAction = false;

    /**
     * The amount of gold it costs to play this card
     */
    protected Integer cost;

    /**
     * Owner of Card
     */
    protected Player owner;
    
    /**
    * The DLC this card belongs to
    */
    protected DLC dlc;

    /**
     * Reference to the card manager
     */
    protected CardManager cardManager;

    /**
     * @return The cost of the card
     */
    public final int getCost() {
        return this.cost;
    }

    /**
     * @param cost The new cost of the card
     */
    protected final void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @return The title of the card
     */
    public final String getTitle() {
        return title;
    }

    /**
     * @param title The new title
     */
    protected final void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return List of tags that are on the card (Duplicates allowed)
     */
    public final List<Tag> getTags() {
        return this.tags;
    }

    /**
     * @param tags Tags given by the child class
     */
    protected final void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public DLC getDLC() {
        return dlc;
    }

    public CardManager getManager() {
        return cardManager;
    }

    /**
     * @return Owner of this card
     */
    public final Player getOwner(){
        return this.owner;
    }

    /**
     * @param owner The new owner
     */
    public final void setOwner(Player owner){
        this.owner = owner;
    }

    /**
     * Returns the amount of victory points that are awarded for this card, default is 0
     * but could be overwritten with function
     * @return Victory point count
     */
    public int getVictoryPointCount() {
        return 0;
    }

    /**
     * @return Boolean for if the card has playable actions
     */
    public final boolean hasBlueAction() {
        return this.blueAction;
    }

    /**
     * @param blueAction sets blueAction to the new blueAction
     */
    protected final void setBlueAction(boolean blueAction) {
        this.blueAction = blueAction;
    }

    /**
     * @return Every possible action of this card given the current game state
     */
    public List<PlayerAction> getPotentialActions() {
        return new ArrayList<PlayerAction>();
    }

    public PlayerAction getPlayCardAction() {
        return playCardAction;
    }

    /**
     * Given the action to execute, the overriding function will run the logic for the action
     * This function is meant to be overridden
     * @param action The action to execute
     */
    public void runBlueAction(PlayerAction action) throws InvalidActionException {
        throw new InvalidActionException(action + " cannot be thrown from " + this.getClass().getName());
    }

    /**
     * Basecard checks for ownership and that the owner has enough money
     * @return A boolean for if the card is currently available for the player to play
     */
    protected boolean canPlayCard() {
        return owner != null && cost <= owner.getResourceCount(Resource.CREDITS);
    }

    abstract public void runImmediateEffect() throws InvalidPlayerTransactionException;
    
    /**
     * Called from Card manager to run the cards immediate effect
     */
    protected PlayerTransaction getImmediateEffectPT() {
        PlayerTransaction pt = new PlayerTransaction(owner, title);
        pt.addResource(Resource.CREDITS, -cost);
        for (Tag tag : tags) {
            pt.addTag(tag);
        }
        return pt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {return true;}
        try {
            return this.title.equals(((BaseCard) o).getTitle());
        } catch (Exception e) {
            return false;
        }
    }
}