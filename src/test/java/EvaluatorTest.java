import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.wordle.core.impl.GuessEvaluator;
import org.wordle.core.IGuessEvaluator;
import org.wordle.model.CharacterFeedback;

import java.util.List;

import static org.wordle.utils.AnsiConstants.*;

public class EvaluatorTest {

    private final IGuessEvaluator evaluator = new GuessEvaluator();


    @Test
    public void test_guessEvaluator(){
        String target = "PAPER";
        String guess = "APPLE";
        List<CharacterFeedback> feedback = evaluator.evaluateGuess(target, guess);
        Assertions.assertEquals(YELLOW, feedback.get(0).getFeedBackType().getColor());
        Assertions.assertEquals(YELLOW, feedback.get(1).getFeedBackType().getColor());
        Assertions.assertEquals(GREEN, feedback.get(2).getFeedBackType().getColor());
        Assertions.assertEquals(RESET, feedback.get(3).getFeedBackType().getColor());
        Assertions.assertEquals(YELLOW, feedback.get(4).getFeedBackType().getColor());
    }


    @Test
    public void test_dontColorIfTargetHasMoreLetters(){
        String target = "WATER";
        String guess = "OTTER";
        List<CharacterFeedback> feedback = evaluator.evaluateGuess(target, guess);
        Assertions.assertEquals(RESET, feedback.get(1).getFeedBackType().getColor());
        Assertions.assertEquals(GREEN, feedback.get(2).getFeedBackType().getColor());
    }
}
