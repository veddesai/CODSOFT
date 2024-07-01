//Task 1 : Number Game ---- JAVA Developer Internship (CODSOFT)
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static int generateRandomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }

    public static int guessNumberBetweenRange(int start, int end, int attemptsLeft) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Number in range %d to %d (Attempts left: %d): ", start, end, attemptsLeft);
        int guessNumber = sc.nextInt();

        if (guessNumber < start || guessNumber > end) {
            System.out.println("Enter Number in range " + start + " to " + end + ", Try again:");
            attemptsLeft--;
            return guessNumberBetweenRange(start, end, attemptsLeft);
        }
        return guessNumber;
    }

    public static void main(String[] args) {
        int maxAttempts = 10;
        int numRounds = 0;
        int totalAttempts = 0;

        while (true) {
            int randomNumber = generateRandomNumber(1, 100);
            int attemptsUsed = 0;

            System.out.println("Welcome to the Number Guessing Game!");

            while (attemptsUsed < maxAttempts) {
                int guessNumber = guessNumberBetweenRange(10, 100, maxAttempts - attemptsUsed);
                attemptsUsed++;

                if (guessNumber > randomNumber) {
                    System.out.println("You are higher than that number!");
                } else if (guessNumber < randomNumber) {
                    System.out.println("You are lower than that number!");
                } else {
                    System.out.println("You Guessed Correctly!");
                    numRounds++;
                    break;
                }
            }

            if (attemptsUsed == maxAttempts) {
                System.out.println("You ran out of guesses! The number was: " + randomNumber);
            }

            totalAttempts += attemptsUsed;

            System.out.print("Do you want to play again? (yes/no): ");
            Scanner sc = new Scanner(System.in);
            String response = sc.nextLine();

            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        System.out.println("You played " + numRounds + " rounds.");
        System.out.println("Your total attempts were: " + totalAttempts);
    }
}