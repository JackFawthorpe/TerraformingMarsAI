package test.Models;

import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.GlobalRequirements;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProjectCardsTest {

    private static List<BaseCard> generateAllCards() {
        CardManager cm = new CardManager(new GlobalRequirements());
        List<BaseCard> mainDeck = cm.getMainDeck();
        return mainDeck;
    }

    @ParameterizedTest
    @MethodSource ("generateAllCards")
    void allCardsInitialiseTitle(BaseCard card) {
        assertNotNull(card.getTitle());
    }

    @ParameterizedTest
    @MethodSource ("generateAllCards")
    void allCardsInitialiseCost(BaseCard card) {
        assertNotNull(card.getCost());
    }

    @ParameterizedTest
    @MethodSource ("generateAllCards")
    void allCardsInitialiseDLC(BaseCard card) {
        assertNotNull(card.getDLC());
    }

    @ParameterizedTest
    @MethodSource ("generateAllCards")
    void allCardsInitialiseTags(BaseCard card) {
        assertNotNull(card.getTags());
    }

    @ParameterizedTest
    @MethodSource ("generateAllCards")
    void allCardsHaveCardManager(BaseCard card) {
        assertNotNull(card.getManager());
    }
}
