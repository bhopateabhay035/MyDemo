package list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample1 {
    public static void main(String[] args) {
        // Create a List using LinkedList
        List<Integer> numbers = new LinkedList<>();

        // Add elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(40);
        numbers.add(null);
        numbers.add(30);
        numbers.add(20);
        numbers.add(null);
        System.out.println("Initial List: " + numbers); // Output: List: [10, 20, 30]

     // Add an element at a specific index
        numbers.add(4, 15);
     // Set replaces elements at a given index with the new element
        numbers.set(0, 70);
        System.out.println("List after adding 15 at index 4: " + numbers); // Output: List after adding 15 at index 1: [10, 15, 20, 30]

        // Remove an element by index
        int removedNumber = numbers.remove(2); // Removes 40
        System.out.println("Removed Element: " + removedNumber); // Output: Removed Element: 40
        System.out.println("List after removal: " + numbers); // Output: List after removal: [10, 15, 30]
    
     // use indexOf() to find the first occurrence of an element in the list
        int i = numbers.indexOf(20);
        System.out.println("First Occurrence of 20 is at Index: "+i);

        // use lastIndexOf() to find the last occurrence of an element in the list
        int l = numbers.lastIndexOf(20);
        System.out.println("Last Occurrence of 20 is at Index: "+l);
        
     // Accessing elements using get() method
       System.out.println(numbers.get(6));
       
    // Using  for loop for iteration
       for (int i1 = 0; i1 < numbers.size(); i1++) {

           // Using get() method to access particular element
           System.out.print(numbers.get(i1) + " ");
       }
       // New line for better readability
       System.out.println();

       // Using for-each loop for iteration
       for (Integer str : numbers)           
           System.out.print(str + " ");
       
       List<String> list1 = new LinkedList<String>();
	    list1.add("John");
	    list1.add(1, "Herry");
	   // list1.add(1, "Ivaan"); will work
	    list1.add(3, "Ivaan"); // will throw java.lang.IndexOutOfBoundsException: Index: 3, Size: 2
	    list1.add("Deep");
	    System.out.println(list1);
   
    }
}
