package Java.Chap14;

public class Lambda {
	public static void main(String[] args) {
		// 람다식을 다루기위한 참조변수 타입은 함수형 인터페이스로 한다.
		MyFunction2 f = (a, b) -> a > b ? a : b;// 매개변수와 리턴타입이 같아야 한다.
		System.out.println(f.max(3, 5));
	}// end of main
}

@FunctionalInterface
interface MyFunction2 {
	int max(int a, int b);// 람다식을 사용하기 위해 메소드 이름을 붙여준다.
}