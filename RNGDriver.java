
import java.util.Scanner;

public class RNGDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Scanner that will get the information from the user
		int nextGuess, lowGuess = 0, highguess = 100; // attributes with the values of the highest and lower number
		String playAgain = "yes"; // This is the condition in which the loop will run
		int randNum = RNG.rand(); // Variable storing the random number generated
		boolean firstTurn = true; // initializing the first turn to true

		do { // start of the do while loop that will execute at least once
			if (firstTurn) { // this if statement will execute if the it is the first turn of the player
								// if the the user wishes to play again this variable will be set to true
				System.out.println("Enter your first guess"); // this prompt will ask the user for the first guess
				firstTurn = false; // this will set the first turn boolean to false to indicate that it is not the
									// users
									// first time playing the game
			}
			nextGuess = input.nextInt(); // this will read the user's first guess
			if (nextGuess > randNum) { // if statement if the guess if greater than random number
				System.out.println("Number of guesses is " + (RNG.getCount() + 1)); // display the users current guess
				System.out.println("Your guess is too high"); // Tell the user that the guess is too high
				highguess = Math.min(nextGuess, highguess); // update the highest guess value
				RNG.inputValidation(nextGuess, lowGuess, highguess); // validate the inputs entered by user
			} else if (nextGuess < randNum) { // if statement if the guess if less than random number
				System.out.println("Number of guess is " + (RNG.getCount() + 1)); // display the users current guess
				System.out.println("Your guess is too low");// Tell the user that the guess is too low
				lowGuess = Math.max(lowGuess, nextGuess); // update the lowest value
				RNG.inputValidation(nextGuess, lowGuess, highguess); // validate the input
			} else { // else branch is the user's guess is the correct number
				System.out.println("Congratulations, you guessed correctly");
				System.out.println("Try again? (yes or no)"); // prompt to play again
				playAgain = input.next(); // this variable will store the user choice
				firstTurn = true;
			}

		} while (playAgain.equals("yes")); // condition for the do while loop
		input.close(); // close the scanner
	}
}
