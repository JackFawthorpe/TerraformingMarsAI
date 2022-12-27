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

public class MedicalLabCard extends BaseCard {
    public MedicalLabCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Medical Lab";
        cost = 13;
        dlc = DLC.CORPORATE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.SCIENCE, Tag.BUILDING));
        playCardAction = PlayerAction.PC_MEDICAL_LAB;
    }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public int getVictoryPointCount() { return 1; }
    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        int tagCount = owner.getTagCount(Tag.BUILDING, true) / 2;
        pt.addResource(Resource.CREDIT_PRODUCTION, tagCount);
        pt.execute();
    }
}
