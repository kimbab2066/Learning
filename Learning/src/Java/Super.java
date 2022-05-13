package Java;

class Point3 {
	int x;
	int y;

	Point3(int x, int y) {
		this.x = x;
		this.y = y;

	}

	String getLocation() {
		return "x = " + x + "y = " + y;
	}
}

class Point3D3 extends Point3 {
	int z;

	Point3D3(int x, int y, int z) {
		super(x, y);// Point3()를 의미
		this.z = z;
	}

	String getLocation() {
		return "x = " + x + "y = " + y + "z = " + z;
	}
}

public class Super {
	public static void main(String[] args) {
		Point3D3 p = new Point3D3(1, 2, 3);
	}
}
