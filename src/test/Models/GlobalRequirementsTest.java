package test.Models;

import main.Enums.Resource;
import main.Models.GlobalRequirements;
import main.Models.Player;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GlobalRequirementsTest {

    @Test
    public void oxygenCantPassMaxTest() {
        GlobalRequirements reqs = new GlobalRequirements();
        Player player = new Player();
        for (int i = 0; i < 14; i++) {
            reqs.incrementOxygen(player);
        }
        assertEquals(reqs.getOxygen(), 14);

        int playerTR = player.getResourceCount(Resource.TERRAFORMING_RATING);
        reqs.incrementOxygen(player);
        assertEquals(playerTR, player.getResourceCount(Resource.TERRAFORMING_RATING));
        assertEquals(reqs.getOxygen(), 14);
    }
}
