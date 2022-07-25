package Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

import Interface_form.StackInterface;

public class Stack<E> implements StackInterface<E> {

	// 최소(기본) 용적 크기
	private static final int DEFAULT_CAPACITY = 10;
	// 빈 배열
	private static final Object[] EMPTY_ARRAY = {};
	// 요소를 담을 배열
	private Object[] array;
	// 요소 개수
	private int size;

	// 생성자1(초기 공간 할당X)
	Stack() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}

	// 생성자2(초기 공간 할당O)
	Stack(int capacity) {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	// 동적 할당을 위한 resize 메소드 구현
	private void resize() {
		// 빈 배열일 경우(capacity is 0)
		if (Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		int arrayCapacity = array.length;// 현재 용적 크기
		// 용적이 가득 찰 경우
		if (size == arrayCapacity) {
			int newSize = arrayCapacity * 2;
			// 배열 복사
			array = Arrays.copyOf(array, newSize);// 복사할 배열, 용적의 크기
			// 나머지 빈 공간은 null로 채워진다.
			return;
		}
		// 용적이 절반 미만으로 요소가 차지하고 있을 경우
		if (size < (arrayCapacity / 2)) {
			int newCapacity = (arrayCapacity / 2);
			array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
			// 새로운 용적크기 설정 시 새로운 용적과 최소용적 크기를 비교하여 큰 것으로 설정
			return;
		}
	}// end of resize

	@Override
	public E push(E item) {
		// 용적이 가득 찬 경우 재할당
		if (size == array.length) {
			resize();
		}
		array[size] = item;// 마지막 위치에 요소 추가
		size++;// size 1 증가

		return item;
	}

	// push메소드의 메커니즘을 반대로 구현
	@Override
	public E pop() {
		// 삭제할 요소가 없는 경우 = Stack이 비어있다는 의미
		if (size == 0) {
			throw new EmptyStackException();
		}

		@SuppressWarnings("unchecked") // 형변환 예외가 없을 시 사용
		E obj = (E) array[size - 1];// 삭제할 요소를 반환하기 위한 임시 변수

		size--;// size 1 감소
		resize();// 용적 재할당

		return obj;
	}

	// pop 메소드에서 삭제과정만 없는 것
	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return (E) array[size - 1];
	}

	// '찾으려는 데이터가 상단의 top 기준으로 얼마만큼 떨어져 있는지'에 대한 상대적 위치 값
	@Override
	public int search(Object value) {
		for (int idx = size - 1; idx >= 0; idx--) {
			// 찾는 경우 반환
			if (array[idx].equals(value)) {
				return size - idx;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return this.size;
	}

	// 모든 요소를 비워버린다.
	@Override
	public void clear() {
		// 저장되어있던 모든 요소를 null 처리 해준다.
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
		resize();
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.println(array[i]);
		}
	}

}// end of class
