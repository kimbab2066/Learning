package Queue;

import java.util.NoSuchElementException;

import Interface_form.Queue;

public class LinkedListDeque<E> implements Queue<E> {
	// 클래스 및 생성자 구성하기
	private Node<E> head;// 가장 앞에 있는 노드를 가리키는 변수
	private Node<E> tail;// 가장 뒤에 있는 노드를 가리키는 변수
	private int size;// 요소(노드)의 개수

	public LinkedListDeque() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// offer계열 메소드 구현
	// 마지막에 추가 = offer(E item), offerLast(E item)
	// 가장 앞에 추가 = offerFirst(E item)
	public boolean offerFirst(E item) {
		// make new node
		Node<E> newNode = new Node<E>(item);
		// linking
		newNode.next = head;
		if (head != null) {// head가 null인 경우는 아무 것도 없는 상태이므로 잘못된 참조가 된다.
			head.prev = newNode;
		}
		// update head
		head = newNode;
		size++;
		// 이전 head가 null인 경우(처음 넣는 경우)
		if (head.next == null) {
			tail = head;
		}
		return true;
	}

	@Override
	public boolean offer(E item) {
		return offerLast(item);
	}

	public boolean offerLast(E item) {
		// 요소가 없는 경우 offerFirst() 호출
		if (size == 0) {
			return offerFirst(item);
		}
		// make newNode
		Node<E> newNode = new Node<E>(item);
		// linking
		tail.next = newNode;
		newNode.prev = tail;
		// update tail
		tail = newNode;
		size++;

		return true;
	}

	// poll계열 메소드 구현
	// 전방삭제 - poll(), pollFirst(), remove(), removeFirst()
	// 후방삭제 - pollLast()
	@Override
	public E poll() {
		return pollFirst();
	}

	public E pollFirst() {
		if (size == 0) {
			return null;
		}
		E element = head.data;// 반환하기 위한 임시 변수
		// search headNode
		Node<E> nextNode = head.next;
		// unlinking
		head.data = null;
		head.next = null;
		// 삭제하기전 데이터가 두 개 이상 있을 경우(head != tail)
		if (nextNode != null) {
			nextNode.prev = null;
		}
		// update head
		head = null;
		head = nextNode;
		size--;
		// 덱의 유일한 요소였을 경우
		if (size == 0) {
			tail = null;
		}
		return element;
	}

	public E remove() {
		return removeFirst();
	}

	public E removeFirst() {
		E element = poll();
		if (element == null) {
			throw new NoSuchElementException();
		}
		return element;
	}

	// offer와 조합하여 사용 시 스택처럼 사용 가능
	public E pollLast() {
		if (size == 0) {
			return null;
		}
		E element = tail.data;// 반환용 임시 데이터
		// search tail node
		Node<E> prevNode = tail.prev;
		// unlinking
		tail.data = null;
		tail.prev = null;
		// 요소가 두 개 이상인 경우(tail!= head)
		if (prevNode != null) {
			prevNode.next = null;
		}
		// updatetail
		tail = null;
		tail = prevNode;
		size--;
		if (size == 0) {
			head = null;
		}
		return element;
	}

	public E removeLast() {
		E element = pollLast();
		if (element == null) {
			throw new NoSuchElementException();
		}
		return element;
	}

	// peek계열 메소드 구현
	// poll 메소드에서 삭제 과정만 없는 것이 peek()
	@Override
	public E peek() {
		return peekFirst();
	}

	public E peekFirst() {
		if (size == 0) {
			return null;
		}
		return head.data;
	}

	public E peekLast() {
		if (size == 0) {
			return null;
		}
		return tail.data;
	}

	public E element() {
		return getFirst();
	}

	public E getFirst() {
		E element = peek();
		if (element == null) {
			throw new NoSuchElementException();
		}
		return element;
	}

	public E getLast() {
		E element = peekLast();
		if (element == null) {
			throw new NoSuchElementException();
		}
		return element;
	}

	// size, isEmpty, contains, clear 메소드 구현
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(E value) {
		// search
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
			x.prev = null;
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