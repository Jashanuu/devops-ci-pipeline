import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberGuessing {

    public static void guessingNumberGame() {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int)(100 * Math.random());
        int K = 5;

        System.out.println("A number is chosen between 1 and 100.");
        System.out.println("You have " + K + " attempts to guess the correct number.");

        int attempts = 0;
        while (attempts < K) {
            System.out.print("Enter your guess: ");
            try {
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    sc.close();
                    return;
                } else if (guess < number) {
                    System.out.println("The number is greater than " + guess);
                } else {
                    System.out.println("The number is less than " + guess);
                }

                attempts++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // clear the invalid input
            }
        }

        System.out.println("You've exhausted all attempts. The correct number was: " + number);
        sc.close();
    }

    public static void main(String[] args) {
        System.out.println("CI Test run!");
        guessingNumberGame();
    }
}
