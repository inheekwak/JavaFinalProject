package edu.handong.csee.merge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class fileReader { 
	
	public void readAFile() {
	try { 
        FileInputStream file = new FileInputStream(new File("gfgcontribute.xlsx")); 

        // Create Workbook instance holding reference to .xlsx file 
        XSSFWorkbook workbook = new XSSFWorkbook(file); 

        // Get first/desired sheet from the workbook 
        XSSFSheet sheet = workbook.getSheetAt(0); 

        // Iterate through each rows one by one 
        Iterator<Row> rowIterator = sheet.iterator(); 
        while (rowIterator.hasNext()) { 
            Row row = rowIterator.next(); 
            // For each row, iterate through all the columns 
            Iterator<Cell> cellIterator = row.cellIterator(); 

            while (cellIterator.hasNext()) { 
                Cell cell = cellIterator.next(); 
                // Check the cell type and format accordingly 
                switch (cell.getCellType()) { 
                case Cell.CELL_TYPE_NUMERIC: 
                    System.out.print(cell.getNumericCellValue() + "t"); 
                    break; 
                case aCell.CELL_TYPE_STRING: 
                    System.out.print(cell.getStringCellValue() + "t"); 
                    break; 
                } 
            } 
            System.out.println(""); 
        } 
        file.close(); 
    } 
    catch (Exception e) { 
        e.printStackTrace(); 
    } 
	
	}
} 
	
	
	
	
	/*
	 * ArrayList<String> strList; String strTemp; String lock = "test" ;
	 * Queue<String> ql = new LinkedList<String>();
	 * 
	 * 
	 * 
	 * class TextFileReader extends Thread { public void run() { try {
	 * 
	 * BufferedReader br = new BufferedReader (new FileReader("test.txt"));
	 * 
	 * while(true) { strTemp = br.readLine(); strList.add(strTemp); if (strTemp ==
	 * null) { br.close(); ql.offer("eof"); break; } synchronized(lock) {
	 * ql.offer(strTemp); lock.notifyAll(); // this is to prevent out of memory
	 * error if (ql.size() > 1000) { try { lock.wait(); } catch(InterruptedException
	 * ex) { } } } }
	 * 
	 * }//outer while end catch(IOException ex) { } catch(OutOfMemoryError eo) {
	 * System.out.println("queue size " + ql.size()); }//outer try end }//run method
	 * end }//TextReader class end
	 */
	
}
