package project.PokerCard.PatternDetector;

import project.PokerCard.Card;

import java.util.Comparator;
import java.util.List;

import static project.PokerCard.PatternDetector.Utils.checkCardInSequence;
import static project.PokerCard.PatternDetector.Utils.sameSuit;

public class RoyalFlushDetector extends PatternDetector{
    @Override
    protected boolean checkPattern(List<Card> cards) {
        cards.sort(Comparator.comparingInt(card -> card.getRank().getValue()));
        if(cards.get(cards.size()-1).getRank()!= Card.Rank.ACE){
            return false;
        }
        for(int i=0; i<cards.size()-2;i++){
            if(!checkCardInSequence(cards.get(i),cards.get(i+1))){
                return false;
            }
            if(!sameSuit(cards.get(i),cards.get(i+1))){
                return false;
            }
        }
        System.out.println("It is a Royal Flush: " + cards);
        return true;
    }
}
