package arrange;

import java.util.Arrays;

public class BubbleSort {
	
	

	public static void main(String[] args) {
		int arr[] = {2,9,8,4}; 
		int n = arr.length;
		
		String[] arrStr = {"Grape", "Apple", "Mango", "Banana", "Cherry"};
		int m = arrStr.length; 
		
		//sort int in ascending order
		for(int i=0; i<n-1;i++) {
			for(int j=0; j<n-1;j++) {
				if(arr[j]>arr[j+1]) { 
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		//sort String in acsending order
		for (int i = 0; i < m - 1; i++) {
            // Inner loop for adjacent comparisons
            for (int j = 0; j < m - 1 - i; j++) {
                // compareTo returns > 0 if arr[j] is lexicographically greater than arr[j+1]
                if (arrStr[j].compareTo(arrStr[j + 1]) > 0) {
                    // Swap elements
                    String temp = arrStr[j];
                    arrStr[j] = arrStr[j + 1];
                    arrStr[j + 1] = temp;
                }
            }
        }
		System.out.println(Arrays.toString(arrStr));
				
	}
}
