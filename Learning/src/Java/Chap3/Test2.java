package Java.Chap3;

import java.io.*;
import java.util.*;

public class Test2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str[] = br.readLine().split(" ");
//		int A = Integer.valueOf(str[0]);
//		int B = Integer.valueOf(str[1]);
//		int T = Integer.valueOf(br.readLine());
//		A += T / 60;
//		B += T % 60;
//		if (B > 59) {
//			B -= 60;
//			A++;
//		}
//		if (A > 23) {
//			A -= 24;
//		}
//		System.out.println(A + " " + B);
//
//		str = br.readLine().split(" ");
//		int H = Integer.valueOf(str[0]);
//		int M = Integer.valueOf(str[1]);
//		if (M < 45) {
//			M += 15;
//			H--;
//			if (H < 0)
//				H = 23;
//
//			System.out.println(H + " " + M);
//		} else {
//			System.out.println(H + " " + (M - 45));
//		}
//		int N = Integer.valueOf(br.readLine());
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N - i; j++) {
//				System.out.print(" ");
//			}
//			for (int k = 1; k <= i; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		String str[] = br.readLine().split(" ");
//		int N = Integer.valueOf(str[0]);
//		int X = Integer.valueOf(str[1]);
//		int arr[] = new int[N];
//		str = br.readLine().split(" ");
//		for (int i = 0; i < N; i++) {
//			int val = Integer.valueOf(str[i]);
//
//			if (val < X) {
//				System.out.print(val + " ");
//			}
//		}
		int N = Integer.valueOf(br.readLine());
		int copyN = N;
		int cnt = 0;
		do {
			N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
			cnt++;
		} while (copyN != N);
		if (N == 0)
			cnt = 1;
		System.out.println(cnt);
	}// end of main
}// end of class