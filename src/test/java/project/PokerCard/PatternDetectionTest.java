package project.PokerCard;

import org.junit.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.PokerCard.PatternDetector.PatternDetector;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class PatternDetectionTest {

    private final PrintStream standardOut = System.out;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void cheatingDetector(){
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.SPADE, Card.Rank.EIGHT),
                Card.of(Card.Suit.DIAMOND, Card.Rank.SEVEN),
                Card.of(Card.Suit.CLUB, Card.Rank.SIX),
                Card.of(Card.Suit.SPADE, Card.Rank.FIVE),
                Card.of(Card.Suit.DIAMOND, Card.Rank.SEVEN)
        );
        PatternDetector patternDetector = PatternDetection.getPatternDetector();
        patternDetector.detect(handCards);
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Cheating"));
    }


    public void RoyalFlushDetector(){
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.SPADE, Card.Rank.ACE),
                Card.of(Card.Suit.SPADE, Card.Rank.KING),
                Card.of(Card.Suit.SPADE, Card.Rank.QUEEN),
                Card.of(Card.Suit.SPADE, Card.Rank.JACK),
                Card.of(Card.Suit.SPADE, Card.Rank.TEN)
        );
        PatternDetector patternDetector = PatternDetection.getPatternDetector();
        patternDetector.detect(handCards);
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Royal Flush"));
    }

    @Test
    public void StraightFlushDetector(){
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.SPADE, Card.Rank.NINE),
                Card.of(Card.Suit.SPADE, Card.Rank.KING),
                Card.of(Card.Suit.SPADE, Card.Rank.QUEEN),
                Card.of(Card.Suit.SPADE, Card.Rank.JACK),
                Card.of(Card.Suit.SPADE, Card.Rank.TEN)
        );
        PatternDetector patternDetector = PatternDetection.getPatternDetector();
        patternDetector.detect(handCards);
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Straight Flush"));
    }

    @Test
    public void FourOfAKindDetector(){
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.DIAMOND, Card.Rank.NINE),
                Card.of(Card.Suit.SPADE, Card.Rank.NINE),
                Card.of(Card.Suit.CLUB, Card.Rank.NINE),
                Card.of(Card.Suit.HEART, Card.Rank.NINE),
                Card.of(Card.Suit.SPADE, Card.Rank.TEN)
        );
        PatternDetector patternDetector = PatternDetection.getPatternDetector();
        patternDetector.detect(handCards);
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Four of a Kind"));
    }

    @Test
    public void FullHouseDetector(){
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.DIAMOND, Card.Rank.NINE),
                Card.of(Card.Suit.SPADE, Card.Rank.NINE),
                Card.of(Card.Suit.CLUB, Card.Rank.NINE),
                Card.of(Card.Suit.SPADE, Card.Rank.TEN),
                Card.of(Card.Suit.DIAMOND, Card.Rank.TEN)
        );
        PatternDetector patternDetector = PatternDetection.getPatternDetector();
        patternDetector.detect(handCards);
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Full House"));
    }

    @Test
    public void FlushDetector(){
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.DIAMOND, Card.Rank.ACE),
                Card.of(Card.Suit.DIAMOND, Card.Rank.THREE),
                Card.of(Card.Suit.DIAMOND, Card.Rank.NINE),
                Card.of(Card.Suit.DIAMOND, Card.Rank.TEN),
                Card.of(Card.Suit.DIAMOND, Card.Rank.QUEEN)
        );
        PatternDetector patternDetector = PatternDetection.getPatternDetector();
        patternDetector.detect(handCards);
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("It is a Flush"));
    }

    @Test
    public void StraightDetector(){
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.DIAMOND, Card.Rank.ACE),
                Card.of(Card.Suit.SPADE, Card.Rank.KING),
                Card.of(Card.Suit.CLUB, Card.Rank.JACK),
                Card.of(Card.Suit.SPADE, Card.Rank.TEN),
                Card.of(Card.Suit.DIAMOND, Card.Rank.QUEEN)
        );
        PatternDetector patternDetector = PatternDetection.getPatternDetector();
        patternDetector.detect(handCards);
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("It is a Straight"));
    }


    @Test
    public void ThreeOfAKindDetector(){
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.DIAMOND, Card.Rank.ACE),
                Card.of(Card.Suit.HEART, Card.Rank.ACE),
                Card.of(Card.Suit.SPADE, Card.Rank.ACE),
                Card.of(Card.Suit.SPADE, Card.Rank.TEN),
                Card.of(Card.Suit.CLUB, Card.Rank.QUEEN)
        );
        PatternDetector patternDetector = PatternDetection.getPatternDetector();
        patternDetector.detect(handCards);
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Three of a Kind"));
    }


    @Test
    public void TwoPairDetector(){
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.DIAMOND, Card.Rank.ACE),
                Card.of(Card.Suit.HEART, Card.Rank.ACE),
                Card.of(Card.Suit.SPADE, Card.Rank.TEN),
                Card.of(Card.Suit.DIAMOND, Card.Rank.TEN),
                Card.of(Card.Suit.SPADE, Card.Rank.QUEEN)
        );
        PatternDetector patternDetector = PatternDetection.getPatternDetector();
        patternDetector.detect(handCards);
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Two Pairs"));
    }

    @Test
    public void PairDetector(){
        List<Card> handCards = Arrays.asList(
                Card.of(Card.Suit.SPADE, Card.Rank.ACE),
                Card.of(Card.Suit.DIAMOND, Card.Rank.ACE),
                Card.of(Card.Suit.SPADE, Card.Rank.NINE),
                Card.of(Card.Suit.DIAMOND, Card.Rank.TEN),
                Card.of(Card.Suit.CLUB, Card.Rank.QUEEN)
        );
        PatternDetector patternDetector = PatternDetection.getPatternDetector();
        patternDetector.detect(handCards);
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("One Pair"));
    }
}