package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.PlayerAction;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.PlayerTransaction;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;

public class InsectsCard extends BaseCard {
    public InsectsCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Insects";
        cost = 9;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.MICROBE));
        playCardAction = PlayerAction.PC_INSECTS;
    }

    @Override
    public boolean canPlayCard(){
        return super.canPlayCard() &&
                cardManager.getGlobalRequirementsRef().getOxygen() >= 6;
    }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        int tagCount = owner.getTagCount(Tag.PLANT, true);
        pt.addResource(Resource.PLANT_PRODUCTION, 1);
        pt.execute();
    }
}
