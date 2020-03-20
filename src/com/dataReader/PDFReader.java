package com.dataReader;

import java.io.File;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import com.codingTask.ReadTheseFiles;

public class PDFReader implements ReadTheseFiles {

	@Override
	public void Read(String loc) {
		Scanner sc = null;
		try {
			PDDocument pdfReader = PDDocument.load(new File(loc));
			pdfReader.getClass();
			if (!pdfReader.isEncrypted()) {
				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				sc = new Scanner(new PDFTextStripper().getText(pdfReader));
				while (sc.hasNextLine()) {
					System.out.print(sc.nextLine() + "\n");
				}
			}
			pdfReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
