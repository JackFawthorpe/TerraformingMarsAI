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

public class GrassCard extends BaseCard {
    public GrassCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Grass";
        cost = 11;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.PLANT));
        playCardAction = PlayerAction.PC_GRASS;
    }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.PLANT_PRODUCTION, 1);
        pt.addResource(Resource.PLANTS, 3);
        pt.execute();
    }
}
