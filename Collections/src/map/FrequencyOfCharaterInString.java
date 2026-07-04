package map;

import java.util.Arrays;
import java.util.HashMap;

public class FrequencyOfCharaterInString {

    public static void main(String[] args) 
    {
            String freq = "frequency";
             
//Create an empty elementFrequencyMap with element as key and their frequency as value
       HashMap<Character, Integer> map = new HashMap<>();
             
            //Iterating each element of inputArray
            for (Character i : freq.toCharArray()) 
            {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
             
            
            System.out.println("Element : Frequency "+map);
            map.forEach((key, value) -> System.out.println(key+" : "+value));
    }


}
