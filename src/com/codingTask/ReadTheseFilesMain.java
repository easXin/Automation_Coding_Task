package com.codingTask;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.dataReader.*;

public class ReadTheseFilesMain {
	private static final Pattern reg_Num = Pattern.compile("-?\\d+(\\.\\d+)?");
	private static Scanner sc;
	private static CSVReader r_csv;
	private static PDFReader r_pdf;
	private static TXTReader r_txt;
	private static InputReader r_input;
	private static DataBaseReader r_db;
	public static void main(String[] args) {
		String menuOption = "";
		sc = new Scanner(System.in);
		System.out.println("\n                    Coding Task 1.0.0            \n");
		System.out.println("Select an Option to Retrieve Student Information");
		System.out.println("Option:\t1.CSV\n\t2.TXT\n\t3.Custom Input\n\t4.Data Base\n\t5.PDF");
		System.out.print("Enter : ");
		
		menuOption = sc.nextLine();
		
		while(!isNumeric(menuOption) || (Integer.parseInt(menuOption)<0 || Integer.parseInt(menuOption)>5) ){
			System.out.println("Invalid input, new input : ");
			menuOption = sc.nextLine();
		}
		selectionMenu(menuOption);
		sc.close();
	}
	
	public static void selectionMenu(String menuOption) {
		Integer selectedOption = Integer.parseInt(menuOption);
		switch(selectedOption) {
		case 1:
			r_csv = new CSVReader();
			r_csv.Read("C:\\Users\\codin\\eclipse-workspace\\codingTask\\src\\com\\testingFile\\csvTestingFile.csv");
			break;
		case 2:
			r_txt = new TXTReader();
			r_txt.Read("C:\\Users\\codin\\eclipse-workspace\\CodingTasks\\src\\com\\testingFile\\txtTestingFile.txt");
			break;
		case 3:
			String str ="";
			r_input = new InputReader();
			System.out.print("Please enter : ");
			str = sc.nextLine();
			r_input.Read(str);
			break;
		case 4:
			r_db = new DataBaseReader();
			String jdbcUrl = "jdbc:mysql://localhost:3306/coding_task_db";
			r_db.Read(jdbcUrl);
			break;
		case 5:
			break;
		default:
			System.out.println("Unknown behavior, program terminated");
		
		}
		
	}

	private static boolean isNumeric(String str_num) {
		if(str_num==null||str_num.equals("")) {
			return false;
		}
		return getReg_Num().matcher(str_num).matches();
	}
	public static Pattern getReg_Num() {
		return reg_Num;
	}
}
