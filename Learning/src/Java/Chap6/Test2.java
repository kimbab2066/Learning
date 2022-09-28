package Java.Chap6;

import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(arr));
		int[] result = shuffle(arr);
		System.out.println(Arrays.toString(result));
		//
		String str = "123";
		System.out.println(str + "는 숫자야? " + isNumber(str));
		str = "1234o";
		System.out.println(str + "는 숫자야? " + isNumber(str));
	}// end of main

	static boolean isNumber(String str) {
		if (str == "" || str.equals(""))
			return false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!('0' <= c && c <= '9')) {
				return false;
			}
		}
		return true;
	}// end of isNumber

	static int[] shuffle(int[] arr) {
		// 위치 바꿔서 뒤섞이게
		for (int i = 0; i < arr.length; i++) {
			int index = (int) Math.random() * 9 + 1;
			int tmp = arr[i];
			arr[i] = arr[index];
			arr[index] = tmp;
		}
		return arr;
	}
}// end of class