package main.Managers;

import main.Models.BaseCard;
import main.Models.GlobalRequirements;
import main.Models.ProjectCards.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This should be the only class that interacts with cards directly
 * If we want to keep track of card usage then all usage of cards has to be directed through here
 */
public class CardManager {

    /**
     * This games global requirements
     */
    GlobalRequirements globalRequirementsRef;

    /**
     * The deck of cards where cards are drawn from
     */
    ArrayList<BaseCard> mainDeck;

    public CardManager(GlobalRequirements gr) {
        globalRequirementsRef = gr;
        generateDeck(true, true, true);
    }

    /**
     * @return Returns reference to the games global requirements
     */
    public GlobalRequirements getGlobalRequirementsRef() {
        return globalRequirementsRef;
    }

    public List<BaseCard> getMainDeck() {
        return mainDeck;
    }

    /**
     * Generates the deck for play
     * @param base If base cards are enabled
     * @param corporate If Corperate Cards are enabled
     * @param prelude If Prelude cards are enabled
     */
    private void generateDeck(boolean base, boolean corporate, boolean prelude) {
        mainDeck = new ArrayList<BaseCard>();
        if (base) {
            mainDeck.add(new BreathingFiltersCard(this));
            mainDeck.add(new LunarBeamCard(this));
        }

        if (corporate) {
            mainDeck.add(new AcquiredCompanyCard(this));
            mainDeck.add(new BribedCommitteeCard(this));
            mainDeck.add(new InvestmentLoanCard(this));
            mainDeck.add(new SponsorsCard(this));
            mainDeck.add(new TitaniumMineCard(this));
            mainDeck.add(new TransNeptuneProbeCard(this));
            mainDeck.add(new VestaShipyardCard(this));
        }

        if (prelude) {

        }
    }

}
