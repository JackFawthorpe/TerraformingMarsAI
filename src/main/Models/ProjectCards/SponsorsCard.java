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

public class SponsorsCard extends BaseCard {
    public SponsorsCard(CardManager cardManager) {
        this.cardManager = cardManager;
        title = "Sponsors";
        tags = new ArrayList<Tag>(Arrays.asList(Tag.EARTH));
        cost = 6;
        dlc = DLC.CORPORATE;
        playCardAction = PlayerAction.PC_SPONSORS;
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
