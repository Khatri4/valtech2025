package day1;

public class Tiger implements Animal {

	@Override
	public void makeSound() {
		System.out.println("Roar...");
	}

	@Override
	public void eat() {
		System.out.println("Eating meat...");
	}

	@Override
	public void sleep() {
		System.out.println("Loud Snores...");
	}

}
