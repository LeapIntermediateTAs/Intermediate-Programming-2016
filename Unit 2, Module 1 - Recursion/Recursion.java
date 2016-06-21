import java.util.Scanner;

public class Recursion {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter the nth fibbonacci number you want: ");
		long input = s.nextInt();
		System.out.println(fibonacci(input));
		s.close();

	}

	public static long fibonacci(long a, long b, long count) {
		if(count==1) {
			return b;
		} else {
			return fibonacci(b, a+b, count-1);
		}
	}
	
	public static long fibonacci(long count) {
		return fibonacci(0, 1, count);
	}
}
