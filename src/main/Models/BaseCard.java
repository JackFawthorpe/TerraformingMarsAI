package main.Models;

import main.Enums.PlayerActions;
import main.Enums.Tags;
import main.Exceptions.InvalidActionException;

import java.util.ArrayList;
import java.util.List;

/**
 * Base card for all project cards
 */
public abstract class BaseCard {

    /**
     * Title of the card
     */
    private String title;

    /**
     * Tags on the card
     */
    private List<Tags> tags;

    /**
     * If the card has an action
     * Must be overwritten within the child class
     */
    private boolean blueAction = false;

    /**
     * The amount of gold it costs to play this card
     */
    private int cost;

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
    public final List<Tags> getTags() {
        return this.tags;
    }

    /**
     * @param tags Tags given by the child class
     */
    protected final void setTags(List<Tags> tags) {
        this.tags = tags;
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
    public List<PlayerActions> getPotentialActions() {
        return new ArrayList<PlayerActions>();
    }

    /**
     * Given the action to execute, the overriding function will run the logic for the action
     * This function is meant to be overridden
     * @param action The action to execute
     */
    public void runBlueAction(PlayerActions action) throws InvalidActionException {
        throw new InvalidActionException(action + " cannot be thrown from " + this.getClass().getName());
    }

    /**
     * @return A boolean for if the card is currently available for the player to play
     */
    abstract public boolean canPlayCard();

    /**
     * Called from Card manager to run the cards immediate effect
     */
    abstract public void runImmediateEffect();

}
