package List;

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

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int index, E value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}// end of class