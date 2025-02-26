package spring.ioc;

public class PointFactory {
	
	public static Point createPoint() {
		System.out.println("Object Created...");
		return new Point();
	}

}
