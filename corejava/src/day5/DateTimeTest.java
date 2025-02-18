package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void test() throws Exception{
		Date now = new Date();
		System.out.println(now);
		
		Date independenceDay = new Date(47,7,15);
		System.out.println(independenceDay);
		/*
		 * yyyy -> year yy
		 * MM -> numeric month MMM-> alpha
		 * dd -> day
		 * hour -> hh
		 * minutes -> mm
		 * Seconds -> ss
		 */
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(df.format(independenceDay));
		
		Date reuplicDay = df.parse("26-01-1950");
		System.out.println(df.format(reuplicDay));
	}

}
