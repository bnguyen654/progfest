package org.bnguyen.stem.progfest2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem5 {
	public static void main(String args[]){
		Integer n = parseInput();
		
		ArrayList<String> lines = new ArrayList<String>();
		
		for(int i = 1; i <= n; i++){
			String ln = "";
			for(int j = 1; j <= i; j++){
				ln += j + " ";
			}
			lines.add(ln);
		}
		
		ArrayList<String> py3 = new ArrayList<String>();
		for(int i = 0; i < lines.size(); i++){
			String ln = lines.get(i);
			String result = "";
			for(int j = ln.length()-1; j >= 0; j--){
				result += ln.charAt(j);
			}
			py3.add(result);
		}
		
		ArrayList<String> py2 = (ArrayList<String>) py3.clone();
		Collections.reverse(py2);
		
		ArrayList<String> py4 = (ArrayList<String>) lines.clone();
		Collections.reverse(py4);
		
		int max = lines.get(lines.size()-1).length();
		
		for(int i = 0; i < lines.size(); i++){
			String pOne = lines.get(i);
			
			String spaces = "";
			int diff = max - pOne.length();
			for (int j = 0; j < diff; j++){
				spaces += " ";
			}
			String ln = pOne + spaces;
			
			String pTwo = py2.get(i);
			
			spaces = "";
			diff = max - pTwo.length();
			for (int j = 0; j < diff; j++){
				spaces += " ";
			}
			ln += spaces + pTwo;
			
			String pThree = py3.get(i);
			
			spaces = "";
			diff = max - pThree.length();
			for (int j = 0; j < diff; j++){
				spaces += " ";
			}
			ln += "     " + spaces + pThree;
			
			String pFour = py4.get(i);
			ln += "     " + pFour;
			
			System.out.println(ln);
		}
		
	}
	
	public static Integer parseInput(){
		Integer data = 0;
		File f = new File("problem5.in");
		
		try {
			Scanner in = new Scanner(f);
			String input = in.nextLine();				
			in.close();
			
			data = Integer.parseInt(input);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		}
		
		return data;
	}
}
