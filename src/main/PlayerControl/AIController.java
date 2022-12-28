package main.PlayerControl;

import main.Enums.PlayerAction;

import java.util.List;

public class AIController implements PlayerController {

    public PlayerAction pickAction(List<PlayerAction> actions) {
        return PlayerAction.PA_PASS;
    }

}
