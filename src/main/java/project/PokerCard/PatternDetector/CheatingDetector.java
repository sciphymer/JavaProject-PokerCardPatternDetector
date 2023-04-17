package project.PokerCard.PatternDetector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.PokerCard.Card;

public class CheatingDetector extends PatternDetector{
    @Override
    protected boolean checkPattern(List<Card> cards) {
        Map<Card, Integer> cardsMap = new HashMap<>();
        for(Card card:cards){
            cardsMap.put(card, cardsMap.getOrDefault(card,0)+1);
            if(cardsMap.get(card) == 2){
                System.out.println("Cheating! Duplicate Cards of: " + card.toString());
                return true;
            }
        }
        return false;
    }
}
