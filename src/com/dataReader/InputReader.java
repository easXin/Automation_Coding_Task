package com.dataReader;

import com.codingTask.ReadTheseFiles;

public class InputReader implements ReadTheseFiles {

	@Override
	public void Read(String str) {
		String retStr = str.length()!=0? str:"Invalid Input, Not Input Found";
		System.out.print(retStr);
	}
}
