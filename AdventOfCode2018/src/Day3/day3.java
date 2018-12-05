/*
//--- Day 3: No Matter How You Slice It ---
//The Elves managed to locate the chimney-squeeze prototype fabric for Santa's suit (thanks to someone who helpfully wrote its box IDs on the wall of the warehouse in the middle of the night). Unfortunately, anomalies are still affecting them - nobody can even agree on how to cut the fabric.
//
//The whole piece of fabric they're working on is a very large square - at least 1000 inches on each side.
//
//Each Elf has made a claim about which area of fabric would be ideal for Santa's suit. All claims have an ID and consist of a single rectangle with edges parallel to the edges of the fabric. Each claim's rectangle is defined as follows:
//
//The number of inches between the left edge of the fabric and the left edge of the rectangle.
//The number of inches between the top edge of the fabric and the top edge of the rectangle.
//The width of the rectangle in inches.
//The height of the rectangle in inches.
//A claim like #123 @ 3,2: 5x4 means that claim ID 123 specifies a rectangle 3 inches from the left edge, 2 inches from the top edge, 5 inches wide, and 4 inches tall. Visually, it claims the square inches of fabric represented by # (and ignores the square inches of fabric represented by .) in the diagram below:
//
//...........
//...........
//...#####...
//...#####...
//...#####...
//...#####...
//...........
//...........
//...........
//The problem is that many of the claims overlap, causing two or more claims to cover part of the same areas. For example, consider the following claims:
//
//#1 @ 1,3: 4x4
//#2 @ 3,1: 4x4
//#3 @ 5,5: 2x2
//Visually, these claim the following areas:
//
//........
//...2222.
//...2222.
//.11XX22.
//.11XX22.
//.111133.
//.111133.
//........
//The four square inches marked with X are claimed by both 1 and 2. (Claim 3, while adjacent to the others, does not overlap either of them.)
//
//If the Elves all proceed with their own plans, none of them will have enough fabric. How many square inches of fabric are within two or more claims?
//
//Your puzzle answer was 116920.
//
//--- Part Two ---
//Amidst the chaos, you notice that exactly one claim doesn't overlap by even a single square inch of fabric with any other claim. If you can somehow draw attention to it, maybe the Elves will be able to make Santa's suit after all!
//
//For example, in the claims above, only claim 3 is intact after all claims are made.
//
//What is the ID of the only claim that doesn't overlap?
//
//Your puzzle answer was 382.
//
//Both parts of this puzzle are complete! They provide two gold stars: **
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
    
    public static Integer findOverlap(Map material) {
        Iterator it = material.entrySet().iterator();
        Integer overlap = 0;
        while (it.hasNext()) {
            Map.Entry coord = (Map.Entry)it.next();
            if((Integer) coord.getValue() == -1) {
                overlap++;
            }
        }
        return overlap;
    }

}
