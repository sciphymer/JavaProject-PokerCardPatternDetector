package project.PokerCard;

import project.PokerCard.PatternDetector.*;

import java.util.Arrays;
import java.util.List;

public class PatternDetection {
    public static void main(String[] args) {
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.DIAMOND, Card.Rank.NINE),
                Card.of(Card.Suit.SPADE, Card.Rank.NINE),
                Card.of(Card.Suit.CLUB, Card.Rank.NINE),
                Card.of(Card.Suit.SPADE, Card.Rank.TEN),
                Card.of(Card.Suit.CLUB, Card.Rank.TEN)
        );
        PatternDetector patternDetector = new FullHouseDetector();
        patternDetector.detect(handCards);
    }
    public static PatternDetector getPatternDetector(){

        PatternDetector patternDetector = new CheatingDetector();
        patternDetector.setNextDetector(new RoyalFlushDetector())
                .setNextDetector(new StraightFlushDetector())
                .setNextDetector(new StraightFlushDetector())
                .setNextDetector(new FlushDetector())
                .setNextDetector(new QuadsDetector())
                .setNextDetector(new FullHouseDetector())
                .setNextDetector(new StraightDetector())
                .setNextDetector(new ThreeOfAKindDetector())
                .setNextDetector(new TwoPairsDetector())
                .setNextDetector(new OnePairDetector());
        return patternDetector;
    }
}
