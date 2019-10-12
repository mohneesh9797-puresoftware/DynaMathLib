package tk.softdynamics;

public class DynaMath {
	
	//Tales calc
	public static double tales(int equivalenceA, int equivalenceB, int a) {
		return (equivalenceB * a) / equivalenceA;
	}
	
	//Pitagoras calc
	public static double pitagoras(double collaredA, double collaredB) {
		return Math.sqrt((collaredA * collaredA) + (collaredB * collaredB));
	}
	
	//Perimeter calc
	public static double perimeter(double width, double heigth) {
		return (width * 2) + (heigth * 2);
	}
	
	public static double perimeter(double collaredA, double collaredB, double hypotenuse) {
		return collaredA + collaredB + hypotenuse;
	}
	
	public static double perimeter(double width, int shapes) {
		return width * shapes;
	}
	
	//Area calc
	public static double area(double width, double heigth) {
		return width * heigth;
	}
	
	//Circumference calc
	public static double circumference(double diameter) {
		return Math.PI * diameter;
	}
	
	//Circle area calc
	public static double circleArea(double raio) {
		return (raio * raio) * Math.PI;
	}
	
	//Delta calc
	public static double delta(int a, int b, int c) {
		return (b * b) - (4 * a * c);
	}
	
	//Bhaskara calc
	public static String[] bhaskara(int a, int b, int c) throws ArithmeticException {
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
	
	//Biquadrado calc
	public static String[] biquadrado(int a, int b, int c) throws ArithmeticException {
		if (DynaMath.delta(a, b, c) <= 0) throw new ArithmeticException("Bhaskara result is a fraction or don't have result.");
		double x12 = Math.sqrt(Double.parseDouble(DynaMath.bhaskara(a, b, c)[0]));
		double x11 = Math.sqrt(Double.parseDouble(DynaMath.bhaskara(a, b, c)[0])) * -1;
		double x22 = Math.sqrt(Double.parseDouble(DynaMath.bhaskara(a, b, c)[1]));
		double x21 = Math.sqrt(Double.parseDouble(DynaMath.bhaskara(a, b, c)[1])) * -1;
		if (Double.parseDouble(DynaMath.bhaskara(a, b, c)[0]) < 0 || Double.parseDouble(DynaMath.bhaskara(a, b, c)[0]) != Math.floor(Double.parseDouble(DynaMath.bhaskara(a, b, c)[0]))) {
			x12 = 0;
			x11 = 0;
		}
		if (Double.parseDouble(DynaMath.bhaskara(a, b, c)[1]) < 0 || Double.parseDouble(DynaMath.bhaskara(a, b, c)[1]) != Math.floor(Double.parseDouble(DynaMath.bhaskara(a, b, c)[1]))) {
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
	
	//Test handler
	public static void main(String[] args) throws ArithmeticException, RuntimeException, NumberFormatException {
		if (args.length != 3) {
			throw new RuntimeException("Test failed.");
		}
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		System.out.println(DynaMath.bhaskara(a, b, c)[0]+" "+DynaMath.bhaskara(a, b, c)[1]);
	}
}
