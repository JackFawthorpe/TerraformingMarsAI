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

public class DesignedMicroorganismsCard extends BaseCard {
    public DesignedMicroorganismsCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Designed Microorganisms";
        cost = 16;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.SCIENCE, Tag.MICROBE));
    }

    @Override
    public boolean canPlayCard() {
        return super.canPlayCard() &&
                cardManager.getGlobalRequirementsRef().getTemperature() <= -14;
    }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.PLANT_PRODUCTION, 2);
        pt.execute();
    }
}
