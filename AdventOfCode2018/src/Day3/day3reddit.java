/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import FileIO.FileIO;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 71100096
 */
public class day3reddit {
    static int[][] size = new int[1000][1000];
	private static int partOne(List<String> inputString){
		Pattern numberPattern = Pattern.compile("\\d+");
		for (String str: inputString) {
			List<Integer> numbers=  new ArrayList<>();
			Matcher numberMatcher  = numberPattern.matcher(str); 
			while (numberMatcher.find()){
				numbers.add(Integer.parseInt(numberMatcher.group()));
			}
			for(int i =numbers.get(1);i<numbers.get(1)+numbers.get(3);i++){
				for(int j =numbers.get(2);j<numbers.get(2)+numbers.get(4);j++){	
					size[i][j]+=1;
				}
			}
		}
		int dupl = 0;
		for(int i =0;i<1000;i++)
			for(int j=0;j<1000;j++)
				if(size[i][j]>1)
					dupl++;
		return dupl;
	}
	
	private static int partTwo(List<String> inputString){
		Pattern numberPattern = Pattern.compile("\\d+");
		for (String str: inputString) {
			boolean flag = true;
			List<Integer> numbers=  new ArrayList<>();
			Matcher numberMatcher  = numberPattern.matcher(str); 
			while (numberMatcher.find()){
				numbers.add(Integer.parseInt(numberMatcher.group()));
			}
			for(int i =numbers.get(1);i<numbers.get(1)+numbers.get(3);i++){
				for(int j =numbers.get(2);j<numbers.get(2)+numbers.get(4);j++){	
					if(size[i][j]>1)
						flag =false;
				}
			}
			if(flag)
				return numbers.get(0);
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		String filePath = "day3.txt";
                ArrayList<String> input = FileIO.readFileToArrayListString(filePath);
		System.out.println(partOne(input));
		System.out.println(partTwo(input));
	}
}
