package List;

public class Test {
	public static void main(String[] args) {

		// ArrayList Test
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
		System.out.println();
		// SinglyLinkedList Test
		SinglyLinkedList<Integer> link = new SinglyLinkedList<>();
		System.out.println(link.add(10));
		System.out.println(link.add(20));
		System.out.println(link.add(40));
		System.out.println(link.add(60));
		System.out.println(link.add(20));
		System.out.println(link.contains(20));
		link.addFirst(70);
		System.out.println(link.isEmpty());
		link.show();

		System.out.println("Doubly");
		System.out.println("========================");
		
		// DoublyLinkedList Test
		DoublyLinkedList<Integer> dLink = new DoublyLinkedList<>();
		System.out.println(dLink.add(10));
		System.out.println(dLink.add(60));
		System.out.println(dLink.add(20));
		System.out.println(dLink.add(40));
		System.out.println(dLink.add(80));
		System.out.println(dLink.add(50));
		System.out.println(dLink.contains(20));
		System.out.println(link.isEmpty());
		dLink.show();

	}// end of main
}// end of class
