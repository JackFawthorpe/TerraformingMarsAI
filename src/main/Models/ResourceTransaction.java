package main.Models;

import main.Enums.PlayerResource;
import main.Exceptions.InvalidResourceTransactionException;

import java.util.ArrayList;

/**
 * Class to manage the changing of player stats
 */
public class ResourceTransaction {

    /**
     * By how much the stat should change
     */
    private final ArrayList<Integer> changeSizeList;

    /**
     * What resource should be changed
     */
    private final ArrayList<PlayerResource> resourceList;

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
     */

    public ResourceTransaction(Player targetPlayer, String trigger) {
        this.targetPlayer = targetPlayer;
        this.trigger = trigger;
        this.resourceList = new ArrayList<PlayerResource>();
        this.changeSizeList = new ArrayList<Integer>();
    }

    /**
     * Adds a resource to the transaction
     */
    public void addResource(PlayerResource resource, int change) {
        this.resourceList.add(resource);
        this.changeSizeList.add(change);
    }

    /**
     * @return Returns whether the resourceTransaction can execute
     */
    public boolean canExecute() {
        return false;
    }

    /**
     * Runs the transaction
     */
    public void execute() throws InvalidResourceTransactionException {
        if (!canExecute()) {
            throw new InvalidResourceTransactionException("Attempeted to execute when not executable");
        }
    }
}
