package BowlingScoringChallenge;

public class commonMethods extends BowlingMain{
	/************************* common method *****************************/
	static void decrementStrikeSpareCount(String name) {
		if (name == "both" || name == "strikecount") {
			if (strikecount > 0)
				strikecount--;
		}
		if (name == "both" || name == "sparecount") {
			if (sparecount > 0)
				sparecount--;
		}
	}

	static void checkForStrike() {
		if (strikecount > 0 || sparecount > 0) {
			if (strikecount > 2) {
				score[frame - 2] += 10;
				score[frame - 1] = score[frame - 2] + 20;
				score[frame] = score[frame - 1] + 10;
				strikecount -= 2;

			} else if (strikecount <= 2) {
				score[frame - 1] += 10;
				score[frame] = score[frame - 1] + 10;
				decrementStrikeSpareCount("strikecount");
			}
			decrementStrikeSpareCount("sparecount");
		} else
			score[frame] = score[frame - 1] + 10;
	}

	static boolean secondBallInput(String ballInput) {
		if (Integer.parseInt(ballInput) > 9) {
			System.out.println("enter a number less than 10");
			return false;
		} else {
			input[frame] += ballInput;
			if (frame != 0 && strikecount > 0) {
				score[frame - 1] += Integer.parseInt(ballInput);
				score[frame] = score[frame - 1] + Integer.parseInt(ballInput);
				strikecount--;
			} else {
				if (frame != 0) {
					if (enter.equalsIgnoreCase("Miss"))
						score[frame] = score[frame - 1] + Integer.parseInt(ballInput);
					else
						score[frame] = score[frame - 1] + Integer.parseInt(ballInput) + Integer.parseInt(enter);
				} else {
					if (enter.equalsIgnoreCase("Miss"))
						score[frame] = Integer.parseInt(ballInput);
					else
						score[frame] = Integer.parseInt(ballInput) + Integer.parseInt(enter);
				}
			}
			return true;
		}
	}
	
	static void spareCheck(int prevnum) {
		input[frame] += "/";
		if (strikecount > 0) {
			if (frame != 0) {
			score[frame - 1] += prevnum;
			score[frame] = score[frame - 1] + 10;
			}
			strikecount--;
		} else {
			if (frame != 0)
				score[frame] = score[frame - 1] + 10;
			else
				score[frame] = 10;
		}
		sparecount++;
	}

	/************************* common method *****************************/
}
