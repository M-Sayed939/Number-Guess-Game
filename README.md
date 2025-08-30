# Java Number Guessing Game 🎮

A classic number guessing game implemented in Java. This is a simple, console-based application where the computer picks a random number between 1 and 100, and the player must guess it within a limited number of attempts.

The project is designed with a clear separation between the game logic (`NumberGuess.java`) and the application entry point (`Main.java`).
https://roadmap.sh/projects/number-guessing-game

-----

## Features

  * **Dynamic Difficulty**: Choose between **Easy** (10 attempts), **Medium** (5 attempts), and **Hard** (3 attempts).
  * **Random Number Generation**: A new secret number is generated for every game session.
  * **Interactive Feedback**: The game provides instant feedback, telling you if your guess is too high or too low.
  * **Input Validation**: Gracefully handles invalid inputs, such as non-numeric text or numbers outside the 1-100 range.
  * **Object-Oriented Design**: The game logic is encapsulated in a reusable `NumberGuess` class, separate from the main executable.

-----

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

Make sure you have a **Java Development Kit (JDK) version 8 or newer** installed on your system. You can verify your installation by running the following commands in your terminal:

```sh
java -version
javac -version
```

### Running the Game

1.  **Create the Java Files**
    In the same directory, create two files: `NumberGuess.java` (with the code you provided) and `Main.java`.

2.  **Add the Code for `Main.java`**
    This class will serve as the entry point for your application.

    ```java
    // Main.java
    public class Main {
        public static void main(String[] args) {
            // 1. Create an instance of the game
            NumberGuess game = new NumberGuess();

            // 2. Start the game by calling its initializer method
            game.initGame();
        }
    }
    ```

3.  **Compile the Project**
    Open a terminal in the directory containing both files and run the Java compiler.

    ```sh
    javac Main.java NumberGuess.java
    ```

    Alternatively, you can compile all Java files in the directory:

    ```sh
    javac *.java
    ```

4.  **Run the Game**
    Execute the compiled code by running the `Main` class, which contains the main method.

    ```sh
    java Main
    ```

-----

## How to Play

The gameplay remains simple and intuitive:

1.  Run the application following the steps above.
2.  You will be prompted to choose a difficulty: `easy`, `medium`, or `hard`.
3.  Enter your guess (a number between 1 and 100) when prompted.
4.  The game will provide feedback and show your remaining attempts.
5.  Continue guessing until you find the correct number or run out of attempts\!

-----

## Code Overview

The project is separated into two classes for better organization:

  * `NumberGuess.java`: This class is the core game engine. It manages the game's state, including the secret number, attempts, and difficulty. It contains all the logic for processing guesses and determining the game's outcome.
  * `Main.java`: This is the entry point of the application. Its sole responsibility is to create an instance of the `NumberGuess` class and start the game.

Key methods in `NumberGuess.java` include:

  * `initGame()`: Manages the main game flow, handling user input for difficulty settings and the primary guessing loop.
  * `setDifficulty()`: Configures the number of allowed attempts based on player choice.
  * `makeGuess()`: Processes a player's guess and provides feedback.
  * `isGameOver()`: Checks the win/loss condition to control the game loop.
