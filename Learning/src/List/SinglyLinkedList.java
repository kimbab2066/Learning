package List;

import Interface_form.List;

public class SinglyLinkedList<E> implements List<E> {
	private Node<E> head;// 노드의 첫 부분
	private Node<E> tail; // 노드의 끝 부분
	private int size;// 요소의 개수 = 연결된 노드의 개수

	// constructor
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// 특정 위치의 노드를 반환하는 메서드
	private Node<E> search(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> x = head; // head가 가리키는 노드부터 시작
		for (int i = 0; i < index; i++) {
			x = x.next;// x 노드의 다음 노드를 x 에 저장한다
		}
		return x;
	}

	public void addFirst(E value) {
		Node<E> newNode = new Node<E>(value);// 새 노드 생성
		newNode.next = head;// 새 노드의 다음 노드로 head 노드를 연결
		head = newNode; // head가 가리키는 노드를 새 노드로 변경
		size++;

		// 데이터가 한 개인 경우
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
		Node<E> newNode = new Node<E>(value);// 새 노드 생성

		if (size == 0) { // 처음 넣는 노드일 경우 addFirst로 추가
			addFirst(value);
			return;
		}
		tail.next = newNode;
		tail = newNode;
		size++;
	}

	@Override
	public void add(int index, E value) {
		// 예외처리
		if (index < 0 || index >= 0)
			throw new IndexOutOfBoundsException();
		// 가장 앞에 추가하는 경우
		if (index == 0) {
			addFirst(value);
			return;
		}
		// 마지막 위치일 경우
		if (index == size) {
			addLast(value);
			return;
		}

		// 둘 다 아닌 경우
		// 추가하려는 위치의 이전 노드
		Node<E> prev_Node = search(index - 1);
		// 추가하려는 위치의 노드
		Node<E> next_Node = prev_Node.next;
		// 추가하려는 노드
		Node<E> newNode = new Node<E>(value);

		prev_Node.next = null;
		prev_Node.next = newNode;
		newNode.next = next_Node;
		size++;

	}

	public E remove() {
		Node<E> headNode = head;
		if (headNode == null)
			throw new IndexOutOfBoundsException();

		// 삭제된 노드를 반환하기 위한 임시 변수
		E element = headNode.data;
		// head의 다음 노드
		Node<E> nextNode = head.next;

		// head 노드의 데이터들을 모두 삭제
		head.data = null;
		head.next = null;

		head = nextNode;
		size--;

		if (size == 0) {
			tail = null;
		}
		return element;
	}

	@Override
	public E remove(int index) {
		if (index == 0) {
			return remove();
		}
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> prevNode = search(index - 1);
		Node<E> removeNode = prevNode.next;
		Node<E> nextNode = removeNode.next;

		// 삭제되는 노드의 데이터 임시 저장 변수
		E element = removeNode.data;

		// 이전 노드가 가리키는 노드를 삭제하려는 노드의 다음 노드로 변경
		prevNode.next = nextNode;
		// 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
		if (removeNode.next == null) {
			tail = prevNode;
		}
		// 데이터 삭제
		removeNode.data = null;
		removeNode.next = null;
		size--;

		return element;
	}

	// 사용자가 원하는 특정 요소(value)를 리스트에서 찾아서 삭제
	@Override
	public boolean remove(Object value) {
		Node<E> prevNode = head;
		boolean hasValue = false;
		Node<E> x = head;// removeNode

		// value와 일치하는 노드 찾기.
		for (; x != null; x = x.next) {
			if (value.equals(x.data)) {
				hasValue = true;
				break;
			}
			prevNode = x;
		}

		// 일치하는 요소가 없을 경우 false
		if (x == null) {
			return false;
		}

		// 삭제하려는 노드가 head라면 remove() 사용
		if (x.equals(head)) {
			remove();
			return true;
		} else {
			// 이전 노드의 링크를 삭제하려는 노드의 다음 노드로 연결
			prevNode.next = x.next;
			// 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
			if (prevNode.next == null) {
				tail = prevNode;
			}
			x.data = null;
			x.next = null;
			size--;
			return true;
		}
	}

	// index로 들어오는 값을 인덱스 삼아 해당 위치에 있는 요소를 반환하는 메서드
	@Override
	public E get(int index) {
		return search(index).data;// 가능한 이유 : search의 return이 Node<E>라서
	}

	// index에 위치한 데이터를 새로운 데이터로 교체하는 것
	@Override
	public void set(int index, E value) {

		Node<E> replaceNode = search(index);
		replaceNode.data = null;
		replaceNode.data = value;
		// search(index).data = value; <- 이 방식도 됨
	}

	// 사용자가 찾고하자는 요소가 존재하는지 안하는지를 반환
	@Override
	public boolean contains(Object value) {
		return indexOf(value) >= 0;
		// return indexOf(value) >= 0 ? true : false;
	}

	// 사용자가 찾고자하는 요소(value)의 위치(index)를 반환
	@Override
	public int indexOf(Object value) {

		// index 0부터 시작해서 끝까지 LOOP 돌면서 value와 같은 게 있는지 equals()로 체크 후 return
		int index = 0;
		for (Node<E> x = head; x != null; x = x.next) {
			if (value.equals(x.data)) {
				return index;
			}
			index++;
		}
		// 없으면 -1
		return -1;
	}

	@Override
	public int size() {
		return this.size;
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
			x = x.next;
		}
		head = tail = null;
		size = 0;
	}

	public void show() {
		System.out.print(head.data + "" + tail.data);
	}
	/*
	 * 부가 목록 clone, toArray, sord
	 */
}// end of class