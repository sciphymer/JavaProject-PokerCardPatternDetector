package project.PokerCard.PatternDetector;

import project.PokerCard.Card;

class Utils {
    static boolean checkCardInSequence(Card card1, Card card2){
        return card2.getRank().getValue() - card1.getRank().getValue() == 1;
    }
    static boolean sameSuit(Card card1, Card card2){
        return card1.getSuit().compareTo(card2.getSuit()) == 0;
    }
}
