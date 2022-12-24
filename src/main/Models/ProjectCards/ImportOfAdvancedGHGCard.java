package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.PlayerTransaction;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ImportOfAdvancedGHGCard extends BaseCard {
    public ImportOfAdvancedGHGCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Import of Advanced GHG";
        cost = 9;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.EARTH, Tag.SPACE, Tag.EVENT));
    }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.HEAT_PRODUCTION, 2);
        pt.execute();
    }
}
