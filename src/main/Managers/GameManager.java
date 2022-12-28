package main.Managers;

import main.Models.GlobalRequirements;

public class GameManager {

    private CardManager cardManager;
    private PlayerManager playerManager;
    private BoardManager boardManager;
    private GlobalRequirements globalRequirements;
    private int generation;

    public GameManager(boolean headless) {
        globalRequirements = new GlobalRequirements();
        cardManager = new CardManager(globalRequirements, true, true, true);
        playerManager = new PlayerManager(3, headless);
        boardManager = new BoardManager();
        generation = 1;
        while (!globalRequirements.gameFinished()) {
            // Draw Cards
            playerManager.playTurns();
            playerManager.playProduction();
        }
    }

}
