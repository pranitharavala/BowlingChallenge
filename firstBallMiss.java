package BowlingScoringChallenge;

public class firstBallMiss extends BowlingMain{
	/************************* first ball miss *************************/
	public static void missForFirstBall() {
		input[frame] = "- ";
		uiPrint.printgame();
		String missSecondBall = scanner.nextLine();
		commonMethods.decrementStrikeSpareCount("both");
		boolean correctinput = false;
		while (correctinput == false) {
			if (missSecondBall.matches("[+-]?\\d*(\\.\\d+)?")) {
				correctinput = commonMethods.secondBallInput(missSecondBall);
			} else if (missSecondBall.equalsIgnoreCase("Miss")) {
				input[frame] += "-";
				commonMethods.decrementStrikeSpareCount("sparecount");
				strikecount = (strikecount <= 2) ? strikecount-- : strikecount - 2;
				correctinput = true;
			} else if (missSecondBall.equalsIgnoreCase("Spare")) {
				commonMethods.spareCheck(10);
				correctinput = true;
			} else if (missSecondBall.equalsIgnoreCase("Strike"))
				System.out.println(
						"Strike can only be entered as a first option. Please reselect any option from above for Second option.");
		}

	}

	/************************* first ball miss *************************/
}
