import static java.lang.System.out;

import java.util.ArrayList;
import java.lang.Math;

public class HeapConvert { // Not complete
	public static void convertArray(ArrayList<String> array) {
		int x = 1;
		int y = 1;
		int c = Integer.parseInt(array.get(0));
		array.add(1, "|");
		for(int i=2; i<array.size(); i++) {
			if(i==(array.size()-1)) {
				break;
			}
			if(Integer.parseInt(array.get(i))>c) {
				array.add(i+1, "|");
				c = Integer.parseInt(array.get(i));
				i++;
				x = 1;
			} else if(x==Math.pow(2, y)) {
				array.add(i+1, "|");
				c = Integer.parseInt(array.get(i));
				i++;
				x = 1;
				y++;
			} else {
				x++;
			}
		}
	}
	
	public static ArrayList<String> sortHeap(ArrayList<String> subArray) {
		@SuppressWarnings("unused")
		int c;
		if(Integer.parseInt(subArray.get(1))>Integer.parseInt(subArray.get(0))) {
			c = Integer.parseInt(subArray.get(1));
		} else {
			c = Integer.parseInt(subArray.get(0));
		}
		for(int i=0; i<subArray.size(); i++) {
			
		}
		return subArray;
	}
	
	public static void printHeap(ArrayList<String> array) {
		for(int i=0; i<array.size(); i++) {
			if(array.get(i).equals("|")) {
				out.println();
			} else {
				out.print(array.get(i) + " ");
			}
		}
		out.println();
	}
	
	public static void main(String args[]) {
		ArrayList<String> array = new ArrayList<String>();
		array.add("50");
		array.add("15");
		array.add("30");
		array.add("7");
		array.add("3");
		array.add("20");
		out.println(array.toString());
		out.println();
		convertArray(array);
		printHeap(array);
		for(int i=0; i<(array.size()-1); i++) {
			ArrayList<String> subArray = new ArrayList<String>();
			for(int j=i; j<((array.size()-1)-j); j++) {
				subArray.add(array.get(j));
			}
			printHeap(sortHeap(subArray));
		}
	}
}