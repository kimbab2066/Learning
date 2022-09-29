package 자료구조_구현연습;

import java.util.Arrays;

import Interface_form.List;

public class ArrayList<E> implements List<E> {
	/*
	 * 1단계
	 * 
	 * 클래스 및 생성자,멤버(기본 용적 크기, 배열, 개수, 요소 담을 배열, 초기 공간 할당X,O 구성
	 * 
	 * 2단계
	 * 
	 * resize 메소드 구현
	 * 
	 * 3단계
	 * 
	 * add 메소드 구현
	 * 
	 * 4단계
	 * 
	 * get, set, indexOf, contains 메소드 구현
	 * 
	 * 5단계
	 * 
	 * remove 메소드 구현
	 * 
	 * 6단계
	 * 
	 * size, isEmpty, clear 메소드 구현
	 */
	// 1단계
	private static final int DEFAULT_CAPACITY = 10;
	private static Object[] EMPTY_ARRAY = {};
	private int size;
	Object[] array;

	ArrayList() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}

	ArrayList(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}

	// 2단계
	public void resize() {
		int array_capacity = array.length;

		if (array_capacity == 0) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		// full
		if (size == array_capacity) {
			int new_capatity = array_capacity * 2;
			array = Arrays.copyOf(array, new_capatity);
			return;
		}
		// small
		if (size < array_capacity / 2) {
			int new_capacity = array_capacity / 2;
			array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
			return;
		}
	}

	// 3단계 add
	// 마지막에 추가
	// 처음 추가
	// 특정 위치 추가
	public void addLast(E value) {
		if (size == array.length) {
			resize();
		}
		array[size] = value;
		size++;
	}

	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}

	@Override
	public void add(int index, E value) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == size) {
			addLast(value);
		} else {

			if (size == array.length) {
				resize();
			}
			for (int i = size; i > index; i--) {// 이부분이 중요!
				array[i] = array[i - 1];
			}
			array[index] = value;
			size++;
		}
	}

	public void addFirst(E value) {
		add(0, value);
	}

	@Override
	// public E remove(int index) {
	// }

	@Override
	public boolean remove(Object value) {
		return false;
	}

	@Override
	public E get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return (E) array[index];
	}

	@Override
	public void set(int index, E value) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		array[index] = value;
	}

	@Override
	public boolean contains(Object value) {
		if (indexOf(value) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int indexOf(Object value) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(Object value) {
		for (int i = size - 1; i >= 0; i--) {
			if (array[i].equals(value)) {
				return i;
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
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
		resize();
	}
}// end of class