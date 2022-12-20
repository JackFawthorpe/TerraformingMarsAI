package main.Models;

import main.Enums.Resource;

/**
 * Container for globally tracked resources
 * - Oxygen
 * - Temperature
 */
public class GlobalRequirements {

    /**
     * The current temperature of mars
     */
    private int temperature;

    /**
     * The current oxygen percent on mars
     */
    private int oxygen;

    public GlobalRequirements() {
        this.temperature = -30;
        this.oxygen = 0;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getOxygen() {
        return this.oxygen;
    }

    /**
     * Increments the oxygen
     * If Oxygen increments to 8 it also causes a temp increase
     * @param player The player that triggered the increment
     * @return If the change was a success
     */
    public boolean incrementOxygen(Player player) {
        if (oxygen == 14) return false; // At max
        oxygen++;
        PlayerTransaction pt = new PlayerTransaction(player, "Incremented Oxygen");
        pt.addResource(Resource.TERRAFORMING_RATING, 1);
        if (oxygen == 8) {
            incrementTemperature(player);
        }
        try {
            pt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Increases the temperature of mars
     * @param player The player that triggered the change
     * @return If the change was a success
     */
    public boolean incrementTemperature(Player player) {
        if (temperature == 8) return false;
        temperature += 2;
        PlayerTransaction pt = new PlayerTransaction(player, "Incremented Temperature");
        pt.addResource(Resource.TERRAFORMING_RATING, 1);
        if (temperature == -20 || temperature == -24) {
            pt.addResource(Resource.HEAT_PRODUCTION, 1);
        }

        if (temperature == 0) {
            // Place water tile
        }
        try {
            pt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
