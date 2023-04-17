package project.PokerCard.PatternDetector;

import project.PokerCard.Card;

import java.util.Comparator;
import java.util.List;

import static project.PokerCard.PatternDetector.Utils.checkCardInSequence;

public class StraightDetector extends PatternDetector{
    @Override
    protected boolean checkPattern(List<Card> cards) {

        cards.sort(Comparator.comparingInt(card -> card.getRank().getValue()));
        for(int i=0; i<cards.size()-2;i++){
            if(!checkCardInSequence(cards.get(i),cards.get(i+1))){
                return false;
            }
        }
        System.out.println("It is a Straight: " + cards);
        return true;
    }
}
