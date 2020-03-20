package com.dataReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.codingTask.ReadTheseFiles;

public class CSVReader implements ReadTheseFiles {
	Scanner csvReader;
	ArrayList<LinkedList<String>> list = new ArrayList<LinkedList<String>>();
	LinkedList<String> info = new LinkedList<String>();
	@Override
	public void Read(String loc) {
		try {
			Scanner csvReader = new Scanner(new File(loc),"UTF-8");
			while(csvReader.hasNext()) {
				String data = csvReader.next();
				String[] values = data.split(",");
				for(int i = 0; i < values.length; i++) {
					System.out.print(values[i]+ " ");
				}
				System.out.println();
			}
			csvReader.close();
		}catch(FileNotFoundException e) {
			e.getStackTrace();
		}
	}
}
