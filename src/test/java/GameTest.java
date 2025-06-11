import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wordle.core.impl.GuessEvaluator;
import org.wordle.core.IGame;
import org.wordle.core.IGuessEvaluator;
import org.wordle.core.impl.WordleGame;
import org.wordle.exceptions.WordValidationException;
import org.wordle.model.CharacterFeedback;
import org.wordle.model.FeedbackType;

import java.util.List;

public class GameTest {

    private IGame game;

    @BeforeEach
    public void setup(){
        IGuessEvaluator evaluator = new GuessEvaluator();
        game = new WordleGame("PIZZA", evaluator, 2);
    }


    @Test
    public void test_setupGameAndSubmitGuess(){
        List<CharacterFeedback> feedbacks = game.submitGuess("PIZZA");
        Assertions.assertTrue(game.isWin());
        Assertions.assertTrue(game.isGameOver());
        Assertions.assertEquals(1, game.getRemainingAttempts());
        Assertions.assertEquals(1, game.getGuessHistory().size());

        for (CharacterFeedback feedback : feedbacks){
            Assertions.assertEquals(FeedbackType.CORRECT, feedback.getFeedBackType());
        }
    }

    @Test
    public void test_validateGuessWordLength(){
        Assertions.assertThrows(WordValidationException.class, () -> game.submitGuess("PIZZ"));
        Assertions.assertThrows(WordValidationException.class, () -> game.submitGuess("PIZZER"));
    }

}

