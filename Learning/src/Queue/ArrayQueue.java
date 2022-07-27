package Queue;

import java.util.NoSuchElementException;

import Interface_form.Queue;

public class ArrayQueue<E> implements Queue<E> {
	// 최소(기본) 용적 크기
	private static final int DEFAULT_CAPACITY = 64;
	// 요소를 담을 배열
	private Object[] array;
	// 요소 개수
	private int size;
	// 시작 인덱스, 마지막 요소의 인덱스를 가리키는 변수
	private int front, rear;

	// 생성자1(초기 용적 할당 X)
	public ArrayQueue() {
		array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}

	// 생성자2(초기 용적 할당O)
	public ArrayQueue(int capacity) {
		array = new Object[capacity];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}

	// 동적할당을 위한 resize메소드
	public void resize(int newCapacity) {
		int arrayCapacity = array.length;// 현재 용적 크기
		Object[] newArray = new Object[newCapacity];// 용적을 변경한 배열
		/*
		 * i = new array index
		 * 
		 * j = original array
		 * 
		 * index 요소 개수(size)만큼 새 배열에 값 복사
		 */
		for (int i = 1, j = front + 1; i <= size; i++, j++) {
			newArray[i] = array[j % arrayCapacity];// 기존 배열의 값을 복사해서 넣겠다는 의미
		}
		this.array = null;
		this.array = newArray;// 덮어 씌움
		front = 0;
		rear = size;

	}

	@Override
	public boolean offer(E item) {
		// 용적이 가득 찬 경우
		if ((rear + 1) % array.length == front) {
			resize(array.length * 2);// 용적을 두배로
		}
		rear = (rear + 1) % array.length;// rear 다음 위치로 갱신
		array[rear] = item;
		size++;

		return true;
	}

	// front+1을 삭제하는 개념
	@Override
	public E poll() {
		if (size == 0) {// 삭제할 요소가 없는 경우
			return null;
		}
		front = (front + 1) % array.length;// front 한 칸 옮김
		@SuppressWarnings("unchecked")
		E item = (E) array[front];// 반환할 임시 데이터
		array[front] = null;// 해당 front의 데이터 삭제
		size--;

		// 기본 용적보다 크고 요소 개수가 1/4 미만인 경우
		if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
			resize(Math.max(DEFAULT_CAPACITY, (array.length / 2)));
		}
		return item;
	}

	public E remove() {
		E item = poll();
		if (item == null) {
			throw new NoSuchElementException();
		}
		return item;
	}

	@Override
	public E peek() {
		if (size == 0) {
			return null;
		}
		@SuppressWarnings("unchecked")
		E item = (E) array[(front + 1) % array.length];
		return item;
	}

	public E element() {
		E item = peek();
		if (item == null) {
			throw new NoSuchElementException();
		}
		return item;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object value) {
		int start = (front + 1) % array.length;
		for (int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
			if (array[idx].equals(value)) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;// 명시적 null처리
		}
		front = rear = size = 0;
	}

	public void show() {
		for (int i = 1; i <= size; i++) {
			System.out.print(array[i] + " ");
		}
	}
}// end of class