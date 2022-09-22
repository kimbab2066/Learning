package Java.Chap5;

import java.io.*;
import java.util.*;

public class Test2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
		 */
//		int N = Integer.valueOf(br.readLine());
//		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
//		System.out.println(Arrays.stream(arr).min().getAsInt() + " " + Arrays.stream(arr).max().getAsInt());
		/*
		 * 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
		 */
//		int[] arr = new int[9];
//		for (int i = 0; i < 9; i++) {
//			arr[i] = Integer.valueOf(br.readLine());
//		}
//		int idx = 0;
//		int max = 0;
//
//		for (int i = 0; i < arr.length; i++) {
//			if (max < arr[i]) {
//				max = arr[i];
//				idx = i + 1;
//			}
//		}
//		System.out.println(max);
//		System.out.println(idx);
		// 3052 MODULO
//		HashSet<Integer> set = new HashSet<>();
//		for (int i = 0; i < 10; i++) {
//			set.add(Integer.valueOf(br.readLine()) % 42);
//		}
//		System.out.println(set.size());
		// 3052 MODULO2
//		int arr[] = new int[42];
//		int cnt = 0;
//		for (int i = 0; i < 10; i++) {
//			int num = Integer.valueOf(br.readLine()) % 42;
//			if (arr[num] != 1) {
//				cnt++;
//				arr[num] = 1;// true의 의미인듯
//			}
//		}
//		System.out.println(cnt);

		/*
		 * 자기 점수 중에 최댓값을 M이라고 한다. 모든 점수를 점수/M*100으로 고친다.
		 */
//		int N = Integer.valueOf(br.readLine());
//		int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
//
//		float max = Arrays.stream(arr).max().getAsInt();
//		float sum = 0;
//		for (int val : arr) {
//			sum += (val / max) * 100;
//		}
//		System.out.println(sum / N);

		// 8958 OX퀴즈
//		int T = Integer.valueOf(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		while (T-- > 0) {
//			int cnt = 0;
//			int result = 0;
//			String str = br.readLine();
//			for (int i = 0; i < str.length(); i++) {
//				char c = str.charAt(i);
//				if (c == 'O') {
//					cnt++;
//					result += cnt;
//				} else {
//					cnt = 0;
//				}
//			}
//			sb.append(result + "\n");
//		}
//		System.out.println(sb);
		// 4344 평균은 넘겠지
		int C = Integer.valueOf(br.readLine());
		int arr[];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.valueOf(st.nextToken());
			arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.valueOf(st.nextToken());
			}
			float average = Arrays.stream(arr).sum() / N;
			float cnt = 0;
			for (int val : arr) {
				if (val > average) {
					cnt++;
				}
			}
			sb.append(String.format("%.3f%%", (cnt / N * 100))).append("\n");
		}
		System.out.println(sb);
	}// end of main
}// end of class