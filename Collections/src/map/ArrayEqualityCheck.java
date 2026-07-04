package map;

import java.util.HashMap;
import java.util.Map;

//to check whether two given arrays are equal or not i.e they contain the same 
//elements or not? Given the arrays can be unsorted
public class ArrayEqualityCheck {


    public static boolean checkEqualUsingHashMap(int[] arr1, int[] arr2) {
        // 1. Check if the lengths are the same. If not, they can't be equal.
        if (arr1.length != arr2.length) {
            return false;
        }
        // 2. Create a HashMap to store the count of elements in the first array.
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int element : arr1) {
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
//we cannot use freqMap.get(element) + 1 --> while we are populting map for 1st time
//as it will give null pointer exception at runtime
//becoz get() returns value if key is found or null if key is not present in map
//since in begining key is not present it returns null and null+1 is nullpointer exception
//hence use getOrDefault(element, 0) to handle null      
        }
        System.out.println("Total occurence: " + freqMap);
        
        // 3. Iterate through the second array and decrease the frequency count in the map.
        for (int element : arr2) {
// If an element from arr2 is not in map, or its count is already zero, the arrays are not equal.
            if (!freqMap.containsKey(element) || freqMap.get(element) == 0) {
                return false;
            }
            // Decrease the frequency count if element is present.
            freqMap.put(element, freqMap.get(element) - 1);
//here since we are using if clause the possibility of null value is eliminated            
        }
        System.out.println("after occurence: " + freqMap);
        // 4. If all elements in arr2 were successfully matched, all frequency counts 
        // in the map should be zero (due to step 1 ensuring equal lengths).
        return true;
    }

    public static void main(String[] args) {
        int[] a1 = {3, 5, 2, 5, 2};
        int[] b1 = {2, 3, 5, 5, 2};
        System.out.println("Arrays a1 and b1 are equal: " + checkEqualUsingHashMap(a1, b1)); // true

        int[] a2 = {1, 7, 1};
        int[] b2 = {7, 7, 1};
        System.out.println("Arrays a2 and b2 are equal: " + checkEqualUsingHashMap(a2, b2)); // false

        int[] a3 = {1, 2, 3};
        int[] b3 = {1, 2};
        System.out.println("Arrays a3 and b3 are equal: " + checkEqualUsingHashMap(a3, b3)); // false
    }

}
