package main.Managers;

import main.Enums.DLC;
import main.Models.BaseCard;
import main.Models.ProjectCards.SponsorsCard;

import java.util.ArrayList;
import java.util.List;

/**
 * This should be the only class that interacts with cards directly
 * If we want to keep track of card usage then all usage of cards has to be directed through here
 */
public class CardManager {

    ArrayList<BaseCard> mainDeck;

    /**
     * Generates the deck for play
     * @param base If base cards are enabled
     * @param corporate If Corperate Cards are enabled
     * @param prelude If Prelude cards are enabled
     */
    private void generateDeck(boolean base, boolean corporate, boolean prelude) {
        mainDeck = new ArrayList<BaseCard>();
        if (base) {

        }

        if (corporate) {
            mainDeck.add(new SponsorsCard());
        }

        if (prelude) {

        }
    }

}
