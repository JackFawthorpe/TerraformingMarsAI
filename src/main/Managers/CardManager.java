package main.Managers;

import main.Models.BaseCard;
import main.Models.GlobalRequirements;
import main.Models.ProjectCards.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    List<BaseCard> discardDeck;

    public CardManager(GlobalRequirements gr, boolean base, boolean corp, boolean prel, boolean testing) {
        globalRequirementsRef = gr;
        mainDeck = generateDeck(base, corp, prel, this);
        if (!testing) {
            Collections.shuffle(mainDeck);
        }
        discardDeck = new ArrayList<BaseCard>();
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
            deck.add(new DesignedMicroorganismsCard(manager));
            deck.add(new FarmingCard(manager));
            deck.add(new FoodFactoryCard(manager));
            deck.add(new GrassCard(manager));
            deck.add(new ImportOfAdvancedGHGCard(manager));
            deck.add(new InsectsCard(manager));
            deck.add(new LichenCard(manager));
            deck.add(new LunarBeamCard(manager));
            deck.add(new MethaneFromTitanCard(manager));
            deck.add(new PowerGridCard(manager));
            deck.add(new PowerPlantCard(manager));
            deck.add(new SolarPowerCard(manager));
            deck.add(new SolettaCard(manager));
            deck.add(new StripMineCard(manager));
            deck.add(new TectonicStressPowerCard(manager));
            deck.add(new WormsCard(manager));
        }

        if (corporate) {
            deck.add(new AcquiredCompanyCard(manager));
            deck.add(new BribedCommitteeCard(manager));
            deck.add(new BuildingIndustriesCard(manager));
            deck.add(new CartelCard(manager));
            deck.add(new FuelFactoryCard(manager));
            deck.add(new GeneRepairCard(manager));
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

    public List<BaseCard> drawCards(int cardCount) {
        if (mainDeck.size() < cardCount) {
            Collections.shuffle(discardDeck);
            discardDeck.addAll(mainDeck);
            mainDeck = discardDeck;
        }
        ArrayList<BaseCard> returnDeck = new ArrayList<BaseCard>();
        for (int i = 0; i < cardCount; i++) {
            returnDeck.add(mainDeck.get(mainDeck.size() - 1 - i));
        }
        mainDeck = mainDeck.subList(0, mainDeck.size() - cardCount);
        return returnDeck;
    }

}
