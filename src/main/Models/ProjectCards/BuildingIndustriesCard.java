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

public class BuildingIndustriesCard extends BaseCard {
    public BuildingIndustriesCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Building Industries";
        cost = 6;
        dlc = DLC.CORPORATE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.BUILDING));
    }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.ENERGY_PRODUCTION, -1);
        pt.addResource(Resource.STEEL_PRODUCTION, 2);
        pt.execute();
    }
}
