package Java.Chap15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializationTest {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			ObjectOutputStream out = new ObjectOutputStream(bos);

			UserInfo u1 = new UserInfo("java", "1234", 30);
			UserInfo u2 = new UserInfo("java2", "4321", 25);

			ArrayList<UserInfo> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			// serialization
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);
			out.close();
			System.out.println("직렬화 끝.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end of main
}// end of class