package org.wordle.model;


import static org.wordle.model.AnsiConstants.*;

public enum FeedbackType {

    MISPLACED(YELLOW), CORRECT(GREEN), ABSENT(WHITE);

    private final String color;

    FeedbackType(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
