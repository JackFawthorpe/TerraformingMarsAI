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

public class SolettaCard extends BaseCard {
    public SolettaCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Soletta";
        cost = 35;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.SPACE));
    }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.HEAT_PRODUCTION, 7);
        pt.execute();
    }
}
