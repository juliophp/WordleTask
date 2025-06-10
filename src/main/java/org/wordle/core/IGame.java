package org.wordle.core;

import org.wordle.model.CharacterFeedback;

import java.util.List;

public interface IGame {
    List<CharacterFeedback> submitGuess(String guess);

    boolean isWin();

    boolean isGameOver();

    int getRemainingAttempts();

    List<List<CharacterFeedback>> getGuessHistory();
}
