import java.util.*;
import java.util.Random;

public class NumberGuessGame 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true)
        {
            System.out.println("\nNew Round!");
            int numberToGuess = rn.nextInt(100) + 1;
            int attemptsAllowed = 10;
            int attemptsTaken = 0;
            boolean guessedCorrectly = false;

            System.out.println("I've picked a number between 1 and 100. You have " + attemptsAllowed + " attempts to guess it.");

            while (attemptsTaken < attemptsAllowed)
            {
                System.out.print("Attempt " + (attemptsTaken + 1) + ": Enter your guess: ");
                int guess;

                if (sc.hasNextInt())
                {
                    guess = sc.nextInt();
                }
                else
                {
                    System.out.println("Please enter a valid number!");
                    sc.next(); 
                    continue;
                }

                attemptsTaken++;

                if (guess == numberToGuess)
                {
                    System.out.println("Congratulations! You guessed the number!");
                    guessedCorrectly = true;
                    break;
                }
                else if (guess < numberToGuess)
                {
                    System.out.println("Too low! Try again.");
                }
                else 
                {
                    System.out.println("Too high! Try again.");
                }
            }

            if (guessedCorrectly) 
            {
                int score = attemptsAllowed - attemptsTaken + 1;
                System.out.println("You scored " + score + " points this round.");
                totalScore += score;
            }
            else
            {
                System.out.println("Out of attempts! The number was " + numberToGuess + ". Better luck next time!");
            }

            roundsPlayed++;
            System.out.println("Total Score: " + totalScore + " | Rounds Played: " + roundsPlayed);

            System.out.print("Do you want to play another round? (yes/no): ");
            sc.nextLine(); 
            String playAgain = sc.nextLine().trim().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }
        }

        sc.close();
    }
}