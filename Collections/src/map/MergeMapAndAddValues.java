package map;

import java.util.HashMap;
import java.util.Map;

public class MergeMapAndAddValues {
	public static void main(String[] args) 
    {         
        HashMap<String, Integer> subjectStudentMapOne = new HashMap<String, Integer>();
        subjectStudentMapOne.put("Mathematics", 10);
        subjectStudentMapOne.put("Physics", 52);
        subjectStudentMapOne.put("History", 5);
        subjectStudentMapOne.put("Economics", 61);
         
       HashMap<String, Integer> subjectStudentMapTwo = new HashMap<String, Integer>();
        subjectStudentMapTwo.put("Mathematics", 20);
        subjectStudentMapTwo.put("Chemistry", 59);
        subjectStudentMapTwo.put("Biology", 44);
        subjectStudentMapTwo.put("History", 5);
         
        HashMap<String, Integer> subjectStudentMap = new HashMap<String, Integer>();
      //Merging subjectStudentMapOne and subjectStudentMapTwo into subjectStudentMap
        subjectStudentMap.putAll(subjectStudentMapOne);
        subjectStudentMap.putAll(subjectStudentMapTwo);
        System.out.println("before merged "+subjectStudentMap);
        
        for(String i : subjectStudentMapOne.keySet()) {
        	for(String j : subjectStudentMapTwo.keySet()) {
        		if(i.equals(j)) {
        			subjectStudentMap.put(j,subjectStudentMapOne.get(i)+subjectStudentMapTwo.get(j));
        		}
        	}
        }
        System.out.println("after merged "+subjectStudentMap);
        
        //OR using merge function
        //Merging subjectStudentMapOne and subjectStudentMapTwo into subjectStudentMapThree
        HashMap<String, Integer> subjectStudentMapThree = new HashMap<String, Integer>(subjectStudentMapOne);
         
        subjectStudentMapTwo.forEach((key, value) -> subjectStudentMapThree.merge(key, value, (v1, v2) -> v1+v2));
        System.out.println("Merged_Subject_Students_Map");
        subjectStudentMapThree.forEach((key, value) -> System.out.println(key+" : "+value));
    }

}
