package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TopThreeFrequentElement {



    public static void main(String[] args) 
    {
            int[] inputArray = {4, 7, 2, 9, 1, 7, 1, 4, 7, 8};
             
//Create an empty elementFrequencyMap with element as key and their frequency as value
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
             
            //Iterating each element of inputArray
            for (int i : inputArray) 
            {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
             
            map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(3)
            .forEach(entry -> System.out.println(entry.getKey()+" : "+entry.getValue()));
    }



}
