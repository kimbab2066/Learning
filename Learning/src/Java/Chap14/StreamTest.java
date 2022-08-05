package Java.Chap14;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> intStream = list.stream();
		// intStream.forEach(System.out::print);

		Stream<String> strStream = Stream.of(new String[] { "a", "b", "c" });
		strStream.forEach(System.out::println);
		Stream<String> strStream2 = Arrays.stream(new String[] { "a", "b", "c" });
		strStream2.forEach(System.out::println);

		IntStream intStream2 = new Random().ints();
		// intStream2.limit(5).forEach(System.out::println);//무한스트림(limit이 없으면 계속 나옴)
		IntStream intStream3 = new Random().ints(10, 5, 10);
		// intStream3.forEach(System.out::println);

		//iterate(T seed, UnaryOperator f) 단항 연산자
		Stream<Integer> iter = Stream.iterate(1, n -> n + 3);
		iter.limit(5).forEach(System.out::println);
		//generate(Supplier s): parameter X, return O
		Stream<Integer> gener = Stream.generate(() -> 1);
		gener.limit(5).forEach(System.out::println);
	}
}
