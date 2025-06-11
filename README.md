 Wordle - Assesment Task

A command-line implementation of **Wordle** built in Java. This game replicates all the requirements and rules and provides feedback in the terminal.

## 🎮 Game Overview

- You must guess a **5-letter word** within **5 attempts**.
- Each guess receives feedback:
  - **Green**: Correct letter in the correct position.
  - **Yellow**: Letter exists in the word but is in the wrong position. Yellow only appears if the letter hasn't been used more times than it appears in the answer.
- Example:
  - Secret word: `WATER`
  - Guess: `OTTER`
  - Only the second `T` will be marked; the first `T` will not be highlighted.

## ✅ Features

- Input validation ensures only 5-letter guesses are accepted.
- Feedback logic respects duplicate letter rules.
- Unit testing for feedback logic included.
- Word list loaded from a local text file.

## ⚒️ Engineering Patterns and Principle Applied
- Composition over Inheritance.
- Interface Segregation, Inversion of Control and other SOLID principles.
- Test Driven Development.


## 📦 Requirements

- Java 8 or higher
- JUnit 5 for unit testing

## 🚀 How to Run
1. Pull the project from the repository using git pull  
2. Compile the project:
   ```bash
   mvn clean package
   ```
3. Run the command below
   ```
    java -jar target/WordleGame-1.0-SNAPSHOT.jar
   ```
4. The game console starts, so you can play the game.

## 📝 Assumptions
- The requirement specifies 5 letters in a guess, should be designed for the possibility of extension. 
- If the game requirement is 5 letters, both user input and file readers should only allow the same number, 5 in this case.
- The guess attempt in the game was also required to be 5, should also to be extended.
- config file was added to main java for the purpose of ease of testing, since it contains no sensitive information

   
