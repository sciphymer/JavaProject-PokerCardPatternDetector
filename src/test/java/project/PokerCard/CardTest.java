package project.PokerCard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    @Test
    public void shouldReturnTrue_WhenCompareCards() {
        Card card1 = Card.of(Card.Suit.SPADE, Card.Rank.ACE);
        Card card2 = Card.of(Card.Suit.HEART, Card.Rank.ACE);
        assertTrue(card1.compareTo(card2) > 0);
    }

    @Test
    public void shouldReturnFalse_WhenCompareCards() {
        Card card1 = Card.of(Card.Suit.SPADE, Card.Rank.KING);
        Card card2 = Card.of(Card.Suit.SPADE, Card.Rank.ACE);
        assertTrue(card1.compareTo(card2) < 0);
    }

    @Test
    public void shouldReturnEqualsResult_WhenCompareCards() {
        Card card1 = Card.of(Card.Suit.SPADE, Card.Rank.KING);
        Card card2 = Card.of(Card.Suit.SPADE, Card.Rank.ACE);
        Card card3 = Card.of(Card.Suit.HEART, Card.Rank.KING);
        Card card4 = Card.of(Card.Suit.HEART, Card.Rank.KING);
        assertNotEquals(card1, card2);
        assertEquals(card3, card4);
    }
}
