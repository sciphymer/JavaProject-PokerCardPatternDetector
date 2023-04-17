package project.PokerCard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    private Deck deck;

    @BeforeEach
    public void init() {
        deck = Deck.create();
    }

    @Test
    public void shouldEqual_GivenTwoEqualDecks() {
        Deck newDeck = Deck.create();
        assertEquals(newDeck, deck);
    }

    @Test
    public void shouldReturnCardsInDefaultOrder_WhenCreateDeck() {
        assertEquals(CARDS_IN_DEFAULT_ORDER, deck.getCards());
    }

    @Test
    public void shouldReturnCardsOfDefaultDeckSize_WhenCreateDeck() {
        assertEquals(Deck.DEFAULT_DECK_SIZE, deck.size());
    }

    @Test
    public void shouldRemoveCardFromDeck_WhenDealt() {
        assertFalse(deck.getCards().isEmpty());
        Card card = deck.deal();
        assertFalse(deck.contains(card));
    }

    @Test
    public void shouldReturnCards_WhenDealtMultipleTimes() {
        List<Card> stubbedCards = new ArrayList<>() {{
            add(Card.of(Card.Suit.SPADE, Card.Rank.ACE));
            add(Card.of(Card.Suit.SPADE, Card.Rank.KING));
            add(Card.of(Card.Suit.SPADE, Card.Rank.QUEEN));
            add(Card.of(Card.Suit.SPADE, Card.Rank.JACK));
            add(Card.of(Card.Suit.SPADE, Card.Rank.TEN));
        }};

        deck.setCards(new ArrayList<>(stubbedCards));

        Card[] dealtCards = new Card[5];
        for (int i = 0; i < dealtCards.length; i++) {
            dealtCards[i] = deck.deal();
        }
        assertEquals(stubbedCards, Arrays.asList(dealtCards));
    }

    @Test
    public void shouldShuffleCards_WhenShuffle() {
        Deck unshuffledDeck = Deck.create();
        deck.shuffle();
        assertFalse(unshuffledDeck.getCards().isEmpty());
        assertFalse(deck.getCards().isEmpty());
        assertNotEquals(unshuffledDeck, deck);
    }

    @Test
    public void shouldReturnCardsInDefaultOrder_WhenReset() {
        Deck unshuffledDeck = Deck.create();
        deck.shuffle();
        assertNotEquals(unshuffledDeck, deck);
        deck.reset();
        assertEquals(CARDS_IN_DEFAULT_ORDER, deck.getCards());
    }

    @Test
    public void shouldThrowException_WhenDealEmptyDeck() {
        Deck emptyDeck = Deck.create();
        emptyDeck.setCards(new ArrayList<>());

        assertTrue(emptyDeck.isEmpty());
        assertThrows(EmptyDeckException.class, emptyDeck::deal);
    }

    private static final List<Card> CARDS_IN_DEFAULT_ORDER = new ArrayList<>() {{
        add(Card.of(Card.Suit.SPADE, Card.Rank.ACE));
        add(Card.of(Card.Suit.SPADE, Card.Rank.TWO));
        add(Card.of(Card.Suit.SPADE, Card.Rank.THREE));
        add(Card.of(Card.Suit.SPADE, Card.Rank.FOUR));
        add(Card.of(Card.Suit.SPADE, Card.Rank.FIVE));
        add(Card.of(Card.Suit.SPADE, Card.Rank.SIX));
        add(Card.of(Card.Suit.SPADE, Card.Rank.SEVEN));
        add(Card.of(Card.Suit.SPADE, Card.Rank.EIGHT));
        add(Card.of(Card.Suit.SPADE, Card.Rank.NINE));
        add(Card.of(Card.Suit.SPADE, Card.Rank.TEN));
        add(Card.of(Card.Suit.SPADE, Card.Rank.JACK));
        add(Card.of(Card.Suit.SPADE, Card.Rank.QUEEN));
        add(Card.of(Card.Suit.SPADE, Card.Rank.KING));
        add(Card.of(Card.Suit.HEART, Card.Rank.ACE));
        add(Card.of(Card.Suit.HEART, Card.Rank.TWO));
        add(Card.of(Card.Suit.HEART, Card.Rank.THREE));
        add(Card.of(Card.Suit.HEART, Card.Rank.FOUR));
        add(Card.of(Card.Suit.HEART, Card.Rank.FIVE));
        add(Card.of(Card.Suit.HEART, Card.Rank.SIX));
        add(Card.of(Card.Suit.HEART, Card.Rank.SEVEN));
        add(Card.of(Card.Suit.HEART, Card.Rank.EIGHT));
        add(Card.of(Card.Suit.HEART, Card.Rank.NINE));
        add(Card.of(Card.Suit.HEART, Card.Rank.TEN));
        add(Card.of(Card.Suit.HEART, Card.Rank.JACK));
        add(Card.of(Card.Suit.HEART, Card.Rank.QUEEN));
        add(Card.of(Card.Suit.HEART, Card.Rank.KING));
        add(Card.of(Card.Suit.CLUB, Card.Rank.ACE));
        add(Card.of(Card.Suit.CLUB, Card.Rank.TWO));
        add(Card.of(Card.Suit.CLUB, Card.Rank.THREE));
        add(Card.of(Card.Suit.CLUB, Card.Rank.FOUR));
        add(Card.of(Card.Suit.CLUB, Card.Rank.FIVE));
        add(Card.of(Card.Suit.CLUB, Card.Rank.SIX));
        add(Card.of(Card.Suit.CLUB, Card.Rank.SEVEN));
        add(Card.of(Card.Suit.CLUB, Card.Rank.EIGHT));
        add(Card.of(Card.Suit.CLUB, Card.Rank.NINE));
        add(Card.of(Card.Suit.CLUB, Card.Rank.TEN));
        add(Card.of(Card.Suit.CLUB, Card.Rank.JACK));
        add(Card.of(Card.Suit.CLUB, Card.Rank.QUEEN));
        add(Card.of(Card.Suit.CLUB, Card.Rank.KING));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.ACE));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.TWO));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.THREE));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.FOUR));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.FIVE));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.SIX));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.SEVEN));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.EIGHT));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.NINE));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.TEN));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.JACK));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.QUEEN));
        add(Card.of(Card.Suit.DIAMOND, Card.Rank.KING));
    }};
}
