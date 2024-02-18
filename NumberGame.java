import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roundsWon = 0;
        boolean playAgain = true;

        while (playAgain) {
            if (playRound(scanner)) {
                roundsWon++;
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("You've won " + roundsWon + " rounds. Thanks for playing!");
    }

    private static boolean playRound(Scanner scanner) {
        int randomNumber = generateRandomNumber();
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess (1-100): ");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                return true;
            } else if (userGuess > randomNumber) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Your guess is too low.");
            }

            attempts++;
            System.out.println("You have " + (MAX_ATTEMPTS - attempts) + " attempts left.");
        }

        System.out.println("Sorry, you've reached the maximum attempts. The number was: " + randomNumber);
        return false;
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANGE) + 1;
    }
}
