package Ch6;

/* You have a basketball hoop and someone says that you can play one of two games.
 * Game1: You get one shot to make the hoop.
 * Game2: You get three shots and you have to make two of three shots.
 * If p is the probability of making a particular shot, 
 * for which values of p should you pick one game or the other?  */

public class Solution02 {
	public static String gamePick(double p) {
		if (p < 0 || p > 1) { //Check the wrong input situation
			return "Your input is wrong.";
		} else {
			double p1 = 0;
			double p2 = 0;
			p1 = p;
			p2 = (Math.pow(p, 3)) + 3 * (Math.pow(p, 2)) * (1 - p);
	//Compare the two prababilities of p1 and p2
			if (p1 == p2) {
				return "Pick either game is ok.";
			} else if (p1 < p2) {
				return "You should choose the Game 2.";
			} else {
				return "You should choose the Game 1.";
			}
		}
	}

	public static void main(String args[]) {
		double p1 = 0;
		double p2 = 0.25;
		double p3 = 0.5;
		double p4 = 0.75;
		double p5 = 1;
		System.out.println("If p==" + p1 + "," + gamePick(p1));
		System.out.println("If p==" + p2 + "," + gamePick(p2));
		System.out.println("If p==" + p3 + "," + gamePick(p3));
		System.out.println("If p==" + p4 + "," + gamePick(p4));
		System.out.println("If p==" + p5 + "," + gamePick(p5));

	}
}
