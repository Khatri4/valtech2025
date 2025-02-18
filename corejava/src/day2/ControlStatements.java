package day2;

public class ControlStatements {
	
	public void testIfElse(int a) {
		if(a%2==0) {
			System.out.println("a = "+a+ " is even");
		} else {
			System.out.println("a = "+a+ " is odd");
		}
	}
	
	
	public void testFor(int [] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void testSwitch(int a) {
		switch (a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		default:
			System.out.println("All the others");
		}
	}
	
	public int add(int ... a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		System.out.println("sum = " +sum );
		return sum;
	}
	
	public static void main(String[] args) {
		ControlStatements cs = new ControlStatements();
		cs.testIfElse(2);
		cs.testIfElse(3);
		cs.testIfElse(4);
		cs.testIfElse(8);
		
		cs.testFor(new int[] {1,2,3});
		cs.testFor(new int[] {1,2,3,4,5});
		
		cs.testSwitch(1);
		cs.testSwitch(2);
		cs.testSwitch(3);
		cs.testSwitch(30);
		
		cs.add(1,2);
		cs.add(1,2,2,3);
		cs.add(1,2,3,3,3,4,5);
	}

}
