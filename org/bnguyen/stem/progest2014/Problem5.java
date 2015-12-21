package org.bnguyen.stem.progest2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem5{
	
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
	
	
	/** Problem 5 code */
	public static void main(String[] arg) {
		setEntries();
		//printEntries();
		process();
		printOutput();
		//System.out.println(shiftChars('F', -1));
		//System.out.println(isSpecialChar('A'));
	}
	public static void process() {
		for (int i = 0; i < amt; i++) {
			if (opType(i+1) != 0) processed.add(i, code(i+1, opType(i+1)));
			else processed.add(i, "Invalid line.");
		}
	}
	private static String code(int line, int opType) {
		String str = msg.get(line-1);
		String nstr = reverse(str);
		char[] nstr2 = new char[nstr.length()];
		int i = 0;
		for (char c : nstr.toCharArray()) {
			nstr2[i] = shiftChars(c, opType, opType);
			//System.out.println(c + " | " + nstr2[i]);
			i++;
		}
		return String.valueOf(nstr2);
	}
	private static int opType(int line) { // -1 = decode; 1 = encode; 0 = unknown
		String str = msg.get(line-1);
		if (str.toCharArray()[0] == '$') return -1;
		else if (str.toCharArray()[0] == '@') return 1;
		else return 0;
	}
	public static boolean isSpecialChar(char i, int op) {
		if (op == -1) return i == 'A' || i == 'a' || !Character.isLetter(i);
		else if (op == 1) return i == 'Z' || i == 'z' || !Character.isLetter(i);
		else return false;
	}
	public static char shiftChars (char ch, int shift, int op) {
		return isSpecialChar(ch, op) ? ch : Character.isUpperCase(ch) ? (char) (((ch - 'A' + shift) % 26) + 'A') : (char) (((ch - 'a' + shift) % 26) + 'a');
	}
	
	
	public static String reverse(String str) {
		str = str.substring(1);
		String[] each = str.split(" ");
		String processed = "";
		for (int i = 0; i < each.length; i++) {
			processed += (new StringBuilder(each[i]).reverse().toString() + " ");
		}
		return processed;
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
