package Ch6;

/* You have 20 bottles of pills. 19 bottles have 1.0 gram pills, 
 * but one has pills of weight 1.1 grams.
 * Given a scale that provides an exact measurement , how would you find the heavy bottle?
 * You can only use the scale once. */
public class Solution01 {
	public static int searchBottle(double[] perweight, int num,
			double standardperweight, double heavyperweight) {
		double weight = 0;
		double standardweight = 0;
		for (int i = 0; i < perweight.length; i++) {
			weight = weight + perweight[i] * (i + 1); //Get the truly whole weight
		}
		for (int j = 1; j <= num; j++) {
			standardweight = standardweight + standardperweight * j;//Get the supposed weight
		}
		int bottlenumber = (int) ((weight - standardweight) / (heavyperweight - standardperweight));//Get the bottle number
		return bottlenumber;
	}

	public static void main(String[] args) {
		double standardperweight = 1.0;
		double heavyperweight = 1.1;
		int num = 20;
		double[] perweight = new double[num];
		for (int i = 0; i < perweight.length; i++) {
			perweight[i] = standardperweight;
		}
		perweight[5] = heavyperweight;
		System.out.println(searchBottle(perweight, num, standardperweight,
				heavyperweight));
	}
}
