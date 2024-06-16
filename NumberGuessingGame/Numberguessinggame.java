import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int round = 1;
        char playAgain;

        System.out.println("Welcome to the Number Guessing Game....");
        System.out.println("You have 10 attempts to guess the number between 1 and 100");

        do {
            int randomNo = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 10;
            int roundScore = 0;

            System.out.println("\nRound " + round);
            System.out.println("I have selected a new number between 1 and 100.");

            while (guess != randomNo && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < randomNo) {
                    System.out.println("Too low..Try again.");
                } else if (guess > randomNo) {
                    System.out.println("Too high..Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    roundScore = maxAttempts - attempts + 1; 
                    totalScore += roundScore;
                }

                if (attempts == maxAttempts && guess != randomNo) {
                    System.out.println(" you used all your attempts. The correct number was " + randomNo);
                }
            }

            System.out.println("Round " + round + " score: " + roundScore);
            System.out.print("Do you want to play another round? (y/n): ");
            playAgain = scanner.next().charAt(0);

            round++;
        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Game Over!");
        System.out.println("Your total score is: " + totalScore);

        scanner.close();
    }
}