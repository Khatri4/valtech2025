package assignment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateTime {

	    public static void dateTimeDifference(String day1, String day2) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	        LocalDateTime date1 = LocalDateTime.parse(day1, formatter);
	        LocalDateTime date2 = LocalDateTime.parse(day2, formatter);

	        Duration duration = Duration.between(date1, date2);

	        long days = duration.toDays();
	        long hours = duration.toHours() % 24;
	        long minutes = duration.toMinutes() % 60;
	        long seconds = duration.getSeconds() % 60;

	        System.out.println("Difference between " + day1 + " and " + day2 + " is:");
	        System.out.println(days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
	    }

	    public static void main(String[] args) {
	        String dateTime1 = "2025-03-25 14:30:00";
	        String dateTime2 = "2025-03-27 16:45:30";

	        dateTimeDifference(dateTime1, dateTime2);
	    }
	
	
}
