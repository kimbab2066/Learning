package Java.Chap14;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalTest {
	public static void main(String[] args) {
		int[] arr = new int[0];// null일 때 NullPointerException발생
		System.out.println(arr.length);
		// Optional 초기화
		Optional<String> optVal = Optional.empty();
		// System.out.println(optVal.orElseThrow(NullPointerException::new));
//		System.out.println(optVal.orElseGet(() -> "EMPTY"));
		System.out.println(optVal.orElseGet(String::new));
		//
		Optional<String> optStr = Optional.of("abcdefg");
		Optional<Integer> optInt = optStr.map(String::length);

		System.out.println(optStr.get());
		System.out.println(optInt.get());

		int result = Optional.of("123").filter(x -> x.length() > 0)//
				.map(Integer::valueOf).get();

		int result2 = Optional.of("").filter(x -> x.length() > 0)//
				.map(Integer::valueOf).orElse(-1);

		System.out.println(result);
		System.out.println(result2);

		Optional.of("456").map(Integer::valueOf)//
				.ifPresent(System.out::println);

		OptionalInt optInt1 = OptionalInt.of(0);
		OptionalInt optInt2 = OptionalInt.empty();

		System.out.println(optInt1.isPresent());// 0
		System.out.println(optInt2.isPresent());// empty
		System.out.println(optInt1.equals(optInt2));

		System.out.println(optInt1.getAsInt());// 0
		// System.out.println(optInt2.getAsInt());// NullPointer

		System.out.println(optInt1);
		System.out.println(optInt2);

	}// end of main
}// end of class