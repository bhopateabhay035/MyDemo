package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import functionalinterface.Func;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Lambda expression to add two numbers
        Func add = (a, b) -> a + b;
        int result = add.operation(10, 20);
        System.out.println("Sum: " + result);
        
        Func mul = (a, b) -> a * b;
        int result1 = mul.operation(10, 20);
        System.out.println("multiply: " + result1);
////////////////////////

        String mySentence = "Using lambdas in java";
        
/// We are not specifying that we create a new class that implements the Consumer interface with the new keyword.
/// We are not specifying that we implement the accept method of the interface

        Consumer<String> lambda = sentence -> {
            String[] words = sentence.split(" ");
            for (String word: words) {
                System.out.println(word);
            }
        };
        lambda.accept(mySentence);
//OR
        Consumer<String> shortLambda = sentence -> Arrays.asList(sentence.split(" "))
        		.forEach(System.out::println);
        		shortLambda.accept(mySentence);
////////////////////////
// 
        // Consumer to multiply 2 to every integer of a list
                Consumer<List<Integer> > modify = list ->
                {
                    for (int i = 0; i < list.size(); i++)
                        list.set(i, 2 * list.get(i));
                };
             // Consumer to display a list of numbers
                Consumer<List<Integer> > dispList = list -> 
                list.stream().forEach(a -> System.out.print(a + " "));

                List<Integer> list = Arrays.asList(1,2,4);

                // Implement modify using accept()
                modify.accept(list);

                // Implement dispList using accept()
                dispList.accept(list);


	}

}
