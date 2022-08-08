package Java.Chap14;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamCalculation {
	public static void main(String[] args) {
		String strArr[] = { "dd", "bb" };
		Stream<String> stream = Stream.of(strArr);
		stream.distinct().limit(5).sorted().forEach(System.out::println);
		//
		Stream<Student> stStream = Stream.of(new Student("김김", 3, 100), new Student("이이", 1, 200),
				new Student("박박", 2, 300), new Student("치치", 3, 200));
		stStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder()))
				.forEach(System.out::println);
		;
		System.out.println();
		//
		Stream<Student> stStream2 = Stream.of(new Student("김김", 3, 100), new Student("이이", 1, 200),
				new Student("박박", 2, 300));
		stStream2.sorted(Comparator.comparing(Student::getName).reversed()).forEach(System.out::println);
	}// end of main
}// end of class

class Student implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;

	Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	public String toString() {
		return String.format("[%s,%d,%d]", name, ban, totalScore);
	}

	String getName() {
		return name;
	}

	int getBan() {
		return this.ban;
	}

	int getTotalScore() {
		return this.totalScore;
	}

	@Override
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}

}