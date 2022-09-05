package Java.Chap2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test1 {
	public static void main(String[] args) throws IOException {
		float f = 3.14f;
		System s;
		char ch = 'a';
		ch = ' ';
		double d = f;

		// serialization
		FileOutputStream fos = new FileOutputStream("objectfile.ser");
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(new Object());

	}// end of main
}// end of class