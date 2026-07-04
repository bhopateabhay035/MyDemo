package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//highest frequency of a character in a given string
public class HighestFrequencyCharacter {
	public static void main(String[] args) {
        
        String str = "java string test";
        
        //Creating  a hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : str.toCharArray()){
            if(c!=' ') {
	            if(map.containsKey(c)){
	                int old_count = map.get(c);
	                int new_count = old_count + 1;
	                map.put(c, new_count);
	            } else {
	                map.put(c, 1);
	            }
            }
        }
        System.out.println("check total char occurance "+map);
        
       //1. Iterate using keySet() to find max occurance element
        Set<Character> keys = map.keySet();
        Character c = str.charAt(0);
        for(Character key : keys){
            if(map.get(key) > map.get(c)){
                c = key;
            }
        }
        System.out.println("highest frequency in a given string = "+c);
        
      //2. Iterate using entrySet() to find max occurance element
        int c1 = 0;
        Character max = ' ';
        for(Map.Entry<Character, Integer> key : map.entrySet()){
            if(key.getValue() > c1){
                c1 = key.getValue();
                max = key.getKey();
            }
        }
        System.out.println("highest frequency element in a given string = "+max);
        
       //3. Using Stream Api
        map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(1)
        .forEach(entry -> System.out.println(entry.getKey()+" : "+entry.getValue()));
    }

}
