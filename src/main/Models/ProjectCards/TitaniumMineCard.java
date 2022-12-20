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

public class TitaniumMineCard extends BaseCard {
    public TitaniumMineCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Titanium Mine";
        dlc = DLC.CORPORATE;
        this.tags = new ArrayList<>(Arrays.asList(Tag.BUILDING));
    }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.TITANIUM_PRODUCTION, 1);
        pt.execute();
    }

    @Override
    public boolean canPlayCard() {return super.canPlayCard();}
}
