package project.PokerCard.PatternDetector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.PokerCard.Card;

public class CheatingDetector extends PatternDetector{
    @Override
    protected boolean checkPattern(List<Card> cards) {
        Map<Card.Suit, Card.Rank> cardsMap = new HashMap<>();
        for(Card card:cards){
            if(cardsMap.containsKey(card.getSuit())){
                if(card.getRank() == cardsMap.get(card.getSuit())){
                    System.out.println("Cheating! Duplicate Cards of: " + card);
                    return true;
                }
            } else {
                cardsMap.put(card.getSuit(),card.getRank());
            }
        }
        return false;
    }
}
