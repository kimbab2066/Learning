package Java.Chap7;

public class ReferenceVariableCasting {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		Car c = fe;
		FireEngine fe2 = (FireEngine) c;// casting error
		fe.water();// compile ok
	}
}

class Car {
	String color;
	int door;

	void drive() {
		System.out.println("drive");
	}

	void stop() {
		System.out.println("stop");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("water");
	}
}