package Java;

class Data_1 {
	int val;
}

class Data_2 {
	int val;

	Data_2() {

	}

	Data_2(int x) {
		val = x;
	}
}

public class DefaultConstructor {
	public static void main(String[] args) {
		Data_1 d1 = new Data_1();
		Data_2 d2 = new Data_2(10);
		Data_2 d3 = new Data_2();
		System.out.println(d1.val);
		System.out.println(d2.val);
	}
}
