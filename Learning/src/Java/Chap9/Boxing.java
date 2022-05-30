package Java.Chap9;

import java.util.ArrayList;

public class Boxing {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		// list.add(new Integer(10));
		list.add(10);// JDK 1.5 이전에는 에러였음.

		// Integer i = list.get(0);
		// int i = list.get(0).intValue();// intValue() : Integer->int
		int i = list.get(0);

	}
}
