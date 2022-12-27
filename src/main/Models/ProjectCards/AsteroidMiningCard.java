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

public class AsteroidMiningCard extends BaseCard {
    public AsteroidMiningCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Asteroid Mining";
        cost = 30;
        dlc = DLC.BASE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.JOVIAN, Tag.SPACE));
        playCardAction = PlayerAction.PC_ASTEROID_MINING;
    }

    @Override
    public boolean canPlayCard(){ return super.canPlayCard(); }

    @Override
    public int getVictoryPointCount() { return 2; }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.TITANIUM_PRODUCTION, 2);
        pt.execute();
    }
}
