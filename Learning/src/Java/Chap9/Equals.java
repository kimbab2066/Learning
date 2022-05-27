package Java.Chap9;

public class Equals {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		if(v1.equals(v2)) {
			System.out.println("같");
		}else {
			System.out.println("다름");
		}
	}
}

class Value {
	int value;

	Value(int value) {
		this.value = value;

	}

	public boolean equals(Object obj) {
		Value v2 = (Value) obj;
		
		return this.value == v2.value;
	}
}
