public class Main {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addNode(5);
		list.addNode(10);
		list.addNode(15);
		list.addNode(20);
		list.addNode(25);
		list.sortList();
		list.reverseList();
		list.printList();
	}
}