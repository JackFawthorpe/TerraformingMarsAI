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

public class WormsCard extends BaseCard {
    public WormsCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Worms";
        cost = 8;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.MICROBE));
        playCardAction = PlayerAction.PC_WORMS;
    }

    @Override
    public boolean canPlayCard(){
        return super.canPlayCard() &&
            cardManager.getGlobalRequirementsRef().getOxygen() >= 4;
    }
    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        int tagCount = owner.getTagCount(Tag.MICROBE, true) + 1;
        pt.addResource(Resource.PLANT_PRODUCTION, 1);
        pt.execute();
    }
}
