package Java;

class Point2 extends Object {
	int x;
	int y;

	Point2() {

	}

	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// overridding
	public String toString() {
		return "x : " + x + " y : " + y;
	}
}

public class OverRidding {
	public static void main(String[] args) {
		Point2 p = new Point2(6, 10);
		System.out.println(p);
		System.out.println(p.toString());

	}
}
