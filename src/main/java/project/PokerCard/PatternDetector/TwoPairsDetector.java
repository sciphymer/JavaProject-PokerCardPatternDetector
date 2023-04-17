package project.PokerCard.PatternDetector;

import project.PokerCard.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairsDetector extends PatternDetector{
    @Override
    protected boolean checkPattern(List<Card> cards) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Card card: cards){
            map.put(card.getRank().getValue(),map.getOrDefault(card.getRank().getValue(),0)+1);
        }
        int pairsCounter = 0 ;
        for(Integer i :map.values()){
            if(i==2){
                pairsCounter++;
            }
        }
        if(pairsCounter==2){
            System.out.println("It is a Two Pairs pattern: "+ cards);
            return true;
        }
        return false;
    }
}
