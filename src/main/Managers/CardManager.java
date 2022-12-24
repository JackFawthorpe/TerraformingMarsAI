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
    List<BaseCard> mainDeck;

    public CardManager(GlobalRequirements gr) {
        globalRequirementsRef = gr;
        mainDeck = generateDeck(true, true, true, this);
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
    public static List<BaseCard> generateDeck(boolean base, boolean corporate, boolean prelude, CardManager manager) {
        List<BaseCard> deck = new ArrayList<BaseCard>();
        if (base) {
            deck.add(new AsteroidMiningCard(manager));
            deck.add(new BreathingFiltersCard(manager));
            deck.add(new FarmingCard(manager));
            deck.add(new FoodFactoryCard(manager));
            deck.add(new GrassCard(manager));
            deck.add(new ImportOfAdvancedGHGCard(manager));
            deck.add(new LunarBeamCard(manager));
            deck.add(new PowerGridCard(manager));
            deck.add(new SolarPowerCard(manager));
            deck.add(new SolettaCard(manager));
            deck.add(new StripMineCard(manager));
        }

        if (corporate) {
            deck.add(new AcquiredCompanyCard(manager));
            deck.add(new BribedCommitteeCard(manager));
            deck.add(new BuildingIndustriesCard(manager));
            deck.add(new CartelCard(manager));
            deck.add(new FuelFactoryCard(manager));
            deck.add(new InvestmentLoanCard(manager));
            deck.add(new MedicalLabCard(manager));
            deck.add(new MineralDepositCard(manager));
            deck.add(new MirandaResortCard(manager));
            deck.add(new SatellitesCard(manager));
            deck.add(new SponsorsCard(manager));
            deck.add(new TitaniumMineCard(manager));
            deck.add(new TransNeptuneProbeCard(manager));
            deck.add(new VestaShipyardCard(manager));
        }

        if (prelude) {

        }

        return deck;
    }

}
