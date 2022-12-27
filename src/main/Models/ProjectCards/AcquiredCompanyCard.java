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

public class AcquiredCompanyCard extends BaseCard {
    public AcquiredCompanyCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Acquired Company";
        dlc = DLC.CORPORATE;
        cost = 10;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.EARTH));
        playCardAction = PlayerAction.PC_ACQUIRED_COMPANY;
    }

    @Override
    public boolean canPlayCard(){ return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.CREDIT_PRODUCTION, 3);
        pt.execute();
    }
}
