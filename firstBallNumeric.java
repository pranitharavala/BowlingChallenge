package BowlingScoringChallenge;

public class firstBallNumeric extends BowlingMain{
	/************************* first ball numeric *************************/
	public static void numericForFirstBall() {
		currentsum = 10 - (Integer.parseInt(enter));
		input[frame] = enter + " ";
		score[frame] = Integer.parseInt(enter);
		if (frame != 0 && (strikecount > 0 || sparecount > 0)) {
			commonMethods.decrementStrikeSpareCount("both");
			score[frame - 1] += Integer.parseInt(enter);
		}
		uiPrint.printgame();
		enterSecondBall();
	}

	public static void enterSecondBall() {
		System.out.println("enter from options 1)Any Integer 2)Miss 3) Spare");
		enterSecondBallInput = scanner.nextLine();
		boolean correctinput = false;
		while (correctinput == false) {
			if (enterSecondBallInput.equalsIgnoreCase("Spare")) {
				commonMethods.spareCheck(currentsum);
				correctinput = true;
			} else if (enterSecondBallInput.equalsIgnoreCase("Miss")) {
				input[frame] += "-";
				commonMethods.decrementStrikeSpareCount("both");
				if (frame != 0)
					score[frame] += score[frame - 1];
				correctinput = true;
			} else if (enterSecondBallInput.matches("[+-]?\\d*(\\.\\d+)?")) {
				correctinput = commonMethods.secondBallInput(enterSecondBallInput);
			} else if (enterSecondBallInput.equalsIgnoreCase("Strike"))
				System.out.println(
						"Strike can only be entered as a first option. Please reselect any option from above for Second option.");

		}
	}

	/************************* first ball numeric *************************/
}
