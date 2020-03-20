package com.dataReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.codingTask.ReadTheseFiles;

public class TXTReader implements ReadTheseFiles  {

	@Override
	public void Read(String loc) {
		
		try {
			File file = new File(loc);
			Scanner textReader = new Scanner(file);
			String fileContent="";
			while(textReader.hasNext()) {
				fileContent = fileContent.concat(textReader.nextLine()+"\n");
			}
			System.out.println(fileContent);
			textReader.close();
		}catch(FileNotFoundException e) {
			e.getStackTrace();
		}
		
	}
}
