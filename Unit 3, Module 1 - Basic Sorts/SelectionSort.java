import static java.lang.System.out;

import java.util.Random;

public class SelectionSort {
	public static int[] sortArray(int[] array) {
		for(int i=0; i<array.length-1; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[i] > array[j]) {
					int c = array[i];
					array[i] = array[j];
					array[j] = c;
				}
			}
		}
		
		return array;
	}
	
	public static void printArray(int[] inputArray) {
		out.print("[");
		for(int i=0; i<inputArray.length; i++) {
			if(i==0) {
				out.print(inputArray[i]);
			} else {
				out.print(" ");
				out.print(inputArray[i]);
			}
			if(i==(inputArray.length-1)) {
				;
			} else {
				out.print(",");
			}
		}
		out.println("]");
	}
	
	public static void main(String args[]) {
		Random random = new Random();
		int[] array = {random.nextInt(1000),random.nextInt(1000),random.nextInt(1000),random.nextInt(1000),random.nextInt(1000)};
		printArray(array);
		printArray(sortArray(array));
	}
}
