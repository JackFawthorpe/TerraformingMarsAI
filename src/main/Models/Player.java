package main.Models;

import java.util.HashMap;

import main.Enums.Resource;

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
     * Default constructor for player
     */
    public Player() {
        Resource resources[] = Resource.values();
        for (Resource resource: resources) {
            resourceCounts.put(resource, 0);
        }
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
     * Changes how much of a given resource the player has
     * @param resource The resource to change
     * @param change The amount it should change by
     */
    public void changeResourceCount(Resource resource, int change) {
        resourceCounts.replace(resource, resourceCounts.get(resource) + change);
    }

}
