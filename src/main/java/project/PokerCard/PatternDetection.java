package project.PokerCard;

import project.PokerCard.PatternDetector.CheatingDetector;
import project.PokerCard.PatternDetector.PatternDetector;

import java.util.Arrays;
import java.util.List;

public class PatternDetection {
    public static void main(String[] args) {
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.SPADE, Card.Rank.FIVE),
                Card.of(Card.Suit.DIAMOND, Card.Rank.SEVEN),
                Card.of(Card.Suit.CLUB, Card.Rank.SIX),
                Card.of(Card.Suit.SPADE, Card.Rank.FIVE),
                Card.of(Card.Suit.DIAMOND, Card.Rank.SEVEN)
        );
        PatternDetector patternDetector = getPatternDetector();
        patternDetector.detect(handCards);
    }
    public static PatternDetector getPatternDetector(){
        PatternDetector cheatingDetector = new CheatingDetector();
        return cheatingDetector;
    }
}
