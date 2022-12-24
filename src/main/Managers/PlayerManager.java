package main.Managers;

import main.Models.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    List<Player> players;

    public PlayerManager(int playerCount, boolean headless) {
        players = new ArrayList<Player>();
        players.add(new Player(headless));
        for (int i = 1; i < playerCount; i++) {
            players.add(new Player(true));
        }
    }

}
