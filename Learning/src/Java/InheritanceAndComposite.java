package Java;

class Point {
	int x;
	int y;
}

class Circle extends Point {
	int r;
}

class Circle2 {
	Point p = new Point();
	int r;

	Circle2() {
		p = new Point();
	}
}

public class InheritanceAndComposite {
	public static void main(String[] args) {
		// 상속관계 증명
		Circle c = new Circle();
		c.x = 1;
		System.out.println(c.x);
		// 포함관계 증명
		Circle2 c2 = new Circle2();
		c2.p.x = 2;
		System.out.println(c2.p.x);
	}
}
