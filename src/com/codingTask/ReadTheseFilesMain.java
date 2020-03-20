package com.codingTask;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.dataReader.*;

public class ReadTheseFilesMain {
	private static final Pattern reg_Num = Pattern.compile("-?\\d+(\\.\\d+)?");
	private static Scanner sc;
	private static final CSVReader r_csv = new CSVReader();
	private static final PDFReader r_pdf = new PDFReader();
	private static final TXTReader r_txt = new TXTReader();
	private static final InputReader r_input = new InputReader();
	private static final DataBaseReader r_db = new DataBaseReader() ;
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
		
		String filePath="C:\\Users\\codin\\eclipse-workspace\\Automation_Coding_Task\\src\\com\\testingFile\\";
		switch(selectedOption) {
		case 1:
			filePath+="csvTestingFile.csv";
			r_csv.Read(filePath);
			break;
		case 2:
			filePath+="txtTestingFile.txt";
			r_txt.Read(filePath);
			break;
		case 3:
			String str ="";
			System.out.print("Please enter : ");
			str = sc.nextLine();
			r_input.Read(str);
			break;
		case 4:
			String jdbcUrl = "jdbc:mysql://localhost:3306/coding_task_db";
			r_db.Read(jdbcUrl);
			break;
		case 5:
			filePath+="pdfTestingFile.pdf";
			r_pdf.Read(filePath);
			break;
		default:
			System.out.println("Unknown behavior, program terminated");
		}
		System.out.println("Thank you to use my App");
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
