package Java.Chap7;

abstract class Unit {
	int x, y;

	abstract void move(int x, int y);

	void stop() {
		System.out.println("stop");

	}
}

interface Fightable {
	void move(int x, int y);// public abstract 생략

	void attack(Fightable f);// public abstract 생략
}

class Fighter extends Unit implements Fightable {
	// override 규칙 : 조상(public)보다 접근제어자가 범위가 좁으면 안된다.
	public void move(int x, int y) {
		System.out.println(x + ", " + y + "로 이동");
	};

	public void attack(Fightable f) {
		System.out.println(f + "를 공격");
	};

	Fightable getFightable() {
		Fighter f = new Fighter();
		return f;
	}
}

public class InterfaceAndPolymorphism {
	public static void main(String[] args) {

		Fighter f = new Fighter();
//		Unit f = new Fighter(); attack()이 없음
//		Fightable f = new Fighter();
		f.move(100, 200);
		f.attack(new Fighter());
		Fightable f2 = f.getFightable();
	}
}
