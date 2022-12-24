package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.Player;
import main.Models.PlayerTransaction;

import java.util.ArrayList;
import java.util.Arrays;

public class MirandaResortCard extends BaseCard {
    public MirandaResortCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Miranda Resort";
        cost = 12;
        dlc = DLC.CORPORATE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.JOVIAN, Tag.SPACE));
    }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public int getVictoryPointCount() { return 1; }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        int tagCount = owner.getTagCount(Tag.EARTH, true);
        pt.addResource(Resource.CREDIT_PRODUCTION, tagCount);
        pt.execute();
    }
}
