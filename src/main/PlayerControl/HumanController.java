package main.PlayerControl;

import main.Enums.PlayerAction;

import java.util.List;

public class HumanController implements PlayerController {
    public PlayerAction pickAction(List<PlayerAction> actions) {
        // TODO
        return PlayerAction.PA_PASS;
    }
}