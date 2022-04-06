package Java;

public class Chapter6 {
	static {
		System.out.println("static부분~");
	}

	{
		System.out.println("instance부분~");
	}

	Chapter6() {
		System.out.println("생성자~");
	}

	public static void main(String[] args) {
		System.out.println("main method");
		Chapter6 c = new Chapter6();
		System.out.println("main 2");
		Chapter6 c2 = new Chapter6();
		
	}// end of main
}// end of class
