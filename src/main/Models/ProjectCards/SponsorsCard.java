package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.PlayerTransaction;

import java.util.ArrayList;

public class SponsorsCard extends BaseCard {
    public SponsorsCard(CardManager cardManager) {
        this.cardManager = cardManager;
        title = "Sponsors";
        ArrayList<Tag> tags = new ArrayList<Tag>();
        tags.add(Tag.EARTH);
        this.tags = tags;
        dlc = DLC.CORPORATE;
    }

    @Override
    public boolean canPlayCard() {
        return super.canPlayCard();
    }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.CREDIT_PRODUCTION, 2);
        pt.execute();
    }
}
