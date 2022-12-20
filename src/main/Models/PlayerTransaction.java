package main.Models;

import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage the changing of player stats
 */
public class PlayerTransaction {

    /**
     * By how much the stat should change
     */
    private final List<Integer> changeCountList;

    /**
     * What resource should be changed
     */
    private final List<Resource> resourceList;

    /**
     * List of tags to add in the transaction
     */
    private final List<Tag> tagList;


    /**
     * The player that is going to gain / lose given resource
     */
    private final Player targetPlayer;

    /**
     * String to represent the cause of this transaction
     */
    private final String trigger;

    /**
     * @return Returns the cause of the transaction
     */
    public String getTrigger() {
        return trigger;
    }

    /**
     * Constructor
     * @param targetPlayer The target for the resource change
     * @param trigger String explaining what caused this resource transaction
     */

    public PlayerTransaction(Player targetPlayer, String trigger) {
        this.targetPlayer = targetPlayer;
        this.trigger = trigger;
        this.resourceList = new ArrayList<Resource>();
        this.changeCountList = new ArrayList<Integer>();
        this.tagList = new ArrayList<Tag>();
    }

    /**
     * Adds a resource to the transaction
     */
    public void addResource(Resource resource, int change) {
        this.resourceList.add(resource);
        this.changeCountList.add(change);
    }

    public void addTag(Tag tag) {
        tagList.add(tag);
    }

    /**
     * Checks that the player has the resources to lose before losing them
     * @return Returns whether the resourceTransaction can execute
     */
    public boolean canExecute() {
        for (int i = 0; i < resourceList.size(); i++) {
            if (resourceList.get(i) != Resource.CREDIT_PRODUCTION && targetPlayer.getResourceCount(resourceList.get(i)) + changeCountList.get(i) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Runs the transaction
     */
    public void execute() throws InvalidPlayerTransactionException {
        if (!canExecute()) {
            throw new InvalidPlayerTransactionException("Attempeted to execute when not executable, Suggest adding a canExecute call before this");
        }

        for (int i = 0; i < resourceList.size(); i++) {
            targetPlayer.changeResourceCount(resourceList.get(i), changeCountList.get(i));
        }

        for (Tag tag : tagList) {
            targetPlayer.addTag(tag);
        }
    }
}
