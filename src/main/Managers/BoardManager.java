package main.Managers;

import main.Enums.Resource;
import main.Models.Tile;

import java.util.ArrayList;
import java.util.List;

public class BoardManager {

    private ArrayList<ArrayList<Tile>> mainBoard;
    private Tile phobosSpaceHaven;
    private Tile ganymedeColony;

    private void addResource(int x, int y, Resource resource, int count) {
        mainBoard.get(x).get(y).addResourceBenefit(resource, count);
    }

    public BoardManager() {
        mainBoard = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ArrayList<Tile> row = new ArrayList<>();
            for (int j = 0; j < 9 - Math.abs(5 - (i + 1)); j++) {
                row.add(new Tile());
            }
            mainBoard.add(row);
        }

        addResource(0, 0, Resource.STEEL, 2);
        addResource(0, 1, Resource.STEEL, 2);
        addResource(1, 1, Resource.STEEL, 1);
        addResource(2, 6, Resource.STEEL, 1);
        addResource(3, 0, Resource.PLANTS, 1);
        addResource(3, 0, Resource.TITANIUM, 1);
        addResource(3, 1, Resource.PLANTS, 1);
        addResource(3, 2, Resource.PLANTS, 1);
        addResource(3, 3, Resource.PLANTS, 1);
        addResource(3, 4, Resource.PLANTS, 2);
        addResource(3, 5, Resource.PLANTS, 1);
        addResource(3, 6, Resource.PLANTS, 1);
        addResource(3, 7, Resource.PLANTS, 2);
        for (int i = 0; i < 9; i++) {
            addResource(4, i, Resource.PLANTS, 2);
        }
        for (int i = 0; i < 8; i++) {
            addResource(5, i, Resource.PLANTS, 1);
        }
        addResource(5,1, Resource.PLANTS, 1);
        addResource(6, 5, Resource.PLANTS, 1);
        addResource(7,0, Resource.STEEL, 2);
        addResource(7, 5, Resource.TITANIUM, 1);
        addResource(8, 0, Resource.STEEL, 1);
        addResource(8, 1, Resource.TITANIUM, 2);
        addResource(8, 4, Resource.TITANIUM, 2);

        ganymedeColony = new Tile();
        phobosSpaceHaven = new Tile();
    }

    public List<Tile> getCollapsedBoard() {
        ArrayList<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < mainBoard.size(); i++) {
            for (int j = 0; j < mainBoard.get(i).size(); j++) {
                tiles.add(mainBoard.get(i).get(j));
            }
        }
        tiles.add(phobosSpaceHaven);
        tiles.add(ganymedeColony);

        return tiles;
    }

}
