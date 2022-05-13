package Java;

public class Chap6_Static_Instance {
	static {
		System.out.println("static부분~");
	}

	{
		System.out.println("instance부분~");
	}

	Chap6_Static_Instance() {
		System.out.println("생성자~");
	}

	public static void main(String[] args) {
		System.out.println("main method");
		Chap6_Static_Instance c = new Chap6_Static_Instance();
		System.out.println("main 2");
		Chap6_Static_Instance c2 = new Chap6_Static_Instance();
		
	}// end of main
}// end of class
