package Queue;

import java.util.NoSuchElementException;

import Interface_form.Queue;

public class ArrayDeque<E> implements Queue<E> {
	// 최소(기본) 용적 크기
	private static final int DEFAULT_CAPACITY = 64;
	// 요소를 담을 배열
	private Object[] array;
	// 요소 개수
	private int size;

	// 시작 인덱스를 가리키는 변수(빈 공간임을 유의) = queue구현 시와 같음
	private int front;
	// 마지막 요소의 인덱스를 가리키는 변수
	private int rear;

	// 생성자1 (초기 용적 할당을 안할 경우)
	public ArrayDeque() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}

	// 생성자2 (초기 용적 할당을 할 경우)
	public ArrayDeque(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}

	// 동적 할당을 위한 resize 메소드 구현
	private void resize(int newCapacity) {
		int arrayCapacity = array.length; // 현재 용적 크기
		Object[] newArray = new Object[newCapacity]; // 용적을 변경할 배열
		// i = new array index, j = original array
		// 0부터 시작하지 않는 이유는 front가 비어있는 공간이기 때문
		for (int i = 1, j = front + 1; i <= size; i++, j++) {
			newArray[i] = array[j % arrayCapacity];
		}
		this.array = null;
		this.array = newArray;// 새 배열로 덮어 씌우기

		front = 0;
		rear = size;
	}

	@Override
	public boolean offer(E item) {
		return offerLast(item);
	}

	// 전방 삽입
	public boolean offerFirst(E item) {
		// 용적이 가득 찬 경우
		if ((front - 1 + array.length) % array.length == rear) {
			resize(array.length * 2);
		}
		// item 넣고 front 갱신
		array[front] = item;// 빈 공간이라서 추가 후 갱신
		front = (front - 1 + array.length) % array.length;

		size++;

		return true;
	}

	// 기본 삽입(후방 삽입)
	public boolean offerLast(E item) {
		// 용적이 가득 찬 경우
		if ((rear + 1) % array.length == front) {// resize 시 배열에 있던 부분과 같음
			resize(array.length * 2);// 용적을 2배로 늘려주자
		}

		rear = (rear + 1) % array.length; // rear 위치 갱신(하는 이유 : Linear Queue의 원리 생각)
		array[rear] = item;

		size++;

		return true;
	}

	@Override
	public E poll() {
		return pollFirst();
	}

	// 전방 삭제
	public E pollFirst() {
		if (size == 0) {
			return null;
		}
		front = (front + 1) % array.length;// front 한 칸 옮기기

		@SuppressWarnings("unchecked")
		E item = (E) array[front];
		array[front] = null;// 해당 front 삭제(빈 공간으로 만들기)
		size--;

		// 용적이 최소 크기(64)보다 크고 요소 개수가 1/4미만인 경우
		if (array.length > DEFAULT_CAPACITY && size < (DEFAULT_CAPACITY / 4)) {
			// 최소 용적 or 2로 나누기
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
		return item;
	}

	// 후방 삭제
	public E pollLast() {
		if (size == 0) {
			return null;
		}
		@SuppressWarnings("unchecked")
		E item = (E) array[rear];// 반환할 데이터 임시 저장

		array[rear] = null;
		rear = (rear - 1) % array.length;// rear 한 칸 옮기기
		size--;

		// 용적이 최소 크기보다 크고 요소 개수가 1/4미만인 경우
		if (array.length > DEFAULT_CAPACITY && size < (DEFAULT_CAPACITY / 4)) {
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
		return item;
	}

	public E remove() {
		return removeFirst();// 예외 던지기
	}

	public E removeFirst() {
		E item = pollFirst();
		if (item == null) {
			throw new NoSuchElementException();
		}
		return item;
	}

	public E removeLast() {
		E item = pollLast();
		if (item == null) {
			throw new NoSuchElementException();
		}
		return item;
	}

	// peek 계열 메소드 구현
	@Override
	public E peek() {
		return peekFirst();
	}

	public E peekFirst() {
		if (size == 0) return null;
		@SuppressWarnings("unchecked")
		E item = (E) array[(front + 1) % array.length];// front = 빈공간
		return item;
	}

	public E peekLast() {
		if (size == 0) return null;
		@SuppressWarnings("unchecked")
		E item = (E) array[rear];
		return item;
	}

	public E element() {
		return getFirst();
	}

	public E getFirst() {
		E item = peek();
		if (item == null) {
			throw new NoSuchElementException();
		}
		return item;
	}

	public E getLast() {
		E item = peekLast();
		if (item == null) {
			throw new NoSuchElementException();
		}
		return item;
	}

	// size, isEmpty, contains, clear
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object value) {
		int start = (front + 1) % array.length;
		for (int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
			if (array[idx] == value) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		front = rear = size = 0;
	}

	public void show() {
		int start = (front + 1) % array.length;
		for (int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
			System.out.print(array[idx] + " ");
		}
	}
}// end of class