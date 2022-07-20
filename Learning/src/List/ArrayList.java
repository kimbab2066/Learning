package List;

import java.util.Arrays;

import Interface_form.List;

public class ArrayList<E> implements List<E> {

	private static final int DEFAULT_CAPACITY = 10;// 최소(기본) 용적 크기
	private static final Object[] EMPTY_ARRAY = {};// 빈 배열

	private int size;// 배열에 담긴 요소(원소)의 개수

	// 용적 크기와 size(원소의 개수는 다름)

	Object[] array;// 요소를 담을 배열

	// 기본 생성자(초기 공간 할당 x)
	public ArrayList() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}

	// 초기 공간 할당 o
	public ArrayList(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}

	private void resize() {
		int array_capacity = array.length;

		// if capacity is 0
		if (Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		// 꽉 찬 경우
		if (size == array.length) {
			int new_capacity = array_capacity * 2;

			// copy
			array = Arrays.copyOf(array, new_capacity);
			return;
		}
		// 절반 미만
		if (size < array_capacity / 2) {
			int new_capacity = array_capacity / 2;
			// copy
			array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
			return;
		}
	}// end of resize

	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}

	public void addLast(E value) {
		// 꽉 찬 경우
		if (size == array.length) {
			resize();
		}
		array[size] = value;// 마지막 요소에 값 추가
		size++;
	}

	@Override
	public void add(int index, E value) {
		if (index > size || index < 0) {// 영역을 벗어날 경우
			throw new IndexOutOfBoundsException();
		}
		if (index == size) {// index가 마지막이면 addLast메서드 사용해서 추가
			addLast(value);
		} else {
			if (size == array.length) {// 꽉 차 있으면 동적 재할당
				resize();
			}
			// index기준 후자에 있는 요소들 한 칸씩 뒤로 밀기
			for (int i = size; i > index; i--) {
				array[i] = array[i - 1];
			}
			array[index] = value;// index위치에 요소 할당
			size++;
		}
	}

	public void addFirst(E value) {
		add(0, value);
	}

	// 특정 index의 요소 삭제
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		E element = (E) array[index];// tmp
		array[index] = null;
		// 삭제요소 뒤에 있는 요소 전부 당겨옴
		for (int i = index; i < size - 1; i--) {
			array[i] = array[i + 1];
			array[i + 1] = null;
		}
		size--;
		resize();
		return element;
	}

	// 특정 요소 삭제
	@Override
	public boolean remove(Object value) {
		int index = indexOf(value);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	// type safe 무시
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return (E) array[index];
	}

	// set = replace
	@Override
	public void set(int index, E value) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		array[index] = value;
	}

	// 존재 여부 체크
	@Override
	public boolean contains(Object value) {
		if (indexOf(value) >= 0) {
			return true;
		}
		return false;
	}

	// value와 일치하는 index return
	@Override
	public int indexOf(Object value) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		// 일치하는 경우가 없을 경우 -1
		return -1;
	}

	public int LastIndexOf(Object value) {
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

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i]+" ");
		}
	}
	/*
	 * 부가 목록 clone(), toArray()
	 */
}// end of class
