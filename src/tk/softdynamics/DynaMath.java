package tk.softdynamics;

public class DynaMath {
	
	//Delta calc
	public static double delta(double a, double b, double c) {
		return (b * b) - (4 * a * c);
	}
	
	//Bhaskara calc
	public static String[] bhaskara(double a, double b, double c) throws ArithmeticException {
		double lower = 2 * a;
		double upLess = (b * -1) - Math.sqrt(DynaMath.delta(a, b, c));
		double upMore = (b * -1) + Math.sqrt(DynaMath.delta(a, b, c));
		if (Math.sqrt(DynaMath.delta(a, b, c)) != Math.floor(Math.sqrt(DynaMath.delta(a, b, c)))) throw new ArithmeticException("Result of square root of delta is a double not a integer. ("+Math.sqrt(DynaMath.delta(a, b, c))+")");
		if (DynaMath.delta(a, b, c) == 0) {
			return (new String[]{Math.round(upMore)+"/"+Math.round(lower), Math.round(upLess)+"/"+Math.round(lower)});
		} else if (DynaMath.delta(a, b, c) > 0) {
			return (new String[]{Double.toString(upMore / lower), Double.toString(upLess/ lower)});
		} else {
			throw new ArithmeticException("Delta result is less than 0. ("+DynaMath.delta(a, b, c)+")");
		}
	}
	
	public static String[] biquadrado(double a, double b, double c) throws ArithmeticException {
		if (DynaMath.delta(a, b, c) <= 0) throw new ArithmeticException("Bhaskara result is a fraction or don't have result.");
		double x12 = Math.sqrt(Double.parseDouble(DynaMath.bhaskara(a, b, c)[0]));
		double x11 = Math.sqrt(Double.parseDouble(DynaMath.bhaskara(a, b, c)[0])) * -1;
		double x22 = Math.sqrt(Double.parseDouble(DynaMath.bhaskara(a, b, c)[1]));
		double x21 = Math.sqrt(Double.parseDouble(DynaMath.bhaskara(a, b, c)[1])) * -1;
		if (Double.parseDouble(DynaMath.bhaskara(a, b, c)[0]) < 0) {
			x12 = 0;
			x11 = 0;
		}
		if (Double.parseDouble(DynaMath.bhaskara(a, b, c)[1]) < 0) {
			x22 = 0;
			x21 = 0;
		}
		if (Math.floor(x11) == x11 && Math.floor(x21) == x21) {
			return (new String[]{Double.toString(x11), Double.toString(x21), Double.toString(x22), Double.toString(x12)});
		} else if (Math.floor(x11) != x11 && Math.floor(x21) == x21) {
			return (new String[]{"√"+DynaMath.bhaskara(a, b, c)[0], Double.toString(x21), Double.toString(x22), "-√"+DynaMath.bhaskara(a, b, c)[0]});
		} else if (Math.floor(x11) == x11 && Math.floor(x21) != x21) {
			return (new String[]{Double.toString(x11), "√"+DynaMath.bhaskara(a, b, c)[1], "-√"+DynaMath.bhaskara(a, b, c)[1], Double.toString(x12)});
		} else {
			return (new String[]{"√"+DynaMath.bhaskara(a, b, c)[0], "√"+DynaMath.bhaskara(a, b, c)[1], "-√"+DynaMath.bhaskara(a, b, c)[1], "-√"+DynaMath.bhaskara(a, b, c)[0]});
		}
	}
	
	//Faction boolean
	private static boolean isFaction(String a) {
		return a.split("/").length == 2;
	}
	
	//Test handler
	public static void main(String[] args) throws ArithmeticException, RuntimeException, NumberFormatException {
		if (args.length != 3) {
			throw new RuntimeException("Test failed.");
		}
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);
		System.out.println(DynaMath.biquadrado(a, b, c)[0]+" "+DynaMath.biquadrado(a, b, c)[1]+" "+DynaMath.biquadrado(a, b, c)[2]+" "+DynaMath.biquadrado(a, b, c)[3]);
	}
}
