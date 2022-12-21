package main.Models.ProjectCards;

import main.Enums.DLC;
import main.Enums.Resource;
import main.Enums.Tag;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.PlayerTransaction;

import java.awt.desktop.UserSessionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class MineralDepositCard extends BaseCard {
    public MineralDepositCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Mineral Deposit";
        dlc = DLC.CORPORATE;
        cost = 5;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.EVENT));
    }

    @Override
    public boolean canPlayCard() { return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.STEEL, 5);
        pt.execute();
    }
}
