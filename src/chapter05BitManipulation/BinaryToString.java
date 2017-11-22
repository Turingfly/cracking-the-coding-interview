package chapter05BitManipulation;

/**
 * 
 * Problem: Given a real number between 0 and 1(e.g., 0.72) that is passed in as
 * a double, print the binary representation. If the number cannot be
 * represented accurately in binary with at most 32 characters, print "ERROR".
 *
 */
public class BinaryToString {
	/**
	 * Method 1: multiplying the number by two and comparing it to 1.
	 */
	public String getBinary1(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		while (num > 0) {
			if (sb.length() >= 32) {
				return "ERROR";
			}
			double update = num * 2;
			if (update >= 1) {
				sb.append("1");
				num = update - 1;
			} else {
				sb.append("0");
				num = update;
			}
		}
		return sb.toString();
	}

	/**
	 * Method 2: compare the number to 0.5, 0.25....
	 */
	public String getBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		double frac = 0.5;
		while (num > 0) {
			if (sb.length() >= 32) {
				return "ERROR";
			}
			if (num >= frac) {
				sb.append("1");
				num -= frac;
			} else {
				sb.append("0");
			}
			frac /= 2;
		}
		return sb.toString();
	}
}
