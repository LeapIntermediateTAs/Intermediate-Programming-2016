import static java.lang.System.out;
import java.util.Random;

public class InsertionSort {
	public static int[] sortArray(int[] array) {
		for(int i=1; i<array.length; i++) {
			int c = array[i];
			int j;
			for(j=i-1; j>=0 && c<array[j]; j--) {
				array[j+1] = array[j];
			}
			array[j+1] = c;
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
