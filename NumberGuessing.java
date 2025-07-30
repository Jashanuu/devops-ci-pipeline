import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberGuessing {

    /**
     * Evaluates a guess against the secret number.
     * 
     * @param guess  The player's guess.
     * @param number The secret number to guess.
     * @return "correct" if guess matches number,
     *         "low" if guess is less than number,
     *         "high" if guess is greater than number.
     */
    public static String evaluateGuess(int guess, int number) {
        if (guess == number) {
            return "correct";
        } else if (guess < number) {
            return "low";
        } else {
            return "high";
        }
    }

    /**
     * Main game loop that manages user input, attempts, and feedback.
     * Uses Scanner to get user input, calls evaluateGuess() to process guesses.
     * Handles invalid inputs gracefully.
     */
    public static void guessingNumberGame() {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int)(100 * Math.random());  // Random number between 1 and 100
        int maxAttempts = 5;  // Maximum allowed guesses

        System.out.println("A number is chosen between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        int attempts = 0;
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            try {
                int guess = sc.nextInt();

                // Evaluate the guess using the core logic method
                String result = evaluateGuess(guess, number);

                if ("correct".equals(result)) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    break;  // Exit the loop if guessed correctly
                } else if ("low".equals(result)) {
                    System.out.println("The number is greater than " + guess);
                } else {
                    System.out.println("The number is less than " + guess);
                }

                attempts++;  // Count this as an attempt
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next();  // Clear the invalid input from scanner buffer
            }
        }

        // If user has exhausted all attempts without correct guess
        if (attempts == maxAttempts) {
            System.out.println("You've exhausted all attempts. The correct number was: " + number);
        }

        // Scanner is not closed here to avoid closing System.in (important for tests)
    }

    /**
     * Program entry point. Starts the guessing game.
     */
    public static void main(String[] args) {
        System.out.println("CI Test run!");
        guessingNumberGame();
    }
}

//Jashanpreet
//dadadad
//sadasdadas
