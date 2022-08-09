package Java.Chap14;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMiddleOperation {
	public static void main(String[] args) {
		File[] fileArr = { new File("test.java"), new File("test2.bak"), new File("test3.java"), new File("test4.txt"),
				new File("test5") };

		Stream<File> fileStream = Stream.of(fileArr);

		Stream<String> fileNameStream = fileStream.map(File::getName);

		fileNameStream.forEach(System.out::println);

		//
		fileStream = Stream.of(fileArr);
		fileStream.map(File::getName) // Stream<File> -> Stream<String>
				.filter(s -> s.indexOf('.') != -1) // 확장자가 없는 건 제외
				.peek(s -> System.out.printf("fileName=%s%n", s))// 테스트
				.map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
				.peek(s -> System.out.printf("extension=%s%n", s))// 테스트
				.map(String::toUpperCase) // 대문자 변환
				.distinct() // 중복 제거
				.forEach(System.out::println);
		//
		Stream<String[]> strArrStream = Stream.of(new String[] { "abc", "def", "jkl" },
				new String[] { "ABC", "DEF", "GHI" });
		Stream<String> strStream = strArrStream.flatMap(Arrays::stream);
		strStream.map(String::toLowerCase)// 소문자
				.distinct().sorted().forEach(System.out::println);
		System.out.println();

		String[] lineArr = { "Believe   or not It is true", "Do it Do it Do it" };
		Stream<String> lineStream = Arrays.stream(lineArr);

		lineStream.flatMap(line -> Stream.of(line.split(" +")))// 정규식 하나 이상의 공백
				.map(String::toLowerCase).distinct()//
				.filter(s -> !s.equals("do")).sorted().forEach(System.out::println);
		System.out.println();

	}// end of main
}// end of class