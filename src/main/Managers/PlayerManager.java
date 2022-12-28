package main.Managers;

import main.Models.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private final List<Player> players;
    private int leadPlayerIndex;
    private final int playerCount;



    public PlayerManager(int playerCount, boolean headless) {
        this.playerCount = playerCount;
        players = new ArrayList<Player>();
        players.add(new Player(headless));
        for (int i = 1; i < playerCount; i++) {
            players.add(new Player(true));
        }
        leadPlayerIndex = (int) Math.floor(Math.random() * playerCount);
    }

    public Player getLeadPlayer() {
        return players.get(leadPlayerIndex);
    }

    private int playerCircularShift(int input) {
        return (input + 1) % playerCount;
    }

    public void playTurns() {
        int passCount = 0;
        int currentIndex = leadPlayerIndex;
        while (passCount != playerCount) {
            Player currentPlayer = players.get(currentIndex);
            if (!currentPlayer.getHasPassed()) {
                currentPlayer.runTurn();
                if (currentPlayer.getHasPassed()) {
                    passCount++;
                }
            }
            currentIndex = playerCircularShift(currentIndex);
        }
    }

    public void playProduction() {
        for (Player player : players) {
            player.runProduction();
        }
        leadPlayerIndex = playerCircularShift(leadPlayerIndex);
    }
}
