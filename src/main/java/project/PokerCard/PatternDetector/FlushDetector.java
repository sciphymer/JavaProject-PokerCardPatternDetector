package project.PokerCard.PatternDetector;

import project.PokerCard.Card;
import java.util.List;

public class FlushDetector extends PatternDetector{
    @Override
    protected boolean checkPattern(List<Card> cards) {
        return false;
    }
}