package project.PokerCard.PatternDetector;

import project.PokerCard.Card;
import java.util.List;

import static project.PokerCard.PatternDetector.Utils.sameSuit;

public class FlushDetector extends PatternDetector{
    @Override
    protected boolean checkPattern(List<Card> cards) {
        for(int i=0; i<cards.size()-2;i++){
            if(!sameSuit(cards.get(i),cards.get(i+1))){
                return false;
            }
        }
        System.out.println("It is a Flush: " + cards);
        return true;
    }
}
