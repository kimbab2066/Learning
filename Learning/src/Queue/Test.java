package Queue;

public class Test {
	public static void main(String[] args) {
		ArrayQueue<Integer> aque = new ArrayQueue<>();

//		aque.offer(1);
//		aque.offer(4);
//		aque.offer(5);
//		aque.offer(2);
//		aque.offer(7);
//		aque.offer(1);
//		aque.show();
		LinkedListQueue<Integer> lique = new LinkedListQueue<>();
//		lique.offer(2);
//		lique.offer(4);
//		lique.offer(5);
//		lique.offer(6);
//		lique.offer(7);
//		lique.offer(8);
//		lique.offer(9);
//		lique.offer(1);
//		lique.show();
//		lique.poll();
//		lique.poll();
//		System.out.println();
//		lique.show();
		ArrayDeque<Integer> aDeque = new ArrayDeque<>();
		aDeque.offer(1);
		aDeque.offer(5);
		aDeque.offer(4);
		aDeque.offer(3);
		aDeque.offer(2);
		aDeque.offerLast(10);
		aDeque.show();
		aDeque.poll();
		aDeque.pollLast();
		System.out.println();
		aDeque.show();
	}
}
