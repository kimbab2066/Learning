package Heap;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
	/*
	 * 
	 * 클래스 및 생성자와 필수 메소드 구성
	 * 
	 * resize 메소드 구현
	 * 
	 * add 계열 메소드 구현
	 * 
	 * remove 메소드 구현
	 * 
	 * size, peek, isEmpty ,toArray 메소드 구현
	 */

	private final Comparator<? super E> comparator;
	private static final int DEFAULT_CAPACITY = 10;// 최소 용적 크기

	private Object[] array;// 기본 배열
	private int size;// 요소 갯수

	// 생성자1 - 초기 공간 할당 X
	public Heap() {
		this(null);
	}

	public Heap(Comparator<? super E> comparator) {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.comparator = comparator;
	}

	// 생성자2 - 초기 공간 할당 O
	public Heap(int capacity) {
		this(capacity, null);
	}

	public Heap(int capacity, Comparator<? super E> comparator) {
		this.array = new Object[capacity];
		this.size = 0;
		this.comparator = comparator;
	}

	// 부모 노드 인덱스 반환
	private int getParent(int index) {
		return index / 2;
	}

	// 왼쪽 자식 노드 인덱스 반환
	private int getLeftChild(int index) {
		return index * 2;
	}

	// 오른쪽 자식 노드 인덱스 반환
	private int getRightChild(int index) {
		return index * 2 + 1;
	}

	// resize 메소드 구현
	/*
	 * @param newCapacity 새로운 용적 크기
	 */

	private void resize(int newCapacity) {
		// new array
		Object[] newArray = new Object[newCapacity];
		// copy of element
		for (int i = 1; i <= size; i++) {
			newArray[i] = array[i];
		}

		// GC처리를 위해 null처리 후 새 배열로 연결
		this.array = null;
		this.array = newArray;
	}

	// add 메소드 구현
	// 1. Comparator사용
	// 2. Comparable or 기본 정렬 방식
	// 배열의 마지막 부분에 원소를 넣고 부모 노드와 비교해서 부모 노드가 작을 때 까지 올라간다
	// 위와 같은 과정을 올라가면서 선별한다고 하여 sift-up(상향 선별)이라고도 불린다.

	public void add(E value) {
		// 용적이 가득찬 경우 2배로
		if (size + 1 == array.length) {
			resize(array.length * 2);
		}
		siftUp(size + 1, value);
		size++;
	}

	/*
	 * 상향선별
	 * 
	 * @param idx 추가한 노드의 인덱스
	 * 
	 * @param target 재배치 할 노드
	 */
	private void siftUp(int idx, E target) {
		// comparator 존재 시 인자로 넣어주기
		if (comparator != null) {
			siftUpComparator(idx, target, comparator);
		} else {
			siftUpComparable(idx, target);
		}
	}

	// 위에서 처음 말한 1번 부분인 Comparator를 이용한 sift-Up
	@SuppressWarnings("unchecked")
	private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {
		// root노드보다 클 때까지만 탐색
		while (idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent];
			// target노드와 부모 노드의 값 비교 후 크면 종료
			if (comp.compare(target, (E) parentVal) >= 0) {
				break;
			}
			// 현재 삽입될 위치에 부모노드 값으로 교체, 타겟 노드 위치를 부모노드로 변경
			array[idx] = parentVal;
			idx = parent;
		}
		// 삽입 될 위치에 타겟 노드 값 저장
		array[idx] = target;
	}

	// 위에서 처음 말한 2번 부분인 Comparable를 이용한 sift-Up
	@SuppressWarnings("unchecked")
	private void siftUpComparable(int idx, E target) {
		// target과 비교될 comp변수
		Comparable<? super E> comp = (Comparable<? super E>) target;

		while (idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent];
			if (comp.compareTo((E) parentVal) >= 0) {
				break;
			}
			array[idx] = parentVal;
			idx = parent;
		}
		array[idx] = comp;
	}
	// 최대힙을 구현하고 싶은 경우 >= 0 부분을 <=로 바꾸면 된다

	// remove 메소드 구현
	// 아래로 내려가면서 재배치 하는 과정을 sift-down(하향 선별)이라고 한다.
	@SuppressWarnings("unchecked")
	public E remove() {
		if (array[1] == null) {// 비어 있는 경우
			throw new NoSuchElementException();
		}
		E element = (E) array[1]; // 임시 변수
		E target = (E) array[size]; // 타겟이 될 요소

		array[size] = null;

		siftDown(1, target);
		return element;
	}

	/*
	 * @param idx 삭제할 노드의 인덱스
	 * 
	 * @param target 재배치 할 노드
	 */
	public void siftDown(int idx, E target) {
		if (comparator != null) {
			siftDownComparator(idx, target, comparator);
		} else {
			siftDownComparable(idx, target);
		}
	}

	@SuppressWarnings("unchecked")
	public void siftDownComparator(int idx, E target, Comparator<? super E> com) {
		array[idx] = null; // 1이니 root가 null이 됨
		size--;

		int parent = idx;
		int child;
		
	}

	@SuppressWarnings("unchecked")
	public void siftDownComparable(int idx, E target) {

	}
}// end of class