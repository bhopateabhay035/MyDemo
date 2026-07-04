package map;

import java.util.HashMap;
import java.util.Map;

public class PassStudentWithGraceMarks {
    public static void main(String[] args) 
    {
        //Creating an empty HashMap with default initial capacity and default load factor 
        HashMap<String, Integer> studentNameMarksMap = new HashMap<String, Integer>();
         
        //Inserting entries into studentNameMarksMap
        studentNameMarksMap.put("Aditya Sen", 57);
        studentNameMarksMap.put("Harris Brar", 34);
        studentNameMarksMap.put("Sarah Amin", 61);
        studentNameMarksMap.put("Andriel Hope", 31);
        studentNameMarksMap.put("Arun Trivedi", 29);
         
        studentNameMarksMap.forEach((key, value) -> System.out.println("Before Update key : "+key+" and value : "+value));
         
//        for(Map.Entry<String, Integer> entry : studentNameMarksMap.entrySet()){
//        	if(entry.getValue()>30 && entry.getValue()<35) {
//        		studentNameMarksMap.replace(entry.getKey(), 35);
//        	}
//        }
        
//OR using lambda
        studentNameMarksMap.forEach((key, value) -> {
        	if(value>30 && value<35) {
        		studentNameMarksMap.replace(key, 35);
        	}
        });
        
         
        studentNameMarksMap.forEach((key, value) -> System.out.println("After Update key ; "+key+" and value : "+value));
    }

}
