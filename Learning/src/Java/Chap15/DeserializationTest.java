package Java.Chap15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializationTest {
	public static void main(String[] args) throws Exception {
		String fileName = "UserInfo.ser";
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);

		ObjectInputStream in = new ObjectInputStream(bis);

		UserInfo u1 = (UserInfo) in.readObject();
		UserInfo u2 = (UserInfo) in.readObject();

		ArrayList list = (ArrayList) in.readObject();
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(list);
		System.out.println("직렬화 끝.");
	}// main
}// end of class