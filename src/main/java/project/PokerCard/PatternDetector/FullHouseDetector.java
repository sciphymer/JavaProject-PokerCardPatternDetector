package project.PokerCard.PatternDetector;

import project.PokerCard.Card;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullHouseDetector extends PatternDetector{
    @Override
    protected boolean checkPattern(List<Card> cards) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Card card: cards) {
            map.put(card.getRank().getValue(), map.getOrDefault(card.getRank().getValue(),0)+1);
        }
        Collection<Integer> numOfCards = map.values();
        if(numOfCards.contains(3) && numOfCards.contains(2)){
            System.out.println("It is a Full House: " + cards);
            return true;
        } else {
            return false;
        }
    }
}
