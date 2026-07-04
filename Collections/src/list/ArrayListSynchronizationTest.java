package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListSynchronizationTest { 
public static void main(String[] args) 
{ 
// Create an ArrayList object with initial capacity of 10. 
// Non-synchronized ArrayList Object. 
   List<String> l = new ArrayList<String>(); 

// Add elements in the list. 
    l.add("Apple"); 
    l.add("Orange"); 
    l.add("Banana"); 
    l.add("Pineapple"); 
    l.add("Guava"); 

// Synchronizing ArrayList in Java. 
   List<String> synlist = Collections.synchronizedList( l ); // l is non-synchronized. 

// Here, we will use a synchronized block to avoid the non-deterministic behavior. 
   synchronized(synlist) 
   { 
   // Call iterator() method to iterate the ArrayList. 
      Iterator<String> itr = synlist.iterator(); 
      while(itr.hasNext())
      { 
         String str = itr.next(); 
         System.out.println(str);
         if(str.equals("Orange")) {
         //synlist.add("Mango");
         itr.remove();
         System.out.println("after remove "+synlist);
         }
      } 
   // Call ListIterator() method to iterate the ArrayList. 
      ListIterator<String> itrList = synlist.listIterator();
      while(itrList.hasNext())
      { 
        String str = itrList.next(); 
        System.out.println(str);
        if(str.equals("Banana")) {
        	 // here we have add() which is absent in normal iterator
         //synlist.add("Mango");
        itrList.remove();
        itrList.add("Mango");	 
        // if we add() first and then remove() then throws exception
        System.out.println("after add/remove in list itr "+synlist);
         }
      } 
    } 
  } 
}
