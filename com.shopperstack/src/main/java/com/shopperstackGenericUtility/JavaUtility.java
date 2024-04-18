package com.shopperstackGenericUtility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {
	
public int randomNumber() {		
		Random r=new Random();
		int number=r.nextInt(1000);
		return number;
	}
	public String localdate() {
		String date = LocalDate.now().toString().replace("[^0-9]","");
		return date;
	}
	public String localdateTime() {
		String dateTime = LocalDateTime.now().toString().replaceAll("[^0-9]", "");
		return dateTime;
	}
}

