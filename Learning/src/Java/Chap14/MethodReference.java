package Java.Chap14;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
	public static void main(String[] args) {
		// Function<String, Integer> f = (String s) -> Integer.parseInt(s);
		Function<String, Integer> f = Integer::parseInt;
		System.out.println(f.apply("100") + 200);
		// Supplier<MyClass> s = MyClass::new;
		// Function<Integer, MyClass> f2 = (i) -> new MyClass(i);
		Function<Integer, MyClass> f2 = MyClass::new;
		System.out.println(f2.apply(100).iv);

		Function<Integer, int[]> f3 = int[]::new;
		System.out.println(f3.apply(10).length);

	}// end of main
}

class MyClass {
	int iv;

	MyClass(int iv) {
		this.iv = iv;
	}
}
