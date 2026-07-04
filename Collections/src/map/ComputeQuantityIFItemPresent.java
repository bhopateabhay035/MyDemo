package map;

import java.util.HashMap;
import java.util.Map;

public class ComputeQuantityIFItemPresent {
    public static void main(String[] args) 
    {
        //Creating an empty shoppingCartMap
        HashMap<String, Integer> shoppingCartMap = new HashMap<String, Integer>();
        HashMap<String, Integer> finalCartMap = new HashMap<String, Integer>();
        
        //Adding items into shoppingCartMap
        addToCart(shoppingCartMap,finalCartMap, "Pen", 5);
        addToCart(shoppingCartMap,finalCartMap, "Pencil", 10);
        addToCart(shoppingCartMap,finalCartMap, "Eraser", 7);
        addToCart(shoppingCartMap,finalCartMap, "Pen", 3);
        addToCart(shoppingCartMap,finalCartMap, "Sharpener", 6);
        addToCart(shoppingCartMap,finalCartMap, "Pen", 4);
        addToCart(shoppingCartMap,finalCartMap, "Note Book", 5);
        addToCart(shoppingCartMap,finalCartMap, "Pencil", 8);
        
        System.out.println("after adding "+finalCartMap);
        //Printing shoppingCartMap
        shoppingCartMap.forEach((key, value) -> System.out.println(key+" : "+value));
    }
     
    public static void addToCart(Map<String, Integer> shoppingCartMap,Map<String, Integer> finalCartMap, String item, Integer qty)
    {

      	//Using compute function
        //If item is already present, increase the qty
        shoppingCartMap.computeIfPresent(item, (key, value) -> value + qty);
         
        //If item is not present, add it with initial qty
        shoppingCartMap.computeIfAbsent(item, value -> qty);
    }

}
