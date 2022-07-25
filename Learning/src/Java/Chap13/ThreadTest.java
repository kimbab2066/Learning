package Java.Chap13;

public class ThreadTest {
	public static void main(String[] args) {
		ThreadTest1 t1 = new ThreadTest1();
		Thread t2 = new Thread(new ThreadTest2());

		t1.start();
		t2.start();
		//결론:작업의 양이 많을수록 확실하게 확인 가능
	}// end of main
}// end of class

class ThreadTest1 extends Thread {
	public void run() {// 쓰레드가 수행할 작업
		for (int i = 0; i < 500; i++) {
			System.out.println(getName());
		}
	}
}

class ThreadTest2 implements Runnable {
	@Override
	public void run() {// 쓰레드가 수행할 작업
		for (int i = 0; i < 500; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환.
			System.out.println(Thread.currentThread().getName());
		}
	}
}
