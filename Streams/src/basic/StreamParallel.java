package basic;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamParallel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Find the Sum of All Elements in a List Using Parallel Streams
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		int sum = numbers.parallelStream()
		    .mapToInt(Integer::intValue)
		    .sum();
		System.out.println("Sum: " + sum);

	//	Find the Minimum Element in a List Using Parallel Streams
		List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
		int min = numbers1.parallelStream()
		    .min(Integer::compare)
		    .orElse(0);
		//or
		//.mapToInt(i->i)
		//.min().orElse(0);
		System.out.println("min " + min);
		
//		Find the product of all Element in a List Using Parallel Streams
			List<Integer> numbers11 = List.of(1, 2, 3, 4, 5);
			int pro = numbers11.parallelStream()
			    .reduce(1, (m,n) -> m*n);
			System.out.println("product " + pro);

		//Sort a List of Integers in Parallel Using Parallel Streams
		List<Integer> numbers2 = List.of(5, 3, 1, 4, 2);
		List<Integer> sortedNumbers = numbers2.parallelStream()
		    .sorted()
		    .collect(Collectors.toList());
		System.out.println("Sorted Numbers: " + sortedNumbers);

	//	Filter a List of Strings in Parallel Using Parallel Streams
		List<String> words = List.of("apple", "banana", "kiwi", "mango");
		List<String> filteredWords = words.parallelStream()
		    .filter(word -> word.length() > 4)
		    .collect(Collectors.toList());
		System.out.println("Filtered Words: " + filteredWords);

		//Count the Occurrences of Each Element in a List Using Parallel Streams
		List<String> words1 = List.of("apple", "banana", "apple", "orange");
		Map<String, Long> wordCounts = words1.parallelStream()
		    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println("Word Counts: " + wordCounts);

		//most frequent Element in a List Using Parallel Streams
		String ffreq =  wordCounts.entrySet().parallelStream()
				.sorted((m,n)->Long.compare(n.getValue(),m.getValue()))
				.map(m -> m.getKey()).findFirst().orElse(null);
			//.orElse(null);
		System.out.println("most frequent Element: " + ffreq);

		//Most Frequent Character in a String
		//1st Count  frequency of each character in a string.
		String input = "dell latitude gallaxy";
		Map<Character, Long> frequency = input.replace(" ", "").chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		char ffreq1 =  frequency.entrySet().parallelStream()
				.sorted((m,n)->Long.compare(n.getValue(),m.getValue()))
				.map(m -> m.getKey()).findFirst().orElse(null);
		System.out.println("most frequent character: " + ffreq1);
		
		//3rd Most Frequent Character in a String
		char ffreq2 =  frequency.entrySet().parallelStream()
				.sorted((m,n)->Long.compare(n.getValue(),m.getValue()))
				.map(m -> m.getKey()).skip(2).findFirst().orElse(null);
		System.out.println("3rd most frequent character: " + ffreq2);
		
		//Merge Two Lists in Parallel Using Parallel Streams
		List<Integer> list1 = List.of(1, 2, 3);
		List<Integer> list2 = List.of(4, 5, 3);
		List<Integer> merged = Stream.concat(list1.parallelStream(), list2.parallelStream())
		    .collect(Collectors.toList());
		System.out.println("Merged List: " + merged);
// or use below way
		Stream<List<Integer>> str = Stream.of(list1,list2);
		List<Integer> merged1 = str.flatMap(List::stream)
				.collect(Collectors.toList());
		//merged1.forEach(System.out::println);
		System.out.println("Merged List1: " + merged1);
		
		//Find the Union of Two Lists
		Stream<List<Integer>> str1 = Stream.of(list1,list2);
		List<Integer> union = str1.flatMap(List::stream)
		    .distinct()
		    .collect(Collectors.toList());
		System.out.println("Union: " + union);

		//Find the Intersection or common elements of Two Lists Using Parallel Streams
		List<Integer> list11 = List.of(1, 2, 3, 4);
		List<Integer> list22 = List.of(3, 4, 5, 6);
		List<Integer> intersection = list11.parallelStream()
		    .filter(list -> list22.contains(list))
		    .collect(Collectors.toList());
		System.out.println("Intersection: " + intersection);

	}

}
