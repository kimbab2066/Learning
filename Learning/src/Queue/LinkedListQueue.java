package Queue;

import java.util.NoSuchElementException;

import Interface_form.Queue;

public class LinkedListQueue<E> implements Queue<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size = 0;

	public LinkedListQueue() {
		this.head = null;
		this.tail = null;
	}

	// offer 메소드 구현
	@Override
	public boolean offer(E value) {
		Node<E> newNode = new Node<E>(value);
		// 비어있을 경우
		if (size == 0) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		// tail이 가리키고 있는 Node를 변경
		tail = newNode;
		size++;

		return true;
	}

	// poll 메소드 구현
	@Override
	public E poll() {
		if (size == 0) {
			return null;
		}
		// temp variable
		E element = head.data;

		Node<E> nextNode = head.next;

		// head data,reference X
		head.data = null;
		head.next = null;

		// head modify
		head = nextNode;
		size--;

		return element;
	}

	// remove 메소드
	public E remove() {
		E element = poll();
		if (element == null) {
			throw new NoSuchElementException();
		}
		return element;
	}

	// peek 메소드 구현
	@Override
	public E peek() {
		if (size == 0) {
			return null;
		}
		return head.data;
	}

	// element 메소드
	public E element() {
		E element = peek();
		if (element == null) {
			throw new NoSuchElementException();
		}
		return element;
	}

	// size, isEmpty, contains, clear
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object value) {
		for (Node<E> x = head; x != null; x = x.next) {
			if (value.equals(x.data)) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		for (Node<E> x = head; x != null; x = x.next) {
			x.data = null;
			x.next = null;
		}
		size = 0;
		head = tail = null;
	}

	public void show() {
		for (Node<E> x = head; x != null; x = x.next) {
			System.out.print(x.data + " ");
		}
	}
}// end of class