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

public class LichenCard extends BaseCard {
    public LichenCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Lichen";
        cost = 7;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.PLANT));
    }

    @Override
    public boolean canPlayCard(){
        return super.canPlayCard() &&
                cardManager.getGlobalRequirementsRef().getTemperature() >= -24;
    }
    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.PLANT_PRODUCTION, 1);
        pt.execute();
    }
}
