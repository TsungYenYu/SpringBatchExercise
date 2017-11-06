package com.helloInSpringBootAndBatch.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public  class ToolMethods {
	public static int getFileTotalRecord() throws IOException {
		FileReader frH = null;
		BufferedReader brH = null;
		int resultCount = 0;
		String[] strH;
		try {
			frH = new FileReader("IMS_W36001F_20171023.H");
			brH = new BufferedReader(frH);
			strH = brH.readLine().split("\\|");
			resultCount = Integer.valueOf(strH[4].trim());// H 筆數
			System.out.println("resultCount :" +resultCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			brH.close();
			frH.close();
		}

		return resultCount;
	}
	
	
	public static int getFileDate() throws IOException {
		FileReader frH = new FileReader("IMS_W36001F_20171023.H");
		BufferedReader brH = new BufferedReader(frH);
		String[] strH = brH.readLine().split("\\|");
		int compareDateH = Integer.valueOf(strH[0].trim());// H 日期
		brH.close();
		frH.close();
		return compareDateH;
		
		
	}
}
