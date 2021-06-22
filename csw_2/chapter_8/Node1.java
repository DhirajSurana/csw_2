package chapter_8;

public class Node1<T> {

	T value;
	Node1<T> next;

	public Node1() {
		next = null;
	}

	public Node1(T value) {
		this.value = value;
	}

	public Node1(T value, Node1<T> next) {
		this.value = value;
		this.next = next;
	}
}