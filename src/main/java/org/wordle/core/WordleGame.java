package org.wordle.core;

import org.wordle.config.AppConfig;
import org.wordle.exceptions.GuessTargetMismatchException;
import org.wordle.exceptions.GuessWordLengthException;
import org.wordle.model.CharacterFeedback;
import org.wordle.model.FeedbackType;

import java.util.ArrayList;
import java.util.List;

public class WordleGame implements IGame {
    private final String targetWord;
    private final IGuessEvaluator evaluator;
    private final List<List<CharacterFeedback>> guessHistory;
    private boolean win = false;
    private int remainingAttempts;
    private final AppConfig config;


    public WordleGame(String targetWord, IGuessEvaluator evaluator, int numberOfAttempts) {
        this.targetWord = targetWord.toUpperCase();
        this.evaluator = evaluator;
        this.guessHistory = new ArrayList<>();
        this.remainingAttempts = numberOfAttempts;
        this.config = AppConfig.getInstance();
    }

    @Override
    public List<CharacterFeedback> submitGuess(String guess) {
        if (guess.length() != config.getNumberOfLettersAllowedInGuessWord()){
            throw new GuessWordLengthException("must be "+ config.getNumberOfLettersAllowedInGuessWord() +" characters");
        }
        if (isGameOver()) throw new IllegalStateException("Game is over");
        List<CharacterFeedback> feedback = evaluator.evaluateGuess(targetWord, guess);
        guessHistory.add(feedback);
        remainingAttempts--;
        win = feedback.stream().allMatch(fb -> fb.getFeedBackType() == FeedbackType.CORRECT);
        return feedback;
    }

    @Override
    public boolean isWin() {
        return win;
    }

    @Override
    public boolean isGameOver() {
        return win || remainingAttempts == 0;
    }

    @Override
    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    @Override
    public List<List<CharacterFeedback>> getGuessHistory() {
        return guessHistory;
    }
}
