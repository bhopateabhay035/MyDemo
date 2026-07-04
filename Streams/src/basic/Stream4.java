package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Stream4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Group a list of strings by their first character.
		List<String> words = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry");
		Map<Character, List<String>> groupedByFirstChar = words.stream()
		    .collect(Collectors.groupingBy(word -> word.charAt(0)));
		System.out.println(groupedByFirstChar);
		// Output: {a=[apple, avocado], b=[banana, blueberry], c=[cherry]}

		//Concatenate strings in reverse order using reduce.
		List<String> words1 = Arrays.asList("Stream", "API", "is", "awesome");
		String reversedConcatenation = words1.stream()
		    .reduce((w1, w2) -> w2 + " " + w1)
		    .orElse("");
		System.out.println(reversedConcatenation); // Output: awesome is API Stream

		//Group words by their length and sort each group alphabetically.
		List<String> words3 = Arrays.asList("java", "stream", "api", "example", "code", "test");
		Map<Integer, List<String>> groupedAndSorted = words3.stream()
				.sorted()
				.collect(Collectors.groupingBy(String::length));
		System.out.println(groupedAndSorted);

		//Convert a map to a list of “key=value” strings.
		Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);
		List<String> keyValuePairs = map.entrySet().stream()
				  .map(entry -> entry.getKey() + ":" + entry.getValue())
				  .collect(Collectors.toList());
		System.out.println(keyValuePairs); // Output: [A=1, B=2, C=3]
		
		//Sum of Digits
		int number = 12345;
		String temp = Integer.toString(number); // convert integer to string To determine array size
		Integer[] array = new Integer[temp.length()];

		for (int i = array.length - 1; i >= 0; i--) {
		    array[i] = number % 10;
		    number = number / 10;
		}
		List<Integer> numbers3 = Arrays.asList(array);
		 int sum = numbers3.stream()
                 .mapToInt(i -> i)
                 .sum();
		System.out.println("Sum of Digits: " + sum);
		
		// for primitive datatype array to Integer list use boxed
		int[] array1 = {1, 2, 3};
		List<Integer> list = Arrays.stream(array1)
				.boxed() //converts int to Integer
				.toList();
		
		//Reverse a List Using Streams
		List<Integer> numb = List.of(1, 4, 3, 2, 5);
		//Starting with Java 21, the SequencedCollection interface introduces a reversed() method. 
		//This is the most efficient way to get a reversed view of a list as a stream. 
		List< Integer > reverse = numb.reversed()
		    .stream()
		    //or
		    //.sorted(Comparator.reverseOrder())
		    .collect(Collectors.toList());
		System.out.println("reverse: " + reverse);

		//Reverse a String Using Streams
		String input = "hello";
		String reversed = input.chars()
				//.mapToObj(c -> String.valueOf((char) c))
				//or
				.mapToObj(c -> (char) c)
				.map(c -> c.toString()) // converting character back to stream
				.reduce(" ",(m,n)-> n+m);
		System.out.println("Reversed String: " + reversed);

		//Find the Sum of All Even Numbers in a Nested List
		List<List<Integer>> listOfLists = List.of(
		    List.of(1, 2, 3),
		    List.of(4, 5, 6),
		    List.of(7, 8, 9)
		);
		int sum1 = listOfLists.stream()
		    .flatMap(List::stream)
		    .filter(n -> n % 2 == 0)
		    .mapToInt(i-> i)
		    .sum();
		System.out.println("Sum of Even Numbers: " + sum1); //Output:Sum of Even Numbers: 20

		//Find the Shortest Palindrome in a List of Strings
		List<String> wordss = List.of("madam", "racecar", "apple","mom", "banana", "level");
		String sPalindrome = wordss.stream()
		    .filter(w -> w.equals(new StringBuilder(w).reverse().toString()))
		    .min((m,n)->Integer.compare(m.length(), n.length()))
		    //or
		    //.min(Comparator.comparingInt(String::length))
		    //or
		    //.reduce((m,n)-> m.length()<n.length()? m:n)
		    .orElse("");
		System.out.println("Shortest Palindrome: " + sPalindrome);
		
		//Find the Number of Words in a String
		String inputt = "hello world this is a test";
		long wordCount = Arrays.stream(inputt.split(" "))
				.count();
		System.out.println("Word Count: " + wordCount);

		Set<String> set = new HashSet<>();
		set.add("Apple");
		set.add("Banana");
		set.add("Orange");

		String objectToFind = "Banana";

		String foundObject = set.stream()
		    .filter(element -> element.contains(objectToFind))
		    .findFirst()
		    .orElse("");
		System.out.println("find particular element from hashset "+foundObject);
		
		//check whether two given arrays are equal or not using streams 
		int[] a = { 3, 5, 2, 5, 2 };
        int[] b = { 2, 3, 5, 5, 1 };
        Arrays.sort(a);
        Arrays.sort(b);
        
        boolean areEqual1 = Arrays.equals(a, b);
        System.out.println("Are arr1 and arr2 equal? " + areEqual1); // Output: true
        //or
        if (a.length == b.length) {
        	boolean allMatch = Arrays.stream(a)
                    .allMatch(i -> a[a.length-i] == b[a.length-i]);
            System.out.println("Are arrays are equal "+allMatch);
        }else
        System.out.println("Are arrays are not equal ");
        
      //Count the Occurrences of Each Element in a List 
      		List<String> words11 = List.of("apple", "banana", "apple", "orange");
      		Map<String, Long> wordCounts = words11.stream()
      		    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
      		System.out.println("Word Counts: " + wordCounts);

      		//most frequent Element in a List Using Streams
      		String ffreq =  wordCounts.entrySet().stream()
      				.sorted((m,n)->Long.compare(n.getValue(),m.getValue()))
      				.map(m -> m.getKey())
      				.findFirst()
      				.orElse(null);
      		
      		//or
      		String ffreq11 =  wordCounts.keySet().stream()
      				.map(m -> m)
      				//.max(Comparator.comparingLong(e-> wordCounts.get(e)))
      				//or
      				.max((m,n)->Long.compare(wordCounts.get(m),wordCounts.get(n)))
      				//or
      				//.reduce((m,n)-> wordCounts.get(m)>wordCounts.get(n) ? m:n)
      				.orElse(null);
      		System.out.println("most frequent Element: " + ffreq+" or "+ffreq11);

      		//Most Frequent Character in a String
      		//1st Count  frequency of each character in a string.
      		String input1 = "dell latitude gallaxy";
      		Map<Character, Long> frequency = input1.replace(" ", "").chars()
      				.mapToObj(c -> (char) c)
      				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
      		char ffreq1 =  frequency.entrySet().stream()
      				.sorted((m,n)->Long.compare(n.getValue(),m.getValue()))
      				//or
      				//.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
      				.map(m -> m.getKey())
      				.findFirst()
      				.orElse(null);
      		System.out.println("most frequent character: " + ffreq1);
      		
      		//3rd Most Frequent Character in a String
      		char ffreq3 =  frequency.entrySet().stream()
      				.sorted((m,n)->Long.compare(n.getValue(),m.getValue()))
      				.map(m -> m.getKey())
      				.limit(3)
      				.skip(2)
      				.findFirst() // findFirst used asterminal operation
      				.orElse(null);
      		System.out.println("3rd most frequent character: " + ffreq3);
      		
      	//2nd Most Frequent Character in a String
      		frequency.entrySet().stream()
      				.sorted((m,n)->Long.compare(n.getValue(),m.getValue()))
      				//or
      				//.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
      				.map(m -> m.getKey())
      				.limit(2)
      				.skip(1)
      				.forEach(entry -> System.out.println("2nd Most Frequent Character : "+entry.charValue()));
      		
      	//top 3 Most Frequent Character in a String
      		List<Character> freq3 = frequency.entrySet().stream()
      				.sorted((m,n)->Long.compare(n.getValue(),m.getValue()))
      				.map(m -> m.getKey())
      				.limit(3)
      				.collect(Collectors.toList());
      		System.out.println("3 Most Frequent Character : "+freq3);
      		freq3.forEach(s -> System.out.println("3 Most Frequent Character : "+s.charValue()));
	}

}
