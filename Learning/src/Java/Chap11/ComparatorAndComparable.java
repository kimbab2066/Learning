package Java.Chap11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorAndComparable {
	public static void main(String[] args) {
		String[] str = { "cat", "Dog", "lion", "tiger" };
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
		Arrays.sort(str, String.CASE_INSENSITIVE_ORDER);//F3 선언부 이동
		System.out.println(Arrays.toString(str));
		Arrays.sort(str, new Descending());
		System.out.println(Arrays.toString(str));
	}// end of main
}// end of class

class Descending implements Comparator {

	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2) * -1;
		}
		return -1;
	}
}