/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi.
 * Description: This program will give the user tips on how to improve their wifi connection
 * Due: 2/09/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here:Randy Barreda
*/

import java.util.Scanner;

public class WifiDiagnosis {

	public static void main(String[] args) {
		Scanner answers = new Scanner(System.in); // this is the scanner used to get the
													// answers from the user

		String secondAnswer, thirdAnswer, fourthAnswer; // These Strings will hold the answers
														// from the user

		System.out.println("If you have a problem with internet connectivity," + "this Diagnosis might work. "); // First
																													// steps
																													// asking
																													// the
																													// intial
																													// quesstions
																													// to
																													// begin
																													// the
																													// wifi
																													// diagnosis
		System.out.println("First Step reboot your computer");
		System.out.println("Are you able to connect to the internet? (yes or no) ");

		String answer1 = answers.next(); // This String will contain the answer
											// input by the user into the scanner

		if (answer1.equals("yes") || answer1.equals("YES")) { // this if statement will check the contents of the
																// input entered by the user

			System.out.println("Rebooting your computer seemed to work! "); // This will end the progra if the user
																			// enters yes
		} else if (answer1.equals("no")) { // else if statement that follows if the user enters no, also start of nested
											// if
											// statement
			System.out.println("Second Step: reboot your router"); // further instructions to the user
			System.out.println("Now are you able to connect to the internet? (yes or no) ");
			secondAnswer = answers.next(); // String used to store the input by the user to see if
											// the issue was solved

			if (secondAnswer.equals("yes")) { // Second If statement to check the input from the user.
				System.out.println("Rebooting your router seemed to work! "); // End of if statement if answer is yes
			} else if (secondAnswer.equals("no")) { // start of the else branch of the if statement if answer is no
				System.out.println("Third Step: make sure the cables to your router are plugged in"
						+ "firmly and your routher is getting power"); // further instructions for the user
				System.out.println("Now are you able to connect to the internet? (yes or no) ");
				thirdAnswer = answers.next(); // String used to store the input by the user to see if the issue was
												// solved

				if (thirdAnswer.equals("yes")) { // third if stament to check the input from the user
					System.out.println("Checking the routers cables seemed to work!"); // statement displayed if the
																						// issue has been solved
				} else if (thirdAnswer.equals("no")) { // else branch if the issue was not solved
					System.out.println("Move your computer closer to your router"); // tips on how to fix the connection
																					// of the wifi
					System.out.println("Now are you able to connect to the internet (yes or no)");
					fourthAnswer = answers.next(); // String saved from scanner input entered by the user about the
													// problem

					if (fourthAnswer.equals("yes")) { // last if stament checking if the problem was resolved
						System.out.println("Moving the computer closer to the router " + "seemed to work!"); // Success
																												// statemrnt
																												// if
																												// the
																												// problem
																												// was
																												// solved
					} else if (fourthAnswer.equals("no")) { // final else branch if the problem was not solved
						System.out.println("Fifth step: contact your ISP" + "\n"
								+ "Make sure your ISP is hooked up to your router"); // last tip if problem is not
																						// solved by the user
					}
				}
			}
		}

		answers.close();
	}
}
