package linked_List;

public class LinkedList2<T> {

	/**
	 * global variables for the maintenance of the list
	 */
	private Node1<T> head;
	private Node1<T> current;
	static int length = 0;

	/**
	 * adds a node to the list
	 * 
	 * @param value the value to be added
	 * @return true if addition was successful
	 */
	public boolean add(T value) {
		addLast(value);
		return true;
	}

	/**
	 * @return head of the list
	 */
	public Node1<T> head() {
		if (head == null) {
			throw new NullPointerException();
		}
		return head;
	}

	/**
	 * inserts a new node at the start of the list
	 * 
	 * @param value the value to be added
	 * @return true if addition was successful
	 */
	public boolean addFirst(T value) {
		Node1<T> newNode = new Node1<T>(value, head);
		head = newNode;
		return true;
	}

	/**
	 * inserts a new node after the specified index
	 * 
	 * @throws IllegalArgumentException if index < 0 ||index > length of the list
	 * @throws NullPointerException     if value==null
	 * @param index after this index insertion will take place
	 * @param value the value to be added
	 * @return true if insertion is successful
	 */
	public boolean add(int index, T value) {
		if (index < 0 || index > length) {
			throw new IllegalArgumentException();
		}
		if (value == null) {
			throw new NullPointerException();
		}
		Node1<T> temp = head;
		int count = index;
		while (count <= index) {
			temp = temp.next;
			count++;
		}
		temp.next = new Node1<T>(value, temp.next);
		length++;
		return true;
	}

	/**
	 * Inserts a new node at the end of the list
	 * 
	 * @throws NullPointerException if value==null
	 * @param value the value to be added
	 * @return true if insertion is successful
	 */
	public boolean addLast(T value) {
		if (value == null) {
			throw new NullPointerException();
		}
		if (length == 0) {
			head = new Node1<T>(value);
			current = head;
			length++;
			return true;

		} else {
			Node1<T> temp = new Node1<T>(value);
			current.next = temp;
			current = temp;
			length++;
			return true;
		}
	}

	/**
	 * removes the first node
	 * 
	 * @throws NullPointerException if head == null;
	 * @return the removed node's value
	 */
	public T removeFirst() {
		if (head == null) {
			throw new NullPointerException();
		}
		T removed = head.value;
		head = head.next;
		length--;
		return removed;

	}

	/**
	 * removes the last node of the list
	 * 
	 * @throws NullPointerException if head == null
	 * @return the removed node's value
	 */
	public T removeLast() {
		if (head == null) {
			throw new NullPointerException();
		}

		Node1<T> temp = head;
		Node1<T> last = head;

		T removed = head.value;

		while (temp.next != null) {
			last = temp;
			removed = temp.value;
			temp = temp.next;
		}

		last.next = null;
		length--;
		return removed;
	}

	/**
	 * removes the next node of the specified index
	 * 
	 * @throws IllegalArgumentException if index <0 || index > = list length
	 * @param index node after this index will be removed
	 * @return removed node's value
	 */
	public T remove(int index) {
		if (index < 0 || index >= length) {
			throw new IllegalArgumentException();
		}
		Node1<T> temp = head;
		int count = index;
		while (count <= index) {
			temp = temp.next;
			count++;
		}
		T value = temp.value;
		temp.next = temp.next.next;
		length--;
		return value;
	}

	/**
	 * replaces the value at the specified index with the specified value
	 * 
	 * @throws IllegalArgumentException if index < 0 || index > length
	 * @param index value of node at this Index will be replaced
	 * @param value node's value will be replaced with this value
	 * @return true if replacement was successful
	 */
	public boolean replace(int index, T value) {

		if (index < 0 || index > length) {
			throw new IllegalArgumentException(" index " + index + " does not exist");
		}

		Node1<T> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
			value = temp.value;
		}
		temp.value = value;
		return true;

	}

	/**
	 * @return length of the list
	 */
	public int size() {
		return length;
	}

	/**
	 * reverse the list
	 * 
	 * @throws NullPointerException if head == null
	 */
	public void reverse() {
		if (head == null) {
			throw new NullPointerException();
		}
		Node1<T> temp = null;
		Node1<T> curr = head;
		Node1<T> nex = head;
		while (curr != null) {
			nex = curr.next;
			curr.next = temp;
			temp = curr;
			curr = nex;
		}
		current = head;
		head = temp;
	}

	public boolean reverse(int start, int end) {
		/*
		 * if (start <= 0 || end > length) { throw new IllegalArgumentException(); } if
		 * (head == null) { throw new NullPointerException(); }
		 */
		int count = 1;

		Node1<T> temp = head;
		while (count < start) {
			temp = temp.next;
			count++;
		}
		Node1<T> curr = temp.next;
		Node1<T> next = temp.next.next;
		while (count <= end) {
			curr.next = temp;
			temp = curr;
			curr = next;
			next = next.next;
		}

		return true;
	}

	/**
	 * searches the list for the specified value
	 * 
	 * @param value the value to be searched
	 * @return true if list contains the specified value
	 */
	public boolean contains(T value) {
		boolean contains = false;
		Node1<T> temp = head;
		while (temp != null) {
			if (temp.value == value) {
				contains = true;
				break;
			} else {
				temp = temp.next;
			}
		}
		return contains;
	}

	@Override
	public String toString() {
		return print() + "]";
	}

	/**
	 * helper function to print the list
	 * 
	 * @return
	 */
	private String print() {
		String s = "[";
		Node1<T> temp = head;
		int count = 0;
		while (temp != null) {
			if (length == 1) {
				return s + temp.value;
			} else {
				if (count == length - 1) {
					s += temp.value;
				} else {
					s += temp.value + ",";
				}
				count++;
				temp = temp.next;
			}
		}
		return s;
	}
}
