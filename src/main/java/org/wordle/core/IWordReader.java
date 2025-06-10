package org.wordle.core;

public interface IWordReader {
    String[] readWords();

    String getRandomWord();
}
