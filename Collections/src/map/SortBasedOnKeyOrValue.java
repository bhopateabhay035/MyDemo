package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortBasedOnKeyOrValue {
	public static void main(String[] args) 
    {
        
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");
        map.put(4, "FOUR");
        map.put(5, "FIVE");
         
        //Sorting map based on keys (Natural Order)
        System.out.println("sorting key is ascending");
        map.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .forEach(entry -> System.out.println(entry.getKey()+" : "+entry.getValue()));
         
        //Sorting map based on keys (Reverse Order)
        System.out.println("sorting key is descending");
        map.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                        .forEach(entry -> System.out.println(entry.getKey()+" : "+entry.getValue()));
         
        //Sorting map based on values (Natural Order)
        System.out.println("sorting value is ascending");
        map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .forEach(entry -> System.out.println(entry.getKey()+" : "+entry.getValue()));
         
        //Sorting map based on values (Reverse Order)
        System.out.println("sorting value is descending");
        map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .forEach(entry -> System.out.println(entry.getKey()+" : "+entry.getValue()));   
    }

}
