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

public class FoodFactoryCard extends BaseCard {
    public FoodFactoryCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Food Factory";
        dlc = DLC.BASE;
        cost = 12;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.BUILDING));
    }

    @Override
    public boolean canPlayCard(){ return super.canPlayCard(); }

    @Override
    public int getVictoryPointCount(){ return 1; }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.PLANT_PRODUCTION, -1);
        pt.addResource(Resource.CREDIT_PRODUCTION, 4);
        pt.execute();
    }
}
