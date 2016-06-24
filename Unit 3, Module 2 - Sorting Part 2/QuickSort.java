import static java.lang.System.out;
import java.util.Random;

public class QuickSort {
	public static void sortArray(int[] array, int a, int b){
	    if(b<=a || a>=b) {
	    	return;
	    } else { 
	        int x = array[a]; 
	        int i = a+1;
	        int c;
	        
	        for(int j=a+1; j<=b; j++){
	            if(x>array[j]){
	                c = array[j]; 
	                array[j] = array[i]; 
	                array[i] = c; 
	                i++; 
	            }
	        }

	        array[a] = array[i-1]; 
	        array[i-1] = x; 
	        
	        sortArray(array, a, i-2); 
	        sortArray(array, i, b); 
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
		sortArray(array, 0, array.length-1);
		printArray(array);
	}
}
