package basic;

import java.util.function.Consumer;

public class BeforeLambda implements Consumer<String> {

	@Override
	public void accept(String t) {
		String sentence = "";
        String[] words = sentence.split(" ");
        for (String word: words) {
            System.out.println(word);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mySentence = "Using lambdas in java";
		BeforeLambda separator = new BeforeLambda();
		  separator.accept(mySentence);

	}

	//We need to specifying that we create a new class that implements the Consumer interface with the new keyword.
	//We need to specifying that we implement the accept method of the interface

}
