import java.util.*;

public class NumberGuess {

    static final Set<String> VALID_DIFFICULTIES = new HashSet<>(Arrays.asList("easy", "medium", "hard"));
    final int numberToGuess;
    int maxAttempts;
    boolean isGameWon;
    private int attemptsMade;

    public NumberGuess() {
        this.numberToGuess = (int) (Math.random() * 100) + 1;
        this.attemptsMade = 0;
        this.isGameWon = false;
    }

    public static void printWelcomeMessage() {
        System.out.println("--- Welcome to the Number Guessing Game! ---");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Choose a difficulty: easy (10 attempts), medium (5 attempts), hard (3 attempts).");
        System.out.println("----------------------------------------------");
    }

    public void setDifficulty(String difficulty) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                this.maxAttempts = 10;
                break;
            case "medium":
                this.maxAttempts = 5;
                break;
            case "hard":
                this.maxAttempts = 3;
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + difficulty);
        }
    }

    public void makeGuess(int guess) {
        this.attemptsMade++;
        if (guess == this.numberToGuess) {
            this.isGameWon = true;
            System.out.println(" Congratulations! You've guessed the number " + this.numberToGuess + " correctly in " + this.attemptsMade + " attempts.");
        } else if (this.attemptsMade >= this.maxAttempts) {
            System.out.println("Too " + (guess < this.numberToGuess ? "low" : "high") + ". You've used all your attempts.");
        } else {
            String hint = guess < this.numberToGuess ? "low" : "high";
            System.out.println("Too " + hint + "! Try again. Attempts left: " + (this.maxAttempts - this.attemptsMade));
        }
    }

    public boolean isGameOver() {
        return isGameWon || attemptsMade >= maxAttempts;
    }

    public void initGame(){
        printWelcomeMessage();
        NumberGuess game = new NumberGuess();

        // Use try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // Loop to get a valid difficulty
            while (true) {
                System.out.print("Please choose a difficulty (easy, medium, hard): ");
                String chosenDifficulty = scanner.nextLine().toLowerCase();
                if (VALID_DIFFICULTIES.contains(chosenDifficulty)) {
                    game.setDifficulty(chosenDifficulty);
                    System.out.println("You have chosen " + chosenDifficulty + ". You have " + game.maxAttempts + " attempts. Good luck!");
                    break;
                } else {
                    System.out.println("Invalid difficulty level. Please try again.");
                }
            }

            // Main game loop
            while (!game.isGameOver()) {
                System.out.print("Enter your guess (1-100): ");
                try {
                    int guess = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (guess < 1 || guess > 100) {
                        System.out.println("Invalid input. Please enter a number between 1 and 100.");
                        continue;
                    }
                    game.makeGuess(guess);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.nextLine(); // Clear the invalid input from the scanner
                }
            }

            // Final game over message
            if (!game.isGameWon) {
                System.out.println(" Game over! The correct number was " + game.numberToGuess + ".");
            }
        }
    }


}