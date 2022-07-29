package Java.Chap13;

public class SusResumeStopTest {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("*");
		MyThread t2 = new MyThread("**");
		MyThread t3 = new MyThread("***");
		t1.start();
		t2.start();
		t3.start();

		try {
			Thread.sleep(2000);
			t1.suspend();
			Thread.sleep(2000);
			t2.suspend();
			Thread.sleep(3000);
			t1.resume();
			Thread.sleep(3000);
			t1.stop();
			t2.stop();
			Thread.sleep(2000);
			t3.stop();
		} catch (InterruptedException e) {
		}
		;
	}
}

class MyThread implements Runnable {
	volatile boolean suspended = false;// 쉽게 바뀌는 변수
	volatile boolean stopped = false;// RAM에 원본을 가져다 쓰라는 의미

	Thread th;

	MyThread(String name) {
		th = new Thread(this, name);// Runnable r,String name
	}

	void start() {
		th.start();
	}

	void stop() {
		this.stopped = true;
	}

	void suspend() {
		this.suspended = true;
	}

	void resume() {
		this.suspended = false;
	}

	@Override
	public void run() {
		while (!stopped) {
			if (!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}
	}

}
