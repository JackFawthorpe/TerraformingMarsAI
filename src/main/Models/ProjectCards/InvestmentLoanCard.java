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

public class InvestmentLoanCard extends BaseCard {
    public InvestmentLoanCard(CardManager cardManager){
        this.cardManager = cardManager;
        title = "Investment Loan";
        dlc = DLC.CORPORATE;
        cost = 3;
        tags = new ArrayList<Tag>(Arrays.asList(Tag.EARTH, Tag.EVENT));
        playCardAction = PlayerAction.PC_INVESTMENT_LOAN;
    }
    @Override
    public boolean canPlayCard(){ return super.canPlayCard(); }

    @Override
    public void runImmediateEffect() throws InvalidPlayerTransactionException {
        PlayerTransaction pt = getImmediateEffectPT();
        pt.addResource(Resource.CREDIT_PRODUCTION, -1);
        pt.addResource(Resource.CREDITS, 10);
        pt.execute();
    }
}
