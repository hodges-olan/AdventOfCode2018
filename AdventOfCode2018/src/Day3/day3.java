/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import FileIO.FileIO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 71100096
 */
public class day3 {
    
    public static void main(String[] args) {
        String filePath = "day3.txt";
        ArrayList<String> input = FileIO.readFileToArrayListString(filePath);
        Map<String, Integer> material = new HashMap();
        
        for(String entry: input) {
            markClaim(material, entry);
        }
    }
    
    public static Map markClaim(Map material, String claim) {
        String start = ((claim.split("\\s+"))[2]).replace(":", "");
        String size = ((claim.split("\\s+"))[3]);
        Integer x = Integer.parseInt((start.split(","))[0]);
        Integer y = Integer.parseInt((start.split(","))[1]);
        Integer rangeX = Integer.parseInt((size.split("x"))[0]);
        Integer rangeY = Integer.parseInt((size.split("x"))[1]);
        
        System.out.println("Start: " + start);
        System.out.println("Size: " + size);
        System.out.println("Start X: " + x);
        System.out.println("Start Y: " + y);
        System.out.println("Range X: " + rangeX);
        System.out.println("Range Y: " + rangeY);
        return material;
    }
    
}
