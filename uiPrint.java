package BowlingScoringChallenge;

public class uiPrint extends BowlingMain {
	/************************* print *****************************/
	static void printgame() {
		System.out.println("-----------------------------------------------------------");
		System.out.print(" | Frame | ");
		for (int i = 0; i < n; i++)
			System.out.print(" " + (i + 1) + " |");
		System.out.println("");
		for (int i = 0; i < n; i++)
			System.out.print("| --- |");
		System.out.println("");
		System.out.print(" | Input | ");
		for (int i = 0; i < n; i++) {
			System.out.print(" " + input[i] + " |");
		}
		System.out.println("");
		System.out.print(" | Score | ");
		for (int i = 0; i < n; i++) {
			System.out.print(" " + score[i] + " |");
		}
		System.out.println("");
		System.out.println("-----------------------------------------------------------");
	}

	/************************* print *****************************/
}
