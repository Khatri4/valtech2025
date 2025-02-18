package day1;

public class Cat implements Animal {

	@Override
	public void makeSound() {
		System.out.println("Meow...");
	}

	@Override
	public void eat() {
		System.out.println("Eating Fish...");
	}

	@Override
	public void sleep() {
		System.out.println("Light Snore...");
	}

}
