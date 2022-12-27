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

public class MethaneFromTitanCard extends BaseCard {
    public MethaneFromTitanCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Methane From Titan";
        cost = 28;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.JOVIAN, Tag.SPACE));
    }

    @Override
    public boolean canPlayCard(){
        return super.canPlayCard() &&
                cardManager.getGlobalRequirementsRef().getOxygen() >= 2;
    }

    @Override
    public int getVictoryPointCount(){ return 2; }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.HEAT_PRODUCTION, 2);
        pt.addResource(Resource.PLANT_PRODUCTION, 2);
        pt.execute();
    }
}
