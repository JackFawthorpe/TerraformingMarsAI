package test.Managers;

import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.GlobalRequirements;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CardManagerTest {

    @Test
    void drawingACardFromTheDeckRemovesItFromTheDeck() {
        CardManager cm = new CardManager(new GlobalRequirements(), true, true, true, false); // False for testing leads to randomisation
        List<BaseCard> deck = cm.getMainDeck();
        int numberOfCards = deck.size();
        BaseCard finalCard = deck.get(deck.size() - 1);
        BaseCard drawedCard = cm.drawCards(1).get(0);
        assertEquals(cm.getMainDeck().size(), numberOfCards-1);
        assertEquals(drawedCard, finalCard);
    }
}
