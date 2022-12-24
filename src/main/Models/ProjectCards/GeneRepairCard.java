package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Managers.PlayerManager;
import main.Models.BaseCard;
import main.Models.PlayerTransaction;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneRepairCard extends BaseCard {
    public GeneRepairCard(CardManager cardManager) {
        this.cardManager = cardManager;
        title = "Gene Repair";
        cost = 12;
        dlc = DLC.CORPORATE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.SCIENCE));
    }

    @Override
    public boolean canPlayCard(){
        return super.canPlayCard() &&
                owner.getTagCount(Tag.SCIENCE, true) >= 3;
    }

    @Override
    public int getVictoryPointCount() { return 2; }
    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.CREDIT_PRODUCTION, 2);
        pt.execute();
    }
}
