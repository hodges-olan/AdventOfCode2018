/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import FileIO.FileIO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author 71100096
 */
public class dayTwo {
    
    public static void main(String[] args) {
        String filePath = "dayTwo.txt";
        ArrayList<String> input = FileIO.readFileToArrayListString(filePath);
        Integer dualOccurence = 0;
        Integer tripleOccurence = 0;
        
        // Part One
        for(String entry: input) {
            Map entryCountChars = countChars(entry);
            if(entryCountChars.containsValue(2)) {
                dualOccurence++;
            }
            if(entryCountChars.containsValue(3)) {
                tripleOccurence++;
            }
        }
        System.out.println("Part One: " + Integer.toString(dualOccurence * tripleOccurence));
        
        // Part Two
        for(int x = 0; x < input.size() - 1; x++) {
            for(int y = x + 1; y < input.size(); y++) {
                if(StringUtils.getLevenshteinDistance(input.get(x), input.get(y)) == 1) {
                    Integer index = StringUtils.indexOfDifference(new String[] {input.get(x), input.get(y)});
                    StringBuilder sb = new StringBuilder(input.get(x));
                    System.out.println("Part Two: " + sb.deleteCharAt(index));
                }
            }
        }
    }
    
    public static Map countChars(String input) {
        int len = input.length();
        Map<Character, Integer> numChars = new HashMap<>(Math.min(len, 26));

        for (int i = 0; i < len; ++i) {
            char charAt = input.charAt(i);

            if (!numChars.containsKey(charAt)) {
                numChars.put(charAt, 1);
            } else {
                numChars.put(charAt, numChars.get(charAt) + 1);
            }
        }

        return numChars;
    }
    
}
