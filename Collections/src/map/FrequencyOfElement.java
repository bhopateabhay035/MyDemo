package map;

import java.util.Arrays;
import java.util.HashMap;

public class FrequencyOfElement {

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
             
            //Printing inputArray
            System.out.println("Input Array : "+Arrays.toString(inputArray));
             // printing element frequency
            System.out.println("Element : Frequency "+map);
            map.forEach((key, value) -> System.out.println(key+" : "+value));
    }

}
