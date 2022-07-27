package Queue;

public class Test {
	public static void main(String[] args) {
		ArrayQueue<Integer> aque = new ArrayQueue<>();

		aque.offer(1);
		aque.offer(4);
		aque.offer(5);
		aque.offer(2);
		aque.offer(7);
		aque.offer(1);
		aque.show();
	}
}
