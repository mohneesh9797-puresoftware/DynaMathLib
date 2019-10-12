public class DynaMath {
	
	public static double delta(double a, double b, double c) {
		return (b * b) - (4 * a * c);
	}
	
	public static String[] bhaskara(double a, double b, double c) throws ArithmeticException {
		double delta = DynaMath.delta(a, b, c);
		double lower = 2 * a;
		double upLess = (b * -1) - delta;
		double upMore = (b * -1) + delta;
		if (delta == 0) {
			String lessRes = upLess+"/"+lower;
			String moreRes = upMore+"/"+lower;
			String[] res = {moreRes, lessRes};
			return res;
		} else if (delta > 0) {
			String lessRes = Double.toString(upLess / lower);
			String moreRes = Double.toString(upMore / lower);
			String[] res = {moreRes, lessRes};
			return res;
		} else {
			throw new ArithmeticException("Delta result is less than 0. ("+delta+")");
		}
	}
	
	private static boolean isFaction(String a) {
		if (a.split('/') == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) throws ArithmeticException, RuntimeException {
		if (args.length != 3) {
			throw new RuntimeException("Seu burro.");
		}
		String[] res = DynaMath.bhaskara(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
		System.out.println(res[0]+" "+res[1]);
	}
}
