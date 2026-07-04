package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {

	public static void main(String[] args) {

		//Given a list of integers, filter the even numbers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> evenNumbers = numbers.stream()
		    .filter(n -> n % 2 == 0)
		    .collect(Collectors.toList());
		System.out.println(evenNumbers); 

		//Find the maximum number from a list of integers.
		List<Integer> numbers1 = Arrays.asList(10, 70, 30, 40, 50);
		int maxNumber = numbers1.stream()
				//.max(Integer::compare)
				//or
				//.max((m,n) -> Integer.compare(m, n))
				//.orElse(0);
				//or
				.reduce((m,n) -> m>n ? m:n)
				.orElse(0);
		//or
		//.mapToInt(i->i)
		//.max().orElse(0);
		//or
		/*
		 * List<Integer> maxNumber = numbers1.stream()
		 * .sorted(Comparator.reverseOrder()) 
		 * .limit(1) 
		 * .collect(Collectors.toList());
		 */
		System.out.println("max no is "+maxNumber); // Output: 50
		
		//Sort a list of integers in descending order.
		List<Integer> numbers2 = Arrays.asList(3, 5, 1, 4, 2);
		List<Integer> sortedNumbers = numbers2.stream()
		    .sorted(Comparator.reverseOrder())
				//or
			//.sorted((m,n) -> Integer.compare(n, m))
		    //.sorted() //ascending order
		    .collect(Collectors.toList());
		System.out.println(sortedNumbers); // Output: [5, 4, 3, 2, 1]

		//Count strings starting with a specific prefix, e.g., “A”.
		List<String> names = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
		long count = names.stream()
		    .filter(name -> name.startsWith("A"))
		    .count();
		System.out.println(count); // Output: 3
		
		//Find the first non-repeated character in a string.
		String input = "swiss";
		Optional<Character> firstNonRepeated = input.chars()
		    .mapToObj(c -> (char) c)
		    .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
		    .findFirst();
		//or
		Character ch = input.chars()
			    .mapToObj(c -> (char) c)
			    .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
			    .findFirst().orElse(null);
			    
		System.out.println("first non-repeated character is "+firstNonRepeated.get()+" or "+ch); // Output: w
		
		//finding 1st non repeated integer
        int x[] = {3,1,2,3,1,4,3,1};
    	Map <Integer,Long> z= Arrays.stream(x)
    			.boxed()  // used to convert primitive int to Integer
    		    //.collect(Collectors.groupingBy(i-> i, Collectors.counting()));
    			//we should use LinkedHashMap to maintain order of map to make sure we get 1st non repeated int
    			//because while iteration Map doesn't maintain order
    			//so if there are more than one non repeated element it can become difficult to tell which is 1st
    			.collect(Collectors.groupingBy(i-> i,LinkedHashMap::new, Collectors.counting()));
    	System.out.println("arr "+z);
    	
    	Integer l = z.entrySet().stream()
    			.filter(m -> m.getValue()==1)
    			.map(n -> n.getKey())
    			.findFirst().orElse(0);
    	System.out.println("non "+l);
        
    	//finding most repeated integer
    	Integer l1 = z.entrySet().stream()
    			.sorted((m,n) -> Long.compare(n.getValue(), m.getValue()))
    			.map(n -> n.getKey())
    			.findFirst().orElse(0);
    	System.out.println("most "+l1);
    	
		//Convert all strings in a list to uppercase.
		List<String> names1 = Arrays.asList("java", "stream", "api");
		List<String> uppercaseNames = names1.stream()
		    .map(String::toUpperCase)
		    .collect(Collectors.toList());
		System.out.println("uppercaseNames "+uppercaseNames); // Output: [JAVA, STREAM, API]
		
		//Calculate the sum of all odd numbers in a list.
		List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers3.stream()
                         .filter(n -> n % 2 != 0) // Filter odd numbers
                        // .mapToInt(Integer::intValue) // Convert to IntStream
                          .mapToInt(i -> i)
                         .sum(); // Sum the elements

        System.out.println("Sum of odd numbers: " + sum); // Output: 25

      //sum of all elements
      	List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        int sum1 = numbers5.stream()
        			//.reduce(0, (element1, element2) -> element1 + element2);
        			.reduce(0, Integer::sum);
      // Displaying the sum of all elements
         System.out.println("The sum of all elements is " + sum1);
              
       //product of all elements
       	List<Integer> prods = Arrays.asList(1, 2, 3, 4, 5);
         int prod = prods.stream()
         			.reduce(1, (element1, element2) -> element1 * element2);
       // Displaying the prod of all elements
          System.out.println("The product of all elements is " + prod);
          
        //min of all elements
          //use orElse for finding min/max for reduce(1,(m,n)-> m>n?m:n) 
          //bcoz this 1 is also used during comparison 
          //but if we dont use this 1 or orElse at end then we need to use Optional class
          //also we require ? m:n only during comparison i.e minmax and not during summing
         List<Integer> el = Arrays.asList(4, 2, 3, 6, 5);
         int minEl = el.stream()
        		 .mapToInt(i->i)
        		 .min()
        		 .orElse(0);
         //or
         //		 .reduce(0,(a, b) -> Integer.min(a, b));
         //or
         //		 .reduce((element1, element2) -> element1 < element2 ? element1 : element2)
         //		 .orElse(0);
         // Displaying the prod of all elements
          System.out.println("/minimum of all elements is " + minEl);
            
       // Check if any string in a list contains “API”.
        List<String> strings = Arrays.asList("Java", "Stream API", "Lambda");
        boolean containsAPI = strings.stream()
            .anyMatch(s -> s.contains("API"));
        System.out.println("Check if any string in a list contains "+containsAPI); // Output: true

        //Identify duplicate elements in a list.
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 2, 5, 1);
        Set<Integer> unique = new HashSet<>();
        Set<Integer> duplicates = numbers4.stream()
            .filter(n -> !unique.add(n))
            .collect(Collectors.toSet());
        System.out.println("duplicate elements in a list "+duplicates); // Output: [1, 2]

      //Identify unique elements in a list.
        List<Integer> numbers10 = Arrays.asList(1, 2, 3, 4, 2, 5, 1);
        Map<Integer,Long> uniMap = numbers10.stream()
            .collect(Collectors.groupingBy(s-> s,Collectors.counting()));
        List<Integer> uni = uniMap.entrySet().stream()
        		.filter(n -> n.getValue()==1)
        		.map(m-> m.getKey())
        		.collect(Collectors.toList());
        System.out.println("unique elements in a list "+uni); // Output: [3, 4, 5]
        
        //Group a list of strings based on their length.
        List<String> words = Arrays.asList("Java", "Stream", "API", "Code", "Fun");
        Map<Integer, List<String>> groupedByLength = words.stream()
            .collect(Collectors.groupingBy(String::length));
        	//.collect(Collectors.groupingBy(s -> s.length()));
        System.out.println("Group a list of strings based on their length "+groupedByLength);
        // Output: {3=[API], 4=[Java, Code, Fun], 6=[Stream]}
      //Group a list of strings based on their length and store in Set.
        Map<Integer, Set<String>> sgroupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length,Collectors.mapping(s -> s, Collectors.toSet())));
        		//or
        		//.map(s->s)
            	//.collect(Collectors.groupingBy(String::length,Collectors.toSet()));
            System.out.println("Group a Set of strings based on their length "+sgroupedByLength);

        
    	//transform 1st character to uppercase
    	List<String> titles = Arrays.asList("java basics", "programming principles", "data structures");
    	List<String> capitalizedTitles = titles.stream()
    	        .map(title -> title.substring(0, 1).toUpperCase() + title.substring(1))
    	        .collect(Collectors.toList());
    	System.out.println(capitalizedTitles);
    	
    	//convert list of string to string sentence
    	String sen = titles.stream()
    			.reduce("", (m,n) -> m+" "+n);
    	System.out.println("list after converting to string "+sen);
    	
        // Check if any character is NOT a letter or a digit
    	String strin = "my @world 10";
    	Boolean hasSpecial = false;
        if (!(strin == null || strin.isEmpty())) {
        	hasSpecial = strin.chars()
        			.mapToObj(m->(char)m)
                    .anyMatch(c -> !Character.isLetterOrDigit(c));
        }
        System.out.println("does string contain any spl char "+hasSpecial);
        
        //revers string
        String s = "Geeks";
        char[] arr = s.toCharArray();
        String r = "";
        for (int i = arr.length-1; i >=0; i--){
            r = r + s.charAt(i);
            }
        System.out.println("reverse is "+r);
	}

}
