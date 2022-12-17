package main.Models;

import main.Enums.Tags;

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
    private boolean action = false;

    /**
     * Victory point count for the card
     */
    private int victoryPoints = 0;

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
     * @return Boolean for if the card has an action
     */
    public final boolean hasAction() {
        return this.action;
    }

    /**
     * @return Boolean for if the action on this card can be used
     */
    public boolean canDoAction() {
        return false;
    }

    /**
     * Called from Card manager to run the cards immediate effect
     */
    abstract public void runImmediateEffect();

    /**
     * Returns the amount of victory points that are awarded for this card, default is returning integer
     * but could be overwritten with function
     * @return Victory point count
     */
    public int getVictoryPointCount() {
        return this.victoryPoints;
    }

    /**
     * @return A boolean for if the card is currently available for the player to play
     */
    abstract public boolean canPlayCard();


}
