package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.PlayerAction;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.PlayerTransaction;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerPlantCard extends BaseCard {
    public PowerPlantCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Power Plant";
        cost = 4;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.POWER, Tag.BUILDING));
        playCardAction = PlayerAction.PC_POWER_PLANT;
    }

    @Override
    public boolean canPlayCard(){ return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.ENERGY_PRODUCTION, 1);
        pt.execute();
    }
}
