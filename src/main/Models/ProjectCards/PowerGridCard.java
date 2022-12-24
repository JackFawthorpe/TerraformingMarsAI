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

public class PowerGridCard extends BaseCard {
    public PowerGridCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Power grid";
        cost = 18;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.POWER));
    }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        int tagCount = owner.getTagCount(Tag.POWER, true) + 1;
        pt.addResource(Resource.ENERGY_PRODUCTION, tagCount);
        pt.execute();
    }
}
