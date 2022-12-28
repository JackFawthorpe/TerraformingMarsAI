package main.PlayerControl;

import main.Enums.PlayerAction;

import java.util.List;

public interface PlayerController {
    public PlayerAction pickAction(List<PlayerAction> actions);
}
