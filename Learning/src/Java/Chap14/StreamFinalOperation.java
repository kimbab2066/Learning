package Java.Chap14;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFinalOperation {
	public static void main(String[] args) {
		String[] strArr = { "In", "Ja", "La", "s", "Optio", "IntSt1", "count", "sum" };

		Stream.of(strArr)// 병렬인 경우
				.parallel().forEachOrdered(System.out::println);

		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);// 길이가 0인것 없으면 true
		Optional<String> sWord = Stream.of(strArr).parallel()// 병렬
				.filter(s -> s.charAt(0) == 's').findAny();// 아무거나 = sum or st 아무거나 나옴
		System.out.println();
		System.out.println(noEmptyStr);
		System.out.println(sWord.get());

		// IntStream 기본형 스트림 = Stream<INteger>보다 성능 좋음
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

		int count = intStream1.reduce(0, (a, b) -> a + 1);
		int sum = intStream2.reduce(0, (a, b) -> a + b);

		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);

		System.out.println(count);
		System.out.println(sum);
		System.out.println(max.orElseGet(() -> 0));
		System.out.println(min.getAsInt());

	}// end of main
}// end of class