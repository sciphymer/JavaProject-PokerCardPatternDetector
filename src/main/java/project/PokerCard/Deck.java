package project.PokerCard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.*;


/*

    TODO: update this class to pass all the test cases in DeckTest.java

        1. Implement the `Comparator` that defines the default card order of the deck
        2. Update various methods to complete the functionalities of a typical card deck.

 */
public class Deck {
    // Do not modify the default deck size
    public static final int DEFAULT_DECK_SIZE = 52;

    private static final Comparator<Card> DEFAULT_CARD_ORDER = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            // TODO: implement this comparator
            if(o1.getSuit() != o2.getSuit()){
                return Integer.compare(o2.getSuit().getValue(),o1.getSuit().getValue());
            }
            return Integer.compare(o1.getRank().getValue()%14,o2.getRank().getValue()%14);
        }
    };

    // Do not modify the cards attribute
    private List<Card> cards;

    public static Deck create() {
        // TODO: implement this static factory method to return a new deck in default order
        List<Card> cardList = new ArrayList<>(DEFAULT_DECK_SIZE);
        for(Card.Suit suit: Card.Suit.values()){
            for(Card.Rank rank: Card.Rank.values()){
                cardList.add(Card.of(suit,rank));
            }
        }
        cardList.sort(DEFAULT_CARD_ORDER);
        return new Deck(cardList);
    }

    /*
        Do not modify the constructor
     */
    private Deck(List<Card> cards) {
        this.cards = cards;
    }

    public void reset() {
        // TODO: implement this method to reset the deck to default order
        cards.sort(DEFAULT_CARD_ORDER);
    }

    public void shuffle() {
        // TODO: implement this method to shuffle the deck
        Collections.shuffle(cards);
    }

    public Card deal() {
        // TODO: implement this method to deal a card from the deck
        // Throw EmptyDeckException if the deck is empty
        if(cards.isEmpty()){
            throw new EmptyDeckException("The deck is empty");
        }
        return cards.remove(0);
    }

    public boolean isEmpty() {
        // TODO: implement this method to check whether the deck is empty
        return (size()==0);
    }

    public int size() {
        // TODO: implement this method to return the number of cards in the deck
        return cards.size();
    }

    public boolean contains(Card card) {
        // TODO: implement this method to check whether the deck contains a card
        return cards.contains(card);
    }

    // Do not modify - for unit testing only
    protected List<Card> getCards() {
        return cards;
    }

    // Do not modify - for unit testing only
    protected void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(cards, deck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
