package Java.Chap7;

class A {
	public void method(I i) {// 인터페이스 I 구현한 클래스만
		i.method();
	}
}

interface I {
	public void method();
}

class B implements I {
	public void method() {
		System.out.println("B메서드");
	}
}

class C implements I {
	public void method() {
		System.out.println("C메서드");
	}
}

public class InterfaceAdvantage {
	public static void main(String[] args) {
		A a = new A();
		a.method(new C());// A가 B를 사용(의존)
	}
}
