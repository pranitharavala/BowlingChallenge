package BowlingScoringChallenge;

public class lastFrameBowling extends BowlingMain{
	/************************* last frame *************************/
	public static void lastframe() {
		boolean thirdvalue = false;
		boolean previsnumber = false;
			if (enter.matches("[+-]?\\d*(\\.\\d+)?")) {
				if (Integer.parseInt(enter) > 9) {
					System.out.println("enter digits less than 10");
				} else {
					input[frame] = enter;
					if (strikecount > 0 || sparecount > 0) {
						commonMethods.decrementStrikeSpareCount("both");
						score[frame - 1] += Integer.parseInt(enter);
					}
					score[frame] = score[frame - 1] + Integer.parseInt(enter);
					previsnumber = true;
				}
			} else if (enter.equalsIgnoreCase("Strike")) {
				input[frame] = "X";
				commonMethods.checkForStrike();
				thirdvalue = true;
			} else if (enter.equalsIgnoreCase("Miss")) {
				input[frame] = "-";
				commonMethods.decrementStrikeSpareCount("both");
				score[frame] = score[frame - 1];
			} else if (enter.equalsIgnoreCase("Spare")) {
				System.out.println(
						"Spare can only be entered as a second option. Please reselect any option from above for Second option.");
			}
		uiPrint.printgame();
		System.out.println("second chance for frame 10: ");
		String lastframesecond = null;
		boolean secondcorrectinput = false;
		while (secondcorrectinput == false) {
			 lastframesecond = scanner.nextLine();
			if (lastframesecond.matches("[+-]?\\d*(\\.\\d+)?")) {
				if (Integer.parseInt(lastframesecond) > 9) {
					System.out.println("enter digits less than 10");
					continue;
				} else {
					input[frame] += " " + lastframesecond;
					if (strikecount > 0 || sparecount > 0) {
						score[frame - 1] += Integer.parseInt(lastframesecond);
						score[frame] = score[frame - 1] + 10 + Integer.parseInt(lastframesecond);
						commonMethods.decrementStrikeSpareCount("both");
					} else {
						score[frame] = score[frame - 1] + Integer.parseInt(lastframesecond);
					}
					if (previsnumber == true && (Integer.parseInt(lastframesecond) + Integer.parseInt(enter) == 10))
						thirdvalue = true;
					secondcorrectinput = true;
				}
			} else if (lastframesecond.equalsIgnoreCase("Strike")) {
				input[frame] += " X";
				commonMethods.checkForStrike();
				score[frame] += 10;
				thirdvalue = true;
				secondcorrectinput = true;
			} else if (lastframesecond.equalsIgnoreCase("Miss")) {
				input[frame] += " -";
				commonMethods.decrementStrikeSpareCount("both");
				secondcorrectinput = true;
			} else if (lastframesecond.equalsIgnoreCase("Spare")) {
				if (input[frame] != "X") {
					input[frame] += " /";
					thirdvalue = true;
					score[frame] += 10 - Integer.parseInt(enter);
					secondcorrectinput = true;
				}
			}else {
				System.out.println("Enter valid options from the list above2");
			}
		}
		uiPrint.printgame();
		if (thirdvalue == true) {
			boolean thirdcorrectinput = false;
			while (thirdcorrectinput == false) {
				System.out.println("Bonus:");
				String lastframethird = scanner.nextLine();
				if (lastframethird.matches("[+-]?\\d*(\\.\\d+)?")) {
					if (Integer.parseInt(lastframethird) > 9) {
						System.out.println("enter digits less than 10");
					} else {
						input[frame] += " " + lastframethird;
						score[frame] += Integer.parseInt(lastframethird);
						thirdcorrectinput = true;
					}
				} else if (lastframethird.equalsIgnoreCase("Spare")) {
					if (lastframesecond.equalsIgnoreCase("Spare")) {
						System.out.println("spare can not be continous.Please enter again");
					} else {
						input[frame] += " /";
						score[frame] += 10;
						thirdcorrectinput = true;
					}
				} else if (lastframethird.equalsIgnoreCase("Strike")) {
					input[frame] += " X";
					score[frame] += 10;
					thirdcorrectinput = true;
				} else if (lastframethird.equalsIgnoreCase("Miss")) {
					input[frame] += " -";
					thirdcorrectinput = true;
				}else {
					System.out.println("Enter valid options from the list above3");
				}
				uiPrint.printgame();
			}
		}
	}

	/************************* last frame *************************/
}
