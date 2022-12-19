package main.Models;

import java.util.HashMap;

import main.Enums.Tag;
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
     * Containts key value pairs of each of the tags that the player has played
     */
    private HashMap<Tag, Integer> tagCounts;

    /**
     * Default constructor for player
     */
    public Player() {

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
     * Changes how much of a given resource the player has
     * @param resource The resource to change
     * @param change The amount it should change by
     */
    public void changeResourceCount(Resource resource, int change) {
        resourceCounts.replace(resource, resourceCounts.get(resource) + change);
    }


}
