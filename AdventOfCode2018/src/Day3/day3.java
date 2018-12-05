/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import FileIO.FileIO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author 71100096
 */
public class day3 {
    
    public static void main(String[] args) {
        String filePath = "day3.txt";
        ArrayList<String> input = FileIO.readFileToArrayListString(filePath);
        Map<String, Integer> material = new HashMap();
        Integer overlapId = -1;
        
        for(String entry: input) {
            String[] entrySplit = entry.split("\\s+");
            Integer id = Integer.parseInt(entrySplit[0].replace("#", ""));
            String start = entrySplit[2].replace(":", "");
            String size = entrySplit[3];
            Integer x = Integer.parseInt((start.split(","))[0]);
            Integer y = Integer.parseInt((start.split(","))[1]);
            Integer rangeX = Integer.parseInt((size.split("x"))[0]);
            Integer rangeY = Integer.parseInt((size.split("x"))[1]);
            boolean overlap = false;

            for(int i = x; i < (x + rangeX); i++) {
                for(int j = y; j < (y + rangeY); j++) {
                    String coord = Integer.toString(i) + "," + Integer.toString(j);
                    if(!material.containsKey(coord)) {
                        material.put(coord, id);
                    } else {
                        if(Objects.equals(overlapId, material.get(coord))) {
                            overlapId = -1;
                        }
                        overlap = true;
                        material.put(coord, -1);
                    }
                }
                if(!overlap) {
                    overlapId = id;
                }
            }
        }
        
        System.out.println("Part One: " + findOverlap(material));
        System.out.println("Part Two: " + (overlapId));
    }
    
    public static String findOverlap(Map material) {
        Iterator it = material.entrySet().iterator();
        Integer overlap = 0;
        while (it.hasNext()) {
            Map.Entry coord = (Map.Entry)it.next();
            if((Integer) coord.getValue() == -1) {
                overlap++;
            }
        }
        return overlap.toString();
    }
    
    public static Map overwriteOverlap(Map material, Integer id) {
        return material;
    }

}
