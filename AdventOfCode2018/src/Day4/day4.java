/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4;

import FileIO.FileIO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 71100096
 */
public class day4 {
    
    public static void main(String[] args) {
        String filePath = "day4.txt";
        ArrayList<String> input = FileIO.readFileToArrayListString(filePath);
        Collections.sort(input);
        //   Date       Time    Action
        Map<String, Map<String, String>> schedule = loadSchedule(input);
        printSchedule(schedule);
    }
    
    public static Map<String, Map<String, String>> loadSchedule(ArrayList<String> input) {
        Map<String, Map<String, String>> schedule = new HashMap<>();
        HashSet<String> uniqueDates = new HashSet<>();
        input.stream().map((entry) -> entry.substring(6, 11)).forEachOrdered((date) -> {
            uniqueDates.add(date);
        });
        
        List<String> sortedUniqueDates = new ArrayList<>(uniqueDates);
        Collections.sort(sortedUniqueDates);
        
        sortedUniqueDates.forEach((sortedUniqueDate) -> {
            Map<String, String> timeAction = new HashMap<>();
            input.stream().filter((entry) -> (sortedUniqueDate.equals(entry.substring(6, 11)))).forEachOrdered((entry) -> {
                timeAction.put(entry.substring(12, 17), entry.substring(19));
            });
            schedule.put(sortedUniqueDate, timeAction);
        });
        return schedule;
    }
    
    public static void printSchedule(Map<String, Map<String, String>> schedule) {
        System.out.println("Date   ID   Minute");
        System.out.println("            000000000011111111112222222222333333333344444444445555555555");
        System.out.println("            012345678901234567890123456789012345678901234567890123456789");
        
        //Sample
        System.out.println("11-01  #10  .....####################.....#########################.....\n" +
                           "11-02  #99  ........................................##########..........\n" +
                           "11-03  #10  ........................#####...............................\n" +
                           "11-04  #99  ....................................##########..............\n" +
                           "11-05  #99  .............................................##########.....");
    }
    
}
