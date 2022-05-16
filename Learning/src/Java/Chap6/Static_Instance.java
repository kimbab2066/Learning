package Java.Chap6;

public class Static_Instance {
	static {
		System.out.println("static부분~");
	}

	{
		System.out.println("instance부분~");
	}

	Static_Instance() {
		System.out.println("생성자~");
	}

	public static void main(String[] args) {
		System.out.println("main method");
		Static_Instance c = new Static_Instance();
		System.out.println("main 2");
		Static_Instance c2 = new Static_Instance();
		
	}// end of main
}// end of class
