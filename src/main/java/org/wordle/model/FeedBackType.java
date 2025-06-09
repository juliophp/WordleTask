package org.wordle.model;


import static org.wordle.model.AnsiConstants.*;

public enum FeedBackType {

    MISPLACED(YELLOW), CORRECT(GREEN), ABSENT(WHITE);

    private final String color;

    FeedBackType(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
