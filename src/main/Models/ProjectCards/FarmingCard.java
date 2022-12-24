package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.PlayerTransaction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FarmingCard extends BaseCard {
    public FarmingCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Farming";
        cost = 16;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.PLANT));
    }

    @Override
    public boolean canPlayCard(){
        return super.canPlayCard() &&
                cardManager.getGlobalRequirementsRef().getTemperature() >= 4;
    }

    @Override
    public int getVictoryPointCount() { return 2; }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.CREDIT_PRODUCTION, 2);
        pt.addResource(Resource.PLANT_PRODUCTION, 2);
        pt.addResource(Resource.PLANTS, 2);
        pt.execute();
    }
}
