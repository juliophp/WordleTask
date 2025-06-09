package org.wordle.core;

import org.wordle.model.CharacterFeedback;

import java.util.Collections;
import java.util.List;

public class WordleGame implements IGame {
    public WordleGame(String targetWord, IGuessEvaluator evaluator) {
    }

    @Override
    public List<CharacterFeedback> submitGuess() {
        return Collections.emptyList();
    }

    @Override
    public boolean isWin() {
        return false;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public int getRemainingAttempts() {
        return 0;
    }

    @Override
    public List<CharacterFeedback> getGuessHistory() {
        return Collections.emptyList();
    }
}
