package List;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements List<E> {

	// field
	private Node<E> head;
	private Node<E> tail;
	private int size; // element

	// constructor
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// 특정 위치의 노드를 반환하는 메서드
	private Node<E> search(int index) {
		// 예외처리
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		// 뒤에서부터 검색
		if (index > size / 2) {
			Node<E> x = tail;
			for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
		// 앞에서부터 검색
		else {
			Node<E> x = head;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		}
	}

	public void addFirst(E value) {
		Node<E> newNode = new Node<E>(value);
		newNode.next = head;// 새로 만든 노드의 다음 주소값을 head로 연결

		// 처음 넣을 경우 null
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		size++;

		// 가리킬 노드가 없는 경우 = (데이터가 새 노드 밖에 없는 경우)
		if (head.next == null) {
			tail = head;
		}
	}

	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}

	public void addLast(E value) {
		Node<E> newNode = new Node<E>(value);

		// 처음 넣는 경우는 addFirst
		if (size == 0) {
			addFirst(value);
			return;
		}

		// tail.next가 new Node를 가리키고 tail이 가리키는 노드 위치를 바꿔준다
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		size++;

	}

	@Override
	public void add(int index, E value) {

		// 예외 처리
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		// 가장 앞에 추가하려는 경우
		if (index == 0) {
			addFirst(value);
			return;
		}

		// 가장 마지막에 추가하려는 경우
		if (index == size) {
			addLast(value);
			return;
		}

		// 추가하려는 위치의 이전 노드
		Node<E> prev_Node = search(index - 1);
		// 추가하려는 위치의 노드
		Node<E> next_Node = prev_Node.next;
		// 추가하려는 노드
		Node<E> new_Node = new Node<E>(value);

		// 링크 끊기

		prev_Node.next = null;
		next_Node.prev = null;

		// 링크 연결

		prev_Node.next = new_Node;

		new_Node.prev = prev_Node;
		new_Node.next = next_Node;

		next_Node.prev = new_Node;
		size++;
	}

	public E remove() {
		Node<E> headNode = head;
		if (headNode == null) {
			throw new NoSuchElementException();
		}
		// 삭제된 노드를 반환하기 위한 임시 변수
		E element = headNode.data;
		// head의 다음 노드
		Node<E> nextNode = head.next;

		// head노드의 데이터들을 모두 삭제
		head.data = null;
		head.next = null;

		//
		if (nextNode != null) {
			nextNode.prev = null;
		}
		head = nextNode;
		size--;

		if (size == 0) {
			tail = null;
		}
		return element;
	}

	@Override
	public E remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// 첫 번째 노드인 경우
		if (index == 0) {
			E element = head.data;
			remove();
			return element;
		}

		Node<E> prevNode = search(index - 1);// 삭제할 노드의 이전 노드
		Node<E> removeNode = prevNode.next;// 삭제할 노드
		Node<E> nextNode = removeNode.next;// 삭제할 노드의 다음 노드

		E element = removeNode.data; // 삭제할 노드의 데이터를 반환할 임시 변수

		prevNode.next = null;
		removeNode.next = null;
		removeNode.prev = null;
		removeNode.data = null;

		if (nextNode.prev != null) {
			nextNode.prev = null;
			nextNode.prev = prevNode.next;
			prevNode.next = nextNode;
		} else {// 마지막 노드를 삭제했다는 의미
			tail = nextNode;
		}
		size--;

		return element;
	}

	@Override
	public boolean remove(Object value) {
		Node<E> prevNode = head;
		Node<E> x = head;// removeNode

		for (; x != null; x = x.next) {
			if (value.equals(x.data)) {
				break;
			}
			prevNode = x;
		}

		// 없는 경우
		if (x == null) {
			return false;
		}

		// 찾는 노드가 head인 경우
		if (x.equals(head)) {
			remove();
			return true;
		} else {
			Node<E> nextNode = x.next;

			prevNode.next = null;
			x.data = null;
			x.next = null;
			x.prev = null;

			if (nextNode != null) {
				nextNode.prev = prevNode;
				prevNode.next = nextNode;

			} else {
				tail = prevNode;
			}
			size--;
			return true;
		}
	}

	@Override
	public E get(int index) {
		return search(index).data;
	}

	@Override
	public void set(int index, E value) {
		Node<E> replaceNode = search(index);
		replaceNode.data = null;
		replaceNode.data = value;
		// search(index).data = value;
	}

	// 요소의 존재여부
	@Override
	public boolean contains(Object value) {
		return indexOf(value) >= 0;// 요소가 존재하면 0보다 큼
	}

	@Override
	public int indexOf(Object o) {// 정방향
		int index = 0;
		for (Node<E> x = head; x != null; x = x.next) {
			if (o.equals(x.data)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public int lastIndexOf(Object o) {// 역방향
		int index = size;
		for (Node<E> x = tail; x != null; x = x.prev) {
			index--;
			if (o.equals(x.data)) {
				return index;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for (Node<E> x = head; x != null;) {
			Node<E> nextNode = x.next;
			x.data = null;
			x.next = null;
			x.prev = null;
			x = nextNode;
		}
		head = tail = null;
		size = 0;
	}

	public void show() {
		System.out.print(head.data + "" + tail.data);
	}
	/*
	 * 부가 목록 clone, toArray, sort
	 */

}// end of class