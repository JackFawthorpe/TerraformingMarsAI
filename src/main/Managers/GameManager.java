package main.Managers;

import main.Models.GlobalRequirements;

public class GameManager {

    private CardManager cardManager;

    private PlayerManager playerManager;

    private GlobalRequirements globalRequirements;

    public GameManager() {
        globalRequirements = new GlobalRequirements();
        cardManager = new CardManager(globalRequirements);
        playerManager = new PlayerManager();
    }

}
