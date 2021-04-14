package BowlingScoringChallenge;
//Input: Strike, 7, Spare, 9, Miss, Strike, Miss, 8, 8, Spare, Miss, 6, Strike, Strike, Strike, 8, 1
import java.util.Scanner;

public class BowlingMain {
	static int[] score;
	static String[] input;
	static int n;
	static Scanner scanner;
	static int frame = 0;
	static int strikecount = 0;
	static int sparecount = 0;
	static int currentsum = 0;
	static String enter;
	static String enterSecondBallInput;
	
	/************************* main method *************************/
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("enter no of frames:");
		n = Integer.parseInt(scanner.nextLine());
		score = new int[n];
		input = new String[n];
		uiPrint.printgame();
		checkTheInput();
		System.out.println("*************************Game Over*************************");
	}

	public static void checkTheInput() {
		while (frame < n) {
			System.out.println("enter frame" + (frame + 1) + ": (options: Any Integer, Strike, Miss)");
			enter = scanner.nextLine();
			if (frame == n - 1) {
				lastFrameBowling.lastframe();
				frame++;
				continue;
			}
			if (enter.matches("[+-]?\\d*(\\.\\d+)?")) { // if first value is numeric
				if (Integer.parseInt(enter) > 9) {
					System.out.println("enter digits less than 10");
					continue;
				}
				firstBallNumeric.numericForFirstBall();
			} else if (enter.equalsIgnoreCase("Strike")) {// if first value is strike
				strikeFrame.strikeForFirstBall();
			} else if (enter.equalsIgnoreCase("Miss")) { // miss on the first ball of the frame
				firstBallMiss.missForFirstBall();
			} else if (enter.equalsIgnoreCase("Spare")) { // spare on the first ball of the frame
				System.out.println(
						"Spare can only be entered as a second option. Please reselect any option from above for first option.");
				continue;
			} else { // any other string
				System.out.println("Enter valid options from the list above");
				continue;
			}
			uiPrint.printgame();
			frame++;
		}
	}
	/************************* main method *************************/
}
