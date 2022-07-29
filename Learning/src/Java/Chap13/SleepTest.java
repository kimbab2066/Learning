package Java.Chap13;

public class SleepTest {
	public static void main(String[] args) {
		Th1 t1 = new Th1();
		Th2 t2 = new Th2();
		t1.start();
		t2.start();

		delay(2000);
		System.out.println("메인종료");
	}// end of main

	static void delay(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {}
	}// end of delay
}// end of class

class Th1 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.print("Th1종료");
	}
}

class Th2 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.print("Th2종료");
	}
}
