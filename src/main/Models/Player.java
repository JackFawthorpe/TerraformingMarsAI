package main.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.Enums.PlayerAction;
import main.Enums.Tag;
import main.Enums.Resource;
import main.PlayerControl.AIController;
import main.PlayerControl.HumanController;
import main.PlayerControl.PlayerController;

/**
 * Model class to store player information
 */
public class Player {

    /**
     * Contains key value pairs of the resources in the game and how much
     * of each resource the player has
     */
    private HashMap<Resource, Integer> resourceCounts;

    /**
     * Containts key value pairs of each of the tags that the player has played
     */
    private HashMap<Tag, Integer> tagCounts;

    PlayerController controller;

    private boolean hasPassed;

    /**
     * Default constructor for player
     */
    public Player(boolean isAI) {

        if (isAI) {
            controller = new AIController();
        } else {
            controller = new HumanController();
        }

        resourceCounts = new HashMap<Resource, Integer>();
        tagCounts = new HashMap<Tag, Integer>();

        Resource resources[] = Resource.values();
        for (Resource resource: resources) {
            resourceCounts.put(resource, 0);
        }

        Tag tags[] = Tag.values();
        for (Tag tag: tags) {
            tagCounts.put(tag, 0);
        }

        hasPassed = false;
    }

    public boolean getHasPassed() {
        return hasPassed;
    }

    /**
     * Access function to see how much of a resource the player has
     * @param resource The resource thats being queried
     * @return The count of said resource
     */
    public int getResourceCount(Resource resource) {
        return resourceCounts.get(resource);
    }

    /**
     * Gets the amount of tags of given type
     * @param tag The tag thats being requested
     * @param wildTagIncluded Whether the wild tag should also be considered
     */
    public int getTagCount(Tag tag, boolean wildTagIncluded) {
        return wildTagIncluded && tag != Tag.WILD ? tagCounts.get(tag)  + tagCounts.get(Tag.WILD) : tagCounts.get(tag);
    }

    /**
     * Adds a tag to the players inventory
     * @param tag The tag to increment
     */
    public void addTag(Tag tag) {
        tagCounts.replace(tag, tagCounts.get(tag) + 1);
    }

    /**
     * Changes how much of a given resource the player has
     * @param resource The resource to change
     * @param change The amount it should change by
     */
    public void changeResourceCount(Resource resource, int change) {
        resourceCounts.replace(resource, resourceCounts.get(resource) + change);
    }

    public void runTurn() {
        // Generate possible actions
        List<PlayerAction> potentialActions = new ArrayList<PlayerAction>();

        //PC
        //SP
        //CM
        //FA
        //UA
        //CR
        //PA

        // Query controller
        controller.pickAction(potentialActions);

        // Run Action
    }

    public void runProduction() {
        PlayerTransaction pt = new PlayerTransaction(this, "Production");
        pt.addResource(Resource.CREDITS, this.getResourceCount(Resource.CREDIT_PRODUCTION) + this.getResourceCount(Resource.TERRAFORMING_RATING));
        pt.addResource(Resource.STEEL, this.getResourceCount(Resource.STEEL_PRODUCTION));
        pt.addResource(Resource.TITANIUM, this.getResourceCount(Resource.TITANIUM_PRODUCTION));
        pt.addResource(Resource.PLANTS, this.getResourceCount(Resource.PLANT_PRODUCTION));
        pt.addResource(Resource.HEAT, this.getResourceCount(Resource.ENERGY) + this.getResourceCount(Resource.HEAT_PRODUCTION));
        pt.addResource(Resource.ENERGY, -this.getResourceCount(Resource.ENERGY) + this.getResourceCount(Resource.ENERGY_PRODUCTION));
        try {
            pt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
