package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.PlayerTransaction;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.Arrays;

public class VestaShipyardCard extends BaseCard {
    public VestaShipyardCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Vesta Shipyard";
        cost = 15;
        dlc = DLC.CORPORATE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.JOVIAN, Tag.SPACE));
    }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public int getVictoryPointCount() { return 1; }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = runImmediateEffect();
        pt.addResource(Resource.TITANIUM_PRODUCTION, 1);
        pt.execute();
    }
}
