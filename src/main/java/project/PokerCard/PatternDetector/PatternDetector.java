package project.PokerCard.PatternDetector;

import project.PokerCard.Card;
import java.util.List;

public abstract class PatternDetector {
    public PatternDetector nextDetector;
    public void setNextDetector(PatternDetector nextDetector){
        this.nextDetector = nextDetector;
    }
    public void detect(List<Card> cards){
        if(!checkPattern(cards)){
            if(nextDetector!=null){
                nextDetector.checkPattern(cards);
            }
        }
    }
    abstract protected boolean checkPattern(List<Card> cards);

    public static void main(String[] args) {

    }
}
