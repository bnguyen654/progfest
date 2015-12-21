package org.bnguyen.stem.progest2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem6 {
	/** Input code */
	static Scanner sc = new Scanner(System.in);
	static int notEnded = -1;
	static ArrayList<String> msg = new ArrayList<String>();
	static ArrayList<String> processed = new ArrayList<String>();
	static int amt = 0;
	
	public static File getFile() {
		System.out.print("Enter file path: ");
		String path = sc.next();
		File f = new File(path);
		if (f.exists() && f.canRead()) return f;
		else {
			System.out.println("Invalid file. Try again.");
			return getFile();
		}
	}
	
	public static ArrayList<String> getMessage(int method) {
		ArrayList<String> msgi = new ArrayList<String>();
		
		if (method == 1) {
			notEnded = 1;
			System.out.println("Enter your message.");
			amt = getMsgAmt();
			for (int i = 0; i < amt; i++) {
				System.out.print("> ");
				msgi.add(sc.nextLine());
			}
		} else if (method == 2) {
			try {
				Scanner filesc = new Scanner(getFile());
				int fLine = Integer.parseInt(filesc.nextLine());
				amt = fLine;
				while (filesc.hasNextLine()) {
					msgi.add(filesc.nextLine());
				}
				filesc.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found:");
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("Invalid first line. First line must be a number");
				e.printStackTrace();
			}
		}
		return msgi;
	}
	
	public static int getMsgAmt() {
		String in = sc.nextLine();
		int num;
		try {
			num = Integer.parseInt(in);
			notEnded = 0;
		} catch (NumberFormatException e) {
			if (notEnded == 1) { 
				System.out.print("> ");
				notEnded = 0;
			} else {
				System.out.println("First line is not a number!");
				System.out.print("> ");
				notEnded = 1;
			}
			return getMsgAmt();
		};
		return num;
	}
	
	public static int getEntryMethod() {
		System.out.print("Manual Entry (1) or Get From File (2): ");
		String in = sc.next();
		if (in.equals("1")) {
			return 1;
		} else if (in.equals("2")) {
			return 2;
		} else {
			System.out.println("Invalid entry, try again.");
			return getEntryMethod();
		}
	}
	
	public static void setEntries() {
		msg = getMessage(getEntryMethod());
	}
	
	
	/** Problem 6 code */
	public static void main(String[] arg) {
		setEntries();
		
		for(String i : msg){
			String[] output = new String[2];
			MathContext c = new MathContext(2);
			
			String[] person = i.split(",");
			BigDecimal subtotal = new BigDecimal(0);
			boolean isTruProgrammer = person[0].equals("yes") && !person[1].equals("COBOL"); //COBOL is not a tru language
			int items = 0;
			
			//processing po
			for(String j : person[2].split(" ")){
				BigDecimal k = new BigDecimal(j);
				subtotal = subtotal.add(k);
				items++;
			}
			
			output[0] = subtotal.setScale(2).toPlainString();
			
			if(isTruProgrammer){
				if(items >= 2) subtotal = subtotal.multiply(new BigDecimal(0.85));
				if(items >= 5) subtotal = subtotal.multiply(new BigDecimal(0.9));
				subtotal = subtotal.multiply(new BigDecimal(0.9));
			}
			output[1] = subtotal.setScale(2,RoundingMode.HALF_UP).toPlainString();
			
			processed.add(output[0] + "," + output[1]);
		}
		
		///Users/Brandon/Documents/input.txt
		
		printOutput();
	}
	
	
	/** Output Code */
	public static void printEntries() {
		System.out.println("Your input was: ");
		System.out.println("-----------------------------------");
		for (int i = 0; i < msg.size(); i++) {
			System.out.println("Line " + i + ": " + msg.get(i));
		}
	}
	public static void printOutput() {
		System.out.println("Your output message: ");
		System.out.println("-----------------------------------");
		for (int i = 0; i < processed.size(); i++) {
			System.out.println(processed.get(i));
		}
	}
}
