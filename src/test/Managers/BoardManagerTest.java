package test.Managers;

import main.Managers.BoardManager;
import main.Models.Tile;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardManagerTest {

    @Test
    void testCorrectAmountOfResourcesOnMap() {
        BoardManager bm = new BoardManager();
        List<Tile> tiles = bm.getCollapsedBoard();
        int counter = 0;
        for (Tile tile : tiles) {
            counter += tile.getResourceBenefits().size();
        }
        assertEquals(counter, 53);
    }

}
