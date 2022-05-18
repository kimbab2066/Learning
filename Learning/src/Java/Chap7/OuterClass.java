package Java.Chap7;

class Outer {
	private int outerIv = 0;
	static int outerCv = 0;

	class InstanceInner {
		int iiv = outerIv;
		int iiv2 = outerCv;

	}

	static class StaticInner {
		static int scv = outerCv;
	}

	void method() {
		int lv = 0;
		final int LV = 0;// JDK 1.8부터 final 생략 가능
		class LocalInner {
			int liv = outerIv;
			int liv2 = outerCv;
			int liv3 = lv;
			int liv4 = LV;
		}
	}
}

public class OuterClass {
	public static void main(String[] args) {

	}
}
