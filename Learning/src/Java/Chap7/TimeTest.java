package Java.Chap7;

class Time {
	private int h;// 0~23
	private int m;
	private int s;

	public void setH(int h) {
		if (isNotValidHour(h))
			return;

		this.h = h;
	}

	// 매개변수 h 유효한지 check
	private boolean isNotValidHour(int h) {
		return h < 0 || h > 23;
	}

	public int getH() {
		return h;
	}

}

public class TimeTest {
	public static void main(String[] args) {
		Time t = new Time();
		t.setH(21);
		System.out.println(t.getH());

		t.setH(100);
		System.out.println(t.getH());
	}
}
