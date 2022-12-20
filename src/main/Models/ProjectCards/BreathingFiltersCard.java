package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.PlayerTransaction;

import java.util.ArrayList;
import java.util.Arrays;

public class BreathingFiltersCard extends BaseCard {

    public BreathingFiltersCard(CardManager cardManager) {
        this.cardManager = cardManager;
        title = "Breathing Filters";
        tags = new ArrayList<Tag>(Arrays.asList(Tag.SCIENCE));
        cost = 11;
        dlc = DLC.BASE;
    }

    @Override
    public int getVictoryPointCount() {
        return 2;
    }

    public boolean canPlayCard() {
        return super.canPlayCard() &&
                cardManager.getGlobalRequirementsRef().getOxygen() >= 7;
    }

    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.execute();
    }
}
