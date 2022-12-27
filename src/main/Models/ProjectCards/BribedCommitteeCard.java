package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.PlayerAction;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.Player;
import main.Models.PlayerTransaction;

import java.util.ArrayList;
import java.util.Arrays;

public class BribedCommitteeCard extends BaseCard {
    public BribedCommitteeCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Bribed Committee";
        cost = 7;
        dlc = DLC.CORPORATE;
        this.tags = new ArrayList<Tag>(Arrays.asList(Tag.EARTH, Tag.EVENT));
        playCardAction = PlayerAction.PC_BRIBED_COMMITTEE;
    }

    @Override
    public int getVictoryPointCount(){ return -2; }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.TERRAFORMING_RATING, 2);
        pt.execute();
    }
}
