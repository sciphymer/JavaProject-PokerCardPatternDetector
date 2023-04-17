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

}