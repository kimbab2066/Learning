package List;

public class Node<E> {
	E data;
	Node<E> next;
	Node<E> prev; // 이전 노드를 가리키는 Reference Variable

	Node(E data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
