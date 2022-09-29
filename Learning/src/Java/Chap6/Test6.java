package Java.Chap6;

import java.util.Arrays;

public class Test6 {
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "은 숫자야?" + isNumber(str));
		str = "123o";
		System.out.println(str + "은 숫자야?" + isNumber(str));
		//
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(arr));
		int[] result = shuffle(arr);
		System.out.println(Arrays.toString(result));
	}

	static int[] shuffle(int[] arr) {
		int idx = (int) Math.random() * 9 + 1;
		for (int i = 0; i < arr.length; i++) {
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		return arr;
	}

	static boolean isNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!(c >= 48 && c <= 57)) {
				return false;
			}
		}
		return true;
	}// end of isNumber
}// end of class