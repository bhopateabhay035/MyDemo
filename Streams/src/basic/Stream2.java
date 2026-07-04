package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Given a list of lists, flatten it into a single list.
		List<List<Integer>> listOfLists = Arrays.asList(
		    Arrays.asList(1, 2, 3),
		    Arrays.asList(4, 5),
		    Arrays.asList(6, 7, 8, 9)
		);
		List<Integer> flattenedList = listOfLists.stream()
		    .flatMap(List::stream)
		    .collect(Collectors.toList());
		System.out.println("lists, flatten it into a single list "+flattenedList); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

		//Count the frequency of each character in a string.
		String input = "success story";
		Map<Character, Long> frequency = input.replace(" ", "").chars()
		    .mapToObj(c -> (char) c)
		    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println("frequency of each character in sentence "+frequency); // Output: {s=3, u=1, c=2, e=1}
		
		//Create a map with string as the key and its length as the value.
		List<String> words2 = Arrays.asList("Java", "Stream", "API");
		Map<String, Integer> wordLengthMap = words2.stream()
			.collect(Collectors.toMap(word -> word, String::length));
		System.out.println(wordLengthMap); // Output: {Java=4, Stream=6, API=3}		
		
		//Count the frequency of each word in a list.
		List<String> inpu = Arrays.asList("abc","xyz","abc","pqr");
		Map<String, Long> freq = inpu.stream()
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println("frequency of each element in list "+freq); // Output: {s=3, u=1, c=2, e=1}
				
		//Stream.reduce() in Java
		
		//Concatenate all strings in a list into a single string.
		List<String> words = Arrays.asList("Stream", "API", "is", "powerful");
		String concatenated = words.stream()
		    .reduce("", (s1, s2) -> s1 + " " + s2)
		    .trim();
		System.out.println("concatenated string "+concatenated); // Output: Stream API is powerful

		//Find the longest string in a list.
		//use orElse for finding min/max for reduce(1,(m,n)-> m>n?m:n) 
        //bcoz if we use 1 in reduce fn then it is also used during comparison 
        //but if we dont use this 1 or orElse at end then we need to use Optional class
		//also we require ? m:n only during comparison i.e minmax and not during summing
		List<String> words11 = Arrays.asList("Java", "Stream", "API", "Development");
		String longest = words11.stream()
		//	.max(Comparator.comparingInt(m -> m.length())).orElse("");
		//or
		//	.max(Comparator.comparingInt(String::length)).orElse("");
		//or
		    .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
		    .orElse("");
		System.out.println("longest string in a list "+longest); // Output: Development

		//sum of all elements
		List<Integer> numbers = Arrays.asList(3,1,-3,5);
        int sum = numbers.stream()
            .reduce(0, (element1, element2) -> element1 + element2);
        //or
        //.mapToInt(i->i)
        //.sum();
        System.out.println("The sum of all elements is " + sum); 
        //or using Optional class
        Optional<Integer> sum1 = numbers.stream()
        		.reduce(Integer::sum);
        // Print the sum if present
        sum1.ifPresent(n -> System.out.println("The sum of all elements is " + n));
        
        // Calculating the product of all numbers in the range [2, 8)
        int product = IntStream.range(3, 6)
            .reduce((num1, num2) -> num1 * num2)
            .orElse(-1); // Provides -1 if the stream is empty
        System.out.println("The product is : " + product); 
      //or using Optional class
        int product1 = IntStream.range(0,0)
                .reduce(-1, (num1, num2) -> num1 * num2); // Provides 1 if the stream is empty
            System.out.println("The product is : " + product1); 
            
      // find max element
        List<Integer> numbers3 = Arrays.asList(1, 7, 3, 4, 5);
        Optional<Integer> max = numbers3.stream()
        		.reduce(Integer::max);
        max.ifPresent(value -> System.out.println("Max: " + value)); 
       // or
        int ma = numbers3.stream()
        		.mapToInt(i->i)
        		.max()
        		.orElse(0);
        System.out.println("Max is: " + ma);
            
		//Parallel Stream 
		
		//Use parallel streams to compute the sum of numbers.
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
		int sum2 = numbers1.parallelStream()
		//    .mapToInt(Integer::intValue)
		//    .sum();
		//OR
			.reduce(0, (m,n) -> m+n);
		System.out.println("parallel streams to compute the sum "+sum2); // Output: 15

	}

}
