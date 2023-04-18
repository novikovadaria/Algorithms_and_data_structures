/**
 * В данном примере класс Node представляет узел списка, а класс DoublyLinkedList реализует сам список.
 * Каждый узел содержит данные (переменная data), ссылку на предыдущий узел (переменная prev)
 * и ссылку на следующий узел (переменная next).
 * Метод addNode добавляет новый узел в конец списка.
 * Если список пустой, то новый узел становится и головным, и хвостовым элементом.
 * Иначе новый узел добавляется после текущего хвостового элемента,
 * и указатели prev и next всех необходимых узлов обновляются.
 * Метод deleteNode удаляет узел из списка по заданному значению.
 * Если узел находится в начале списка (головном элементе),
 * то головной указатель head обновляется на следующий узел,
 * а у него указатель prev устанавливается в null.
 * Если узел находится в конце списка (хвостовом элементе),
 * то хвостовой указатель tail обновляется на предыдущий узел,
 * а у него указатель next устанавливается в null. Если узел находится в середине списка,
 * то узлы, следующие и предыдущие за ним, связываются между собой,
 * а указатели prev и next удаляемого узла обнуляются
 */
public class Node {
	int data;
	Node prev;
	Node next;

	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

class DoublyLinkedList {
	Node head;
	Node tail;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addNode(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	public void deleteNode(int data) {
		Node current = head;

		while (current != null) {
			if (current.data == data) {
				if (current == head) {
					head = current.next;
					if (head != null) {
						head.prev = null;
					}
				} else if (current == tail) {
					tail = current.prev;
					if (tail != null) {
						tail.next = null;
					}
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				break;
			}
			current = current.next;
		}
	}

	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * Метод sortList сортирует многосвязный список, используя алгоритм сортировки вставками.
	 * Для выполнения сортировки мы проходим по списку и на каждой итерации выбираем узел с индексом i.
	 * Затем мы сравниваем его со всеми узлами с индексом меньше i и
	 * перемещаем его в нужное место путем обмена местами с предыдущими узлами.
	 * Метод getNodeAtIndex возвращает узел списка с заданным индексом.
	 * Метод swapNodes меняет местами два узла списка. В данном примере мы обмениваем местами
	 * только данные узлов, но в общем случае можно менять местами ссылки на предыдущий и следующий узлы,
	 * чтобы не нарушить связность списка.
	 */
	public void sortList() {
		if (head == null || head.next == null) {
			return;
		}

		// получаем длину списка
		int listLength = 0;
		Node current = head;
		while (current != null) {
			listLength++;
			current = current.next;
		}

		// выполняем сортировку вставками
		for (int i = 1; i < listLength; i++) {
			Node key = getNodeAtIndex(i);
			int j = i - 1;
			while (j >= 0 && getNodeAtIndex(j).data > key.data) {
				swapNodes(getNodeAtIndex(j), key);
				j--;
			}
		}
	}

	private Node getNodeAtIndex(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	private void swapNodes(Node node1, Node node2) {
		int temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
	}

	/**
	 * Метод reverseList разворачивает многосвязный список, меняя порядок узлов на противоположный.
	 * Для этого мы проходим по списку, сохраняя ссылку на следующий узел, меняем ссылку текущего
	 * узла на предыдущий и затем переходим к следующему узлу. В конце мы делаем голову списка
	 * равной последнему узлу, который теперь стал первым.
	 * Обратите внимание, что перед началом разворота мы проверяем,
	 * что список содержит более одного узла. Если список пуст или содержит только один узел,
	 * то разворот не нужен и мы просто возвращаемся из метода.
	 */
	public void reverseList() {
		if (head == null || head.next == null) {
			return;
		}

		Node previous = null;
		Node current = head;
		while (current != null) {
			Node next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		head = previous;
	}
}
