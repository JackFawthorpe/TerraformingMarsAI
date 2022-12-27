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

public class FuelFactoryCard extends BaseCard {
    public FuelFactoryCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Fuel Factory";
        cost = 6;
        dlc = DLC.CORPORATE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.BUILDING));
        playCardAction = PlayerAction.PC_FUEL_FACTORY;
    }

    @Override
    public boolean canPlayCard(){ return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.ENERGY_PRODUCTION, -1);
        pt.addResource(Resource.TITANIUM_PRODUCTION, 1);
        pt.addResource(Resource.CREDIT_PRODUCTION, 1);
        pt.execute();
    }
}
