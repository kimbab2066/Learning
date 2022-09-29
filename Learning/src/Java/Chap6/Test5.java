package Java.Chap6;

public class Test5 {
	public static void main(String[] args) {
		int val = 5;
		System.out.println(val + "의 절대값: " + abs(val));
		val = -10;
		System.out.println(val + "의 절대값: " + abs(val));
	}

	static int abs(int val) {
		return val > 0 ? val : -val;
	}// end of abs
}// end of class
