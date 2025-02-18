package day2;

public class SimpleArithmetic implements Arithmetic {

	@Override
	public double add(double a, double b) {
		return a+b;
	}
	
	@Override
	public double sub(double a, double b) {
		return a-b;
	}
	
	@Override
	public double div(double a, double b) {
		return a/b;
	}
	
	@Override
	public double mul(double a, double b) {
		return a*b;
	}
	
	@Override
	public int div(int a, int b) {
		return a/b;
	}
	
	public static void main(String[] args) {
		SimpleArithmetic s = new SimpleArithmetic();
		System.out.println(s.add(10, 20));
		System.out.println(s.sub(10, 20));
		System.out.println(s.mul(10, 20));
		System.out.println(s.div(10, 20));
	}

}
