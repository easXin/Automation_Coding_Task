package com.dataReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;
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

	public void check(String arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	@Override
	public void Print() {
		ListIterator<String>iterator;
		//for(int i=0; i<list.size(); i++) {
		System.out.println(list.size());
			iterator = list.get(0).listIterator();
			while(iterator.hasNext()) {
				System.out.print(iterator.next() +" ");
			}
			System.out.println();
		//}
		
	}

	@Override
	public void Save() {
		// TODO Auto-generated method stub
		
	}

}
