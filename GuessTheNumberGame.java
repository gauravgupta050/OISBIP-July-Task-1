import java.util.*;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int totalRounds = 3;

        int totalScore = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.");
        System.out.println("Let's begin!");

        for (int round = 1; round <= totalRounds; round++) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + round + ":");
            System.out.println("Guess a number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    guessed = true;
                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you couldn't guess the number. It was " + targetNumber);
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + totalScore);
    }
}