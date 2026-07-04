package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfWordInSentence {

    public static void main(String[] args) 
    {
            String freq = "Count the freq of the words";
            String arr[] = freq.toLowerCase().split(" ");
            
//Create an empty elementFrequencyMap with element as key and their frequency as value
       HashMap<String, Integer> map = new HashMap<>();
             
            //Iterating each element of inputArray
            for (String i : arr) 
            {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
             
            
            System.out.println("word : Frequency "+map);
            map.forEach((key, value) -> System.out.println(key+" : "+value));
            
            map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(1)
            .forEach(entry -> System.out.println("freq  occuring word "+entry));
    }




}
