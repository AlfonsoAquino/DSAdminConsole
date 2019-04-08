package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Utility {
	
	public String getDetail(String fileName) throws FileNotFoundException {
		
		String content="";
		File file = 
			      new File("C:\\Users\\alfon\\OneDrive\\Desktop\\Tesi\\GitDsa\\"+fileName); 
			    Scanner sc = new Scanner(file); 
			  
			    while (sc.hasNextLine()) {
			      content+=sc.nextLine();
			    }
		return content;
		
	}

}
