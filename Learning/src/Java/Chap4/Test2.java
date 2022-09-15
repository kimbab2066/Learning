package Java.Chap4;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		int sum = 0;
		int s = 1;
		int num = 0;
		for (int i = 1; sum < 100; i++, s = -s) {
			num = i * s;
			sum += num;
		}
		System.out.println(sum);
		System.out.println(num);

		// 4-5
		int i = 0;
		while (i <= 10) {
			int j = 0;
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		// 4-6
		// 두 개의 주사위 던져서 눈의 합이 6이 되는 모든 경우의 수
		int cnt = 0;
		for (int k = 1; k <= 6; k++) {
			for (int l = 1; l <= 6; l++) {
				if (k + l == 6) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		// 4-7
		String str = "12345";
		sum = 0;

		for (i = 0; i < str.length(); i++) {
			// 15를 출력해야 함
			sum += str.charAt(i) - '0';
		}
		System.out.println(sum);

		// 4-8
		int value = (int) (Math.random() * 6) + 1;
		System.out.println(value);

		// 4-9
		num = 12345;
		sum = 0;

		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		System.out.println(sum);
		// 4-10
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0;
		cnt = 0;
		Scanner in = new Scanner(System.in);
		do {
			cnt++;
			System.out.println("1~100사이");
			input = in.nextInt();

			if (input < answer) {
				System.out.println("큰 값을 입력해라");
			} else if (input > answer) {
				System.out.println("작은 값 입력해라");
			} else {
				System.out.println(cnt);
				break;
			}
		} while (true);

	}// end of main
}// end of class