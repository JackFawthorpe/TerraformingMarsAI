package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.Player;
import main.Models.PlayerTransaction;

import java.util.ArrayList;
import java.util.Arrays;

public class TectonicStressPowerCard extends BaseCard {

    public TectonicStressPowerCard (CardManager cm) {
        cardManager = cm;
        title = "Tectonic Stress Power";
        cost = 18;
        dlc = DLC.BASE;
        tags = new ArrayList<>(Arrays.asList(Tag.POWER, Tag.BUILDING));
    }

    @Override
    public int getVictoryPointCount() {
        return 1;
    }

    @Override
    public boolean canPlayCard() {
        return super.canPlayCard() &&
                owner.getTagCount(Tag.SCIENCE, true) >= 2;
    }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.ENERGY_PRODUCTION, 3);
        pt.execute();
    }
}
