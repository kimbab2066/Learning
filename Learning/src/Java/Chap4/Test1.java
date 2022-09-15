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

		// 4-2
		int sum_4_2 = 0;
		for (int i = 1; i <= 20; i++) {
			if (!(i % 2 == 0 || i % 3 == 0)) {
				sum_4_2 += i;
			}
		}
		System.out.println("4-2 = " + sum_4_2);
		// 4-3
		int result_4_3 = 0;
		int total = 0;
		for (int i = 1; i <= 10; i++) {
			total += i;
			result_4_3 += total;
		}
		System.out.println(result_4_3);
		// 4-4
		sum = 0;
		s = 1;
		num = 0;
		for (int i = 1; true; i++, s = -s) {
			num = i * s;
			sum += num;
			if (sum >= 100) {
				break;
			}
		}
		System.out.println();
		System.out.println("이거 " + num);
	}// end of main
}// end of class