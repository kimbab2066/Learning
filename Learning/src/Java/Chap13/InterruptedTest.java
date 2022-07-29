package Java.Chap13;

import java.io.IOException;
import javax.swing.JOptionPane;

public class InterruptedTest {
	public static void main(String[] args) throws IOException {
		IT1 t1 = new IT1();
		t1.start();

		System.out.println("interupted상태: " + t1.isInterrupted());// false

		String input = JOptionPane.showInputDialog("아무값입력:");
		System.out.println("입력값: " + input);
		t1.interrupt();
//		System.out.println("interupted상태: " + t1.isInterrupted());// true
//		System.out.println("interupted상태: " + t1.isInterrupted());// true
//		// main thread interrput 상태 확인
//		System.out.println("interupted상태: " + Thread.interrupted());// true
	}
}// end of class

class IT1 extends Thread {
	public void run() {
		int i = 10;
		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for (long x = 0; x < 2500000000000L; x++) {
			} // 시간 지연
		}
		System.out.println("interupted상태: " + this.isInterrupted());// true
		System.out.println(Thread.interrupted());
		System.out.println(Thread.interrupted());
		System.out.println(Thread.interrupted());
	}// end of run
}
