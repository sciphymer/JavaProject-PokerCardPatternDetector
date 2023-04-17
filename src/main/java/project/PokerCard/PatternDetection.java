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
//        PatternDetector patternDetector = getPatternDetector();
        PatternDetector patternDetector = new FullHouseDetector();
        patternDetector.detect(handCards);
    }
    public static PatternDetector getPatternDetector(){

        PatternDetector patternDetector = new CheatingDetector();
        RoyalFlushDetector royalFlushDetector = new RoyalFlushDetector();
        StraightFlushDetector straightFlushDetector = new StraightFlushDetector();
        FlushDetector flushDetector = new FlushDetector();
        QuadsDetector quadsDetector = new QuadsDetector();
        FullHouseDetector fullHouseDetector = new FullHouseDetector();
        StraightDetector straightDetector = new StraightDetector();
        ThreeOfAKindDetector threeOfAKindDetector = new ThreeOfAKindDetector();
        TwoPairsDetector twoPairsDetector = new TwoPairsDetector();
        OnePairDetector onePairDetector = new OnePairDetector();
        patternDetector.setNextDetector(royalFlushDetector);
        royalFlushDetector.setNextDetector(straightFlushDetector);
        straightFlushDetector.setNextDetector(flushDetector);
        flushDetector.setNextDetector(quadsDetector);
        quadsDetector.setNextDetector(fullHouseDetector);
        fullHouseDetector.setNextDetector(straightDetector);
        straightDetector.setNextDetector(threeOfAKindDetector);
        threeOfAKindDetector.setNextDetector(twoPairsDetector);
        twoPairsDetector.setNextDetector(onePairDetector);
        return patternDetector;
    }
}
