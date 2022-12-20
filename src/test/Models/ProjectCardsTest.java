package test.Models;

import main.Enums.Resource;
import main.Enums.Tag;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.GlobalRequirements;
import main.Models.Player;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @ParameterizedTest
    @MethodSource ("generateAllCards")
    void allCardsCostsAgreeWithAttribute(BaseCard card) {
        Player player = new Player();
        for (Resource resource : Resource.values()) {
            player.changeResourceCount(resource, 100);
        }
        for (Tag tag : Tag.values()) {
            for (int i = 0; i < 10; i++) {
                player.addTag(tag);
            }
        }

        int predictedCost = player.getResourceCount(Resource.CREDITS) - card.getCost();
        card.setOwner(player);
        try {
            card.runImmediateEffect();
            assertEquals(predictedCost, player.getResourceCount(Resource.CREDITS));
        } catch (Exception e) {fail();}
    }
}
