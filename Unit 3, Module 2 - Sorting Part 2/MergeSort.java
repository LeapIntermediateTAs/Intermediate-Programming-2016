import static java.lang.System.out;
import java.util.Random;

public class MergeSort {
	public static void sortArray(int[] array, int a, int b, int i) {
		if((b-a)==i) {
			int c;
			
			for(int j=a; j<(b-a); j++) {
				if(array[j+1]<array[j]) {
					c = array[j];
					array[j] = array[j+1];
					array[j+1] = c;
				}
			}
		} else {
			int x = a + ((b - a) / 2);
			sortArray(array, a, x, i);
			sortArray(array, x, b, i);
		}
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
    int size = random.nextInt(20);
    int[] array = new int[size];
    
    for(int i=0; i<size; i++) {
      array[i] = random.nextInt(1000);
    }
    
    printArray(array);
    
		for(int i=1; i<(array.length/2); i = i*2) {
			sortArray(array, 0, array.length-1, i);
		}
		if(((array.length/2)*2)!=array.length) {
			for(int i=1; i<array.length; i++) {
				int c = array[i];
				int j;
				for(j=i-1; j>=0 && c<array[j]; j--) {
					array[j+1] = array[j];
				}
				array[j+1] = c;
			}
		}
		printArray(array);
		
	}
}
