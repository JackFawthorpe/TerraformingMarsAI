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

public class TransNeptuneProbe extends BaseCard {
    public TransNeptuneProbe(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Trans-Neptune Probe";
        cost = 6;
        dlc = DLC.CORPORATE;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.SCIENCE, Tag.SPACE);
    }

    @Override
    public boolean canPlayCard(){ return super.canPlayCard(); }

    @Override
    public int getVictoryPointCount() { return 1; }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {

    }
}
