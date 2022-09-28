package Java.Chap6;

public class Test1 {
	public static void main(String[] args) {
		Student s = new Student("홍길동", 1, 1, 100, 60, 76);
		String str = s.info();
		System.out.println(str);
		System.out.println("이름: " + s.name);
		System.out.println("총점: " + s.getTotal());
		System.out.println("평균: " + s.getAverage());
		System.out.println(getDistance(1, 1, 2, 2));
		//
		MyPoint p = new MyPoint(1, 1);
		System.out.println(p.getDistance(2, 2));
	}// end of main

	public static double getDistance(int x, int y, int x1, int y1) {
		double result = Math.pow((double) x1 - x, 2) + Math.pow((double) y1 - y, 2);
		return Math.sqrt(result);
		// return Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));과 같음
	}
}// end of class

class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;

	}

	double getDistance(int x1, int y1) {
		return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
	}
}

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Student() {
	}

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String info() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + (kor + eng + math) + ","
				+ ((int) ((kor + eng + math) / 3f * 10 + 0.5f) / 10f);
	}

	public int getTotal() {
		return kor + eng + math;
	}

	public float getAverage() {
		return ((int) (getTotal() / 3f * 10 + 0.5f) / 10f);
	}

}// end of class