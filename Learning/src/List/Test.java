package List;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list.add(10));
		System.out.println(list.add(20));
		System.out.println(list.add(50));
		System.out.println(list.add(5));
		System.out.println(list.add(50));
		System.out.println(list.size());
		System.out.println(list.contains(20));
		System.out.println(list.contains(30));
		list.show();

	}// end of main
}// end of class
