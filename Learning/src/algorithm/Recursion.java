package algorithm;

public class Recursion {
	public static void main(String[] args) {
		int result = func(4);
		System.out.println(result);
		result = factorial(4);
		System.out.println(result);
		result = fibonacci(13);
		System.out.println(result);
		result = euclid(150, 78);
		System.out.println(result);
	}// end of main

	// recursion
	public static int func(int n) {
		if (n <= 0) return 0;
		else return n + func(n - 1);
	}
	// factorial
	public static int factorial(int n) {
		if (n < 2) return n;
		else return n * factorial(n - 1);
	}
	// fibonacci
	public static int fibonacci(int n) {
		if (n < 2) return n;
		else return fibonacci(n - 1) + fibonacci(n - 2);
	}
	// euclid method
	public static int euclid(int m, int n) {
		if (m < n) {
			int temp = m;m = n;n = temp;
		}
		if (m % n == 0) return n;
		else return euclid(n, m % n);
	}
}// end of class
