package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.PlayerTransaction;

import java.util.ArrayList;
import java.util.Arrays;

public class SolarPowerCard extends BaseCard {
    public SolarPowerCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Solar Power";
        dlc = DLC.BASE;
        cost = 11;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.POWER, Tag.BUILDING));
    }

    @Override
    public boolean canPlayCard(){ return super.canPlayCard(); }

    @Override
    public int getVictoryPointCount(){ return 1; }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.ENERGY_PRODUCTION, 1);
        pt.execute();
    }
}
