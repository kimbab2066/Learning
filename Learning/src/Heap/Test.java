package Heap;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			heap.add(rnd.nextInt(100));
		}
		// 인덱스 0 = null이 맞음
		System.out.print("내부 : ");
		for (Object val : heap.toArray()) {
			System.out.print(val + " ");
		}
		System.out.println();
		//
		while (!heap.isEmpty()) {
			System.out.print(heap.remove() + " ");
		}
	}
}
