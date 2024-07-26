import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Define the range and number of attempts
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;

        // Generate a random number within the range
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.");

        boolean hasWon = false;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess < targetNumber) {
                System.out.println("Too low!");
            } else if (guess > targetNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempt + " attempts.");
                hasWon = true;
                break;
            }
        }

        if (!hasWon) {
            System.out.println("Sorry, you've used all your attempts. The number was " + targetNumber + ".");
        }

        scanner.close();
    }
}
