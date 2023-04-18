/**
 * 
 * Реализуем метод добавления новых элементов в начало списка и удаление первого
 * элемента связного списка. Односвязный список всегда имеет ссылку на первый
 * элемент последовательности, потому именно с реализации методов для первого
 * элемента последовательности стоит начать
 */
public class Ex002 {

  public static void main(String[] args) {
    MyList ml = new MyList();
    ml.addFirst("Раз", "Два", "Три");

    var item = ml.head;

    while (item != null) {
      System.out.println(item);
      item = item.getNext();
    }
  }
}

class MyList {
  Node head;

  public void addFirst(String... values) {
    for (String string : values) {
      this.addFirst(string);
    }
  }

  public void addFirst(String value) {
    Node node = new Node(value);

    if (head != null) {
      node.setNext(head);
    }

    head = node;
  }

  public void removeFirst() {
    if (head != null) {
      head = head.getNext();
    }
  }
}

class Node {

  private Node next;
  private String value;

  public Node(String value) {
    this.value = value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node(Node next, String value) {
    this.next = next;
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
