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

public class SatellitesCard extends BaseCard {
    public SatellitesCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Satellites";
        cost = 10;
        dlc = DLC.CORPORATE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.SPACE));
        playCardAction = PlayerAction.PC_SATELLITES;
    }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        int tagCount = owner.getTagCount(Tag.SPACE, true) + 1;
        pt.addResource(Resource.CREDIT_PRODUCTION, tagCount);
        pt.execute();
    }
}
