package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Stream3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create a custom collector to join strings with a delimiter.
		List<String> words = Arrays.asList("Java", "Stream", "API");
		String joined = words.stream()
		    .collect(Collectors.joining(", "));
		System.out.println(joined); // Output: Java, Stream, API
		
		//Remove null values from a list using filter.
		List<String> words1 = Arrays.asList("Java", null, "Stream", null, "API");
		List<String> nonNullWords = words1.stream()
				.filter(n -> n!=null)
		    //.filter(Objects::nonNull)
		    .collect(Collectors.toList());
		System.out.println("non nulls are "+nonNullWords); // Output: [Java, Stream, API]

		//Calculate the average of a list of integers.
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
		double average = numbers.stream()
		    .mapToInt(i -> i)
		   //.mapToInt(Integer::intValue)
		    .average()
		    .orElse(0.0); // this is necessary
		int su = numbers.stream()
			    .mapToInt(i -> i)
			   //.mapToInt(Integer::intValue)
			    .sum();
		System.out.println("average of a list of integer "+average+" and sum is "+su); // Output: 30.0

		//Convert a list of strings into a map with the string as the key and its length as the value.
		List<String> words2 = Arrays.asList("Java", "Stream", "API");
		Map<String, Integer> wordLengthMap = words2.stream()
		    .collect(Collectors.toMap(word -> word, String::length));
		System.out.println(wordLengthMap); // Output: {Java=4, Stream=6, API=3}

		//Partition a list of numbers into even and odd.
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Map<Boolean, List<Integer>> partitioned = numbers1.stream()
		    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println(partitioned);
		// Output: {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8]}
		
		//Find the 3rd largest element in a list.
		List<Integer> numbers2 = Arrays.asList(10, 20, 50, 40, 30);
		int nthLargest = numbers2.stream()
		    .sorted(Comparator.reverseOrder())
		    .skip(2)
		    .findFirst()
		    .orElse(0);
		System.out.println("3rd lagest "+nthLargest); // Output: 30
		
		//Find the top 3 largest element in a list.
		List<Integer> numberl = Arrays.asList(10, 20, 50, 40, 30);
		List<Integer> tLargest = numberl.stream()
			.sorted(Comparator.reverseOrder())
			.limit(3)
			.collect(Collectors.toList());
		System.out.println("top 3 largest element "+tLargest); // Output: 30

		//Find all strings that are palindromes in a list.
		List<String> words3 = Arrays.asList("radar", "level", "world", "java");
		List<String> palindromes = words3.stream()
		    .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
		    .collect(Collectors.toList());
		System.out.println(palindromes); // Output: [radar, level]

		//Reverse each string in a list.
		List<String> words4 = Arrays.asList("Java", "Stream", "API");
		List<String> reversedWords = words4.stream()
		    .map(word -> new StringBuilder(word).reverse().toString())
		    .collect(Collectors.toList());
		System.out.println(reversedWords); // Output: [avaJ, maertS, IPA]
		
		//Given a map, filter entries with values greater than 10 and collect keys into a list.
		Map<String, Integer> map = Map.of("A", 5, "B", 15, "C", 10, "D", 20);
		List<String> keys = map.entrySet().stream()
		    .filter(entry -> entry.getValue() > 10)
		    //.map(Map.Entry::getKey)
		    //or
		    .map(entry -> entry.getKey())
		    .collect(Collectors.toList());
		System.out.println("entries with values greater than 10 "+keys); // Output: [B, D]

		//Remove duplicates from a list using distinct().
		List<Integer> numbers3 = Arrays.asList(1, 2, 3, 2, 4, 3, 5);
		List<Integer> uniqueNumbers = numbers3.stream()
		    .distinct()
		    .collect(Collectors.toList());
		System.out.println(uniqueNumbers); // Output: [1, 2, 3, 4, 5]

		//Find common elements between two lists.
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
		List<Integer> common = list1.stream()
				.filter(l1 -> list2.contains(l1))
		   // .filter(list2::contains)
		    .collect(Collectors.toList());
		System.out.println("common elements between two lists "+common); // Output: [3, 4, 5]

		//Calculate the sum of squares of all even numbers in a list.
		List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6);
		int sumOfSquares = numbers4.stream()
		    .filter(n -> n % 2 == 0)
		    .mapToInt(n -> n * n)
		    //.sum();
		    //or
		    .reduce(0, (m,n) -> m+n);
		System.out.println("sumOfSquares "+sumOfSquares); // Output: 56 (2^2 + 4^2 + 6^2)

		//Partition strings into palindromes and non-palindromes.
		List<String> words5 = Arrays.asList("radar", "level", "java", "stream");
		Map<Boolean,List<String>> map3 = words5.stream()
				.collect(Collectors.partitioningBy(word -> word.equals(new StringBuilder(word).reverse().toString())));
		System.out.println("Partition strings into palindromes and non-palindrome "+map3);
		// Output: {false=[java, stream], true=[radar, level]}

		//Skip the first 3 elements and limit the result to the next 2.
		List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> result = numbers5.stream()
		    .skip(3)
		    .limit(2)
		    .collect(Collectors.toList());
		System.out.println(result); // Output: [4, 5]

		//Find the longest word in a sentence using Streams.
		String sentence = "Java Stream API is very powerful";
		String longestWord = Arrays.stream(sentence.split(" "))
		    //.max(Comparator.comparingInt(String::length))
		    //.orElse(null);
		//or
		.reduce(" ", (m,n) -> m.length()>n.length() ? m:n);
		System.out.println("longestWord "+longestWord); // Output: powerful
		
		//Compute the Cartesian product of two lists of integers.
		List<Integer> list11 = Arrays.asList(1, 2, 3);
		List<Integer> list22 = Arrays.asList(4, 5);
		List<String> cartesianProduct = list11.stream()
		    .flatMap(i -> list22.stream()
		    		.map(j -> "(" + i + "," + j + ")"))
		    .collect(Collectors.toList());
		System.out.println(cartesianProduct); // Output: [(1,4), (1,5), (2,4), (2,5), (3

	}

}
