package Java.Chap4;

public class Test1 {
	public static void main(String[] args) {

		int sum = 0, totalSum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
			totalSum += sum;
		}
		System.out.println(totalSum);

		int sum2 = 0;
		int s = 1;
		int num = 0;
		for (int i = 1; sum2 < 100; i++, s = -s) {
			num = i * s;
			sum2 += num;
		}
		System.out.println(num);
	}// end of main
}// end of class