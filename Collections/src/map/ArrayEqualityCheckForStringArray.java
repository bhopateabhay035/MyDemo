package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayEqualityCheckForStringArray {


    public static boolean checkEqualUsingHashMap(String[] arr1, String[] arr2) {
    	 // Step 1: Check Length
        if (arr1.length != arr2.length) {
            return false;
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
//Map value should be Integer object since we are using it to add count
        // Step 2: Populate Hashmap (Array 1)
        for (String str : arr1) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
//we cannot use freqMap.get(element) + 1 --> while we are populting map for 1st time
//as it will give null pointer exception at runtime
//becoz get() returns value if key is found or null if key is not present in map
//since in begining key is not present it returns null and null+1 is nullpointer exception
//hence use getOrDefault(element, 0)
        System.out.println("Total occurence: " + frequencyMap); // true

        // Step 3: Compare and Decrement (Array 2)
        for (String str : arr2) {
        	System.out.println("key present: " + frequencyMap.containsKey(str)+ " value count "+frequencyMap.get(str));
            
        	if (!frequencyMap.containsKey(str) || frequencyMap.get(str) == 0) {          	
                return false; // Element not found or count already zero/negative
            }
            frequencyMap.put(str, frequencyMap.get(str) - 1);
//here since we are using if clause the possibility of null value is eliminated             
        }
        System.out.println("after occurence: " + frequencyMap);
        // Step 4: Final Check
        // (The loop in Step 3 already covers this if all counts must be zero at the end)
        // If we reach this point, all elements were present with matching frequencies.
        return true;
    }

    public static void main(String[] args) {
        String[] a1 = {"A",null,"B",null};
        String[] b1 = {null,"C",null,"A"};
        System.out.println("Arrays a1 and b1 are equal: " + checkEqualUsingHashMap(a1, b1)); // true

        
    }

}
