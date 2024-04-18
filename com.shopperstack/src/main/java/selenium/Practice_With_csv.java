package selenium;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class Practice_With_csv {

	public static void main(String[] args) throws IOException, CsvException {
		// TODO Auto-generated method stub
		
		FileReader file=new FileReader("./src/test/resources/TestData/CSV.csv");
		CSVReader reader=new CSVReader(file);
	//For single data reading	
//		String[] value = reader.readNext();
//		
//		for (String string : value) {
//			System.out.println(string);
//		}
	
		
		//For multiple data reading
		List<String[]> all = reader.readAll();
		for (String[] strings : all) {
			for (String strings2 : strings) {
				System.out.println(strings2);
			}
		}
	}

}
