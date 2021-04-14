package BowlingScoringChallenge;

public class strikeFrame extends BowlingMain{

	/************************* first ball strike *************************/
	public static void strikeForFirstBall() {
		input[frame] = "X ";
		if (frame == 0)
			score[frame] = 10;
		else 
			commonMethods.checkForStrike();
		strikecount += 2;
	}

	/************************* first ball strike *************************/
}
