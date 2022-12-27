package test.Models;

import main.Enums.Resource;
import main.Enums.Tag;
import main.Managers.CardManager;
import main.Models.BaseCard;
import main.Models.GlobalRequirements;
import main.Models.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectCardsTest {

    private static List<BaseCard> generateAllCards() {
        CardManager cm = new CardManager(new GlobalRequirements(), true, true, true);
        return cm.getMainDeck();
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
    void allCardsHavePlayCardAction(BaseCard card) {
        assertNotNull(card.getPlayCardAction());
    }

    @ParameterizedTest
    @MethodSource("generateAllCards")
    void allCardsHaveDifferentPlayCardActions(BaseCard card) {
        for (BaseCard second : generateAllCards()) {
            if (!second.equals(card)) {
                assertNotEquals(card.getPlayCardAction(), second.getPlayCardAction());
            }
        }
    }

    @ParameterizedTest
    @MethodSource ("generateAllCards")
    void allCardsCostsAgreeWithAttribute(BaseCard card) {
        Player player = new Player(true);
        for (Resource resource : Resource.values()) {
            player.changeResourceCount(resource, 100);
        }
        for (Tag tag : Tag.values()) {
            for (int i = 0; i < 10; i++) {
                player.addTag(tag);
            }
        }

        Set<String> exceptions = new HashSet<>();
        exceptions.add("Investment Loan");

        int predictedCost = player.getResourceCount(Resource.CREDITS) - card.getCost();
        card.setOwner(player);
        try {
            card.runImmediateEffect();
            if (!exceptions.contains(card.getTitle())) {
                assertEquals(predictedCost, player.getResourceCount(Resource.CREDITS));
            }
        } catch (Exception e) {fail();}
    }

    @ParameterizedTest
    @MethodSource ("generateAllCards")
    void allCardsGainTheRightAmountOfTags(BaseCard card) {
        int tagCount = card.getTags().size();
        Player player = new Player(true);
        for (Resource resource : Resource.values()) {
            player.changeResourceCount(resource, 100);
        }
        for (Tag tag : Tag.values()) {
            for (int i = 0; i < 10; i++) {
                player.addTag(tag);
            }
        }
        int predictedTagCount = Tag.values().length * 10 + tagCount;
        card.setOwner(player);
        try {
            card.runImmediateEffect();
            int exactCount = 0;
            for (Tag tag : Tag.values()) {
                exactCount += player.getTagCount(tag, false);
            }
            assertEquals(predictedTagCount, exactCount);
        } catch (Exception e) {fail();}

    }

    @Test
    void checkAllSubDecksMatchCards() {

        CardManager cm = new CardManager(new GlobalRequirements(), true, true, true);

        List<BaseCard> mainDeck = generateAllCards();
        List<BaseCard> baseDeck = CardManager.generateDeck(true, false, false, cm);
        List<BaseCard> corporateDeck = CardManager.generateDeck(false, true, false, cm);
        List<BaseCard> preludeDeck = CardManager.generateDeck(false, false, true, cm);

        int baseIndex = 0;
        int corpIndex = 0;
        int preludeIndex = 0;

        for (BaseCard card : mainDeck) {
            switch (card.getDLC()) {
                case BASE -> {
                    assertEquals(card.getTitle(), baseDeck.get(baseIndex).getTitle());
                    baseIndex++;
                }
                case CORPORATE -> {
                    assertEquals(card.getTitle(), corporateDeck.get(corpIndex).getTitle());
                    corpIndex++;
                }
                case PRELUDE -> {
                    assertEquals(card.getTitle(), preludeDeck.get(preludeIndex).getTitle());
                    preludeIndex++;
                }
            }
        }
    }
}
