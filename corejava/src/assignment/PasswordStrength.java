package assignment;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrength {

	public String passwordStrength(String password) {
		
		if(password.length()<8) {
			return "Enter the more than 8 character";
		}
		
		Pattern upperCase = Pattern.compile("[A-Z]");
		Pattern lowerCase = Pattern.compile("[a-z]");
		Pattern digit = Pattern.compile("[0-9]");
		Pattern specialChar = Pattern.compile("[~`!@#$%^&*()<>?/,.:;{}|]");
		
		
		boolean hasUpperCase = upperCase.matcher(password).find();
		boolean hasLowerrCase = lowerCase.matcher(password).find();
		boolean hasDigit = digit.matcher(password).find();
		boolean hasSpecialChar = specialChar.matcher(password).find();
		
		
		if(hasUpperCase && hasLowerrCase && hasDigit && hasSpecialChar) {
			return "Difficult";
		} else if((hasUpperCase && hasLowerrCase && hasDigit) || 
				(hasUpperCase && hasLowerrCase && hasSpecialChar) || 
				(hasUpperCase && hasDigit && hasSpecialChar) || 
				(hasLowerrCase && hasSpecialChar && hasDigit)) {
			return "Moderate";
		} else if((hasUpperCase||hasLowerrCase) && (hasSpecialChar || hasDigit)) {
			return "Easy";
		} else {
			return "Easy";
		}
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the password: ");
		String password = sc.nextLine();
		
		PasswordStrength ps = new PasswordStrength();
		
		String strength = ps.passwordStrength(password);
		
//		System.out.println(password+ " is " + strength);
		
		System.out.println(strength);
		
		
	}
}
