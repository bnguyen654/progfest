package org.bnguyen.stem.progfest2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args){
		ArrayList<String[]> data = parseInput();
		
		for(int i = 0; i < data.size(); i++){
			String[] person = data.get(i);
			
			String from = person[0];
			String date = person[1];
			String to = "Pay to the Order of: " + person[2];
		
			String amt = person[3];
			Integer amount = Integer.parseInt(amt.replace(".",""));
			
			
			String word = getWord(amount);
			
			int toLen = to.length();
			int fromLen = from.length();
			
			if(toLen > fromLen){
				int diff = toLen - fromLen;
				
				String spaces = "     ";
				for(int j = 0; j < diff; j++){
					spaces += " ";
				}
				
				System.out.println(from + spaces + "Date: " + date);
				System.out.println(to + "     " + "$" + amt);
				System.out.println(word);
			}else{
				int diff = fromLen - toLen;
				
				String spaces = "     ";
				for(int j = 0; j < diff; j++){
					spaces += " ";
				}
				
				System.out.println(from + "     " + "Date: " + date);
				System.out.println(to + spaces + "$" + amt);
				System.out.println(word);
			}
		}
	}
	
	public static ArrayList<String[]> parseInput(){
		File f = new File("problem3.in");
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		try {
			Scanner in = new Scanner(f);
			
			while(in.hasNextLine()){
				String i = in.nextLine();
				String[] person = i.split(",");
				
				data.add(person);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		}
		
		return data;
	}
	
	public static String getWord(Integer amt){
		String result = "";
		
		//thousands
		int th = amt / 100000;
		
		//hundreds
		amt = amt % 100000;
		int hn = amt / 10000;
		
		//tens
		amt = amt % 10000;
		int tn = amt / 1000;
		
		//ones
		amt = amt % 1000;
		int on = amt / 100;
		
		//cents
		int cents = amt % 100;
		
		/**System.out.println(th);
		System.out.println(hn);
		System.out.println(tn);
		System.out.println(on);
		System.out.println(cents);*/
		
		
		switch(th){
		case 1:
			result += "one thousand ";
			break;
		case 2:
			result += "two thousand ";
			break;
		case 3:
			result += "three thousand ";
			break;
		case 4:
			result += "four thousand ";
			break;
		case 5:
			result += "five thousand ";
			break;
		case 6:
			result += "six thousand ";
			break;
		case 7:
			result += "seven thousand ";
			break;
		case 8:
			result += "eight thousand ";
			break;
		case 9:
			result += "nine thousand ";
			break;
		case 0: default:
			break;
		}
		
		switch(hn){
		case 1:
			result += "one hundred ";
			break;
		case 2:
			result += "two hundred ";
			break;
		case 3:
			result += "three hundred ";
			break;
		case 4:
			result += "four hundred ";
			break;
		case 5:
			result += "five hundred ";
			break;
		case 6:
			result += "six hundred ";
			break;
		case 7:
			result += "seven hundred ";
			break;
		case 8:
			result += "eight hundred ";
			break;
		case 9:
			result += "nine hundred ";
			break;
		case 0: default:
			break;
		}
		
		boolean oneTen = false;
		boolean noTen = false;
		
		switch(tn){
		case 1:
			oneTen = true;
			break;
		case 2:
			result += "twenty";
			break;
		case 3:
			result += "thirty";
			break;
		case 4:
			result += "fourty";
			break;
		case 5:
			result += "fifty";
			break;
		case 6:
			result += "sixty";
			break;
		case 7:
			result += "seventy";
			break;
		case 8:
			result += "eighty";
			break;
		case 9:
			result += "ninety";
			break;
		case 0: default:
			noTen = true;
			break;
		}
		
		if(oneTen){
			switch(on){
			case 1:
				result += "eleven";
				break;
			case 2:
				result += "twelve";
				break;
			case 3:
				result += "thirteen";
				break;
			case 4:
				result += "fourteen";
				break;
			case 5:
				result += "fifteen";
				break;
			case 6:
				result += "sixteen";
				break;
			case 7:
				result += "seventeen";
				break;
			case 8:
				result += "eighteen";
				break;
			case 9:
				result += "ninteen";
				break;
			case 0: default:
				result += "ten";
				break;
			}
		}else if(noTen){
			switch(on){
			case 1:
				result += "one";
				break;
			case 2:
				result += "two";
				break;
			case 3:
				result += "three";
				break;
			case 4:
				result += "four";
				break;
			case 5:
				result += "five";
				break;
			case 6:
				result += "six";
				break;
			case 7:
				result += "seven";
				break;
			case 8:
				result += "eight";
				break;
			case 9:
				result += "nine";
				break;
			case 0: default:
				break;
			}
		}else{
			switch(on){
			case 1:
				result += "-one";
				break;
			case 2:
				result += "-two";
				break;
			case 3:
				result += "-three";
				break;
			case 4:
				result += "-four";
				break;
			case 5:
				result += "-five";
				break;
			case 6:
				result += "-six";
				break;
			case 7:
				result += "-seven";
				break;
			case 8:
				result += "-eight";
				break;
			case 9:
				result += "-nine";
				break;
			case 0: default:
				break;
			}
		}
		
		result += " and ";
		
		if(cents == 1){
			result += "1 cent";
		}else{
			result += cents + " cents";
		}
		
		return result.substring(0,1).toUpperCase() + result.substring(1);
	}
}
