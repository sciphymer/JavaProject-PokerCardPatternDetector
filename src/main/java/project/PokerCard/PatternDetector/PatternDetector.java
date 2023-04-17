package project.PokerCard.PatternDetector;

import project.PokerCard.Card;
import java.util.List;

public abstract class PatternDetector {
    public PatternDetector nextDetector;
    public PatternDetector setNextDetector(PatternDetector detector){
        this.nextDetector = detector;
        return nextDetector;
    }

    public void detect(List<Card> cards){
        if(!checkPattern(cards)){
            if(nextDetector!=null){
                nextDetector.detect(cards);
            } else {
                System.out.println("No card patterns can be detected.");
            }
        }
    }
    abstract protected boolean checkPattern(List<Card> cards);

}
