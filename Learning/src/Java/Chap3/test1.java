package Java.Chap3;

public class test1 {
	public static void main(String[] args) {
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000l;
		b = (byte) i;
		float f = l;
		i = ch;
		System.out.println();

		//
		int f1 = 100;
		float c1 = (int) ((5 / 9f * (f1 - 32)) * 100 + 1) / 100f;
		System.out.println(c1);

	}
}
