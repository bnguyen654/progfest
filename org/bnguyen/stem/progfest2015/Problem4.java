package org.bnguyen.stem.progfest2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem4 {
	public static void main(String[] args){
		ArrayList<String> cards = parseInput(){
			
		}
	}
	
	public static boolean isValid(String card){
		int sum = 0;
		Integer[] digits = new Integer[card.length()];
				
		for(int i = card.length()-1; i >= 0; i--){
			int cdm = card.length()-1 % 2; //checksummod
			
		}
		
		return card.length() == 16 && sum % 10 == 0;
	}
	
	public static int parseTwoDigit(Integer num){
		
	}
	
	public static ArrayList<String> parseInput(){
		File f = new File("problem4.in");
		ArrayList<String> data = new ArrayList<String>();

		try {
			Scanner in = new Scanner(f);
			while(in.hasNextLine()){
				String input = in.nextLine();
				data.add(input);
			}
						
			in.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		}
		
		return data;
	}
}
