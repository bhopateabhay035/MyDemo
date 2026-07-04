package list;

import java.util.Iterator; 
import java.util.LinkedList;
import java.util.ListIterator; 
public class LinkedListExample2 { 
public static void main(String[] args) 
{ 
// Create a generic LinkedList object of Character type. 
   LinkedList<Character> list = new LinkedList<Character>(); 

// Adding elements in the list. 
    list.add('A'); 
    list.add('B'); 
    list.add('C'); 
    list.add('D'); 
    list.add('E'); 

// Iterating using Iterator. 
   System.out.println("**Using Iterator**"); 
   Iterator<Character> itr = list.iterator(); 
   while(itr.hasNext())
   { 
     Object obj = itr.next(); 
     System.out.println("character "+obj); 
     if(obj.equals('C')) {
    	 itr.remove();
     } 
   } 
   System.out.println("after remove "+list);
   
   ListIterator<Character> litr = list.listIterator(); 
   System.out.println("Interating in forward direction"); 
   while(litr.hasNext())
   { 
     Object obj = litr.next(); 
     System.out.println("in list iterator "+obj); 
   } 
   System.out.println("Iterating in backwrd direction"); 
   while(litr.hasPrevious())
   { 
      Object obj1 = litr.previous(); 
      System.out.println(obj1); 
  
      if(obj1.equals('D')) {
   // Below statement will throw Concurrent Modification Exception 
   // because we cannot add or remove an element in the LinkedList during the iteration.
      //list.add('Z');  
      litr.add('Z');
      }
    } 
   System.out.println("after remove list "+list); 
  } 
}