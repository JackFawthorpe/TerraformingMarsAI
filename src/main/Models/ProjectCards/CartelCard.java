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

public class CartelCard extends BaseCard {

    public CartelCard(CardManager cm) {
        cardManager = cm;
        cost = 8;
        tags = new ArrayList<>(Arrays.asList(Tag.EARTH));
        title = "Cartel";
        dlc = DLC.CORPORATE;
    }

    @Override
    public boolean canPlayCard() {
        return super.canPlayCard();
    }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.CREDIT_PRODUCTION, owner.getTagCount(Tag.EARTH, true) + 1);
        pt.execute();
    }
}
