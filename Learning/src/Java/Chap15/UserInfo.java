package Java.Chap15;

import java.io.Serializable;

public class UserInfo implements Serializable {
	String name;
	String password;
	int age;
	// transient Object obj = new Object();// 직렬화X

	public UserInfo() {
		this("Unknown", "1111", 0);
	}

	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}

	public String toString() {
		return "(" + name + "," + password + "," + age + ")";
	}
}// end of class