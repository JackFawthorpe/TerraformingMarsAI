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

public class LunarBeamCard extends BaseCard {
    public LunarBeamCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "LunarBeamCard";
        cost = 13;
        dlc = DLC.BASE;
        this.tags = new ArrayList<Tag>(Arrays.asList(Tag.EARTH, Tag.POWER));
    }


    @Override
    public boolean canPlayCard() {
        return super.canPlayCard();
    }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.CREDIT_PRODUCTION, -2);
        pt.addResource(Resource.ENERGY_PRODUCTION, 2);
        pt.addResource(Resource.HEAT_PRODUCTION, 2);
        pt.execute();
    }
}
