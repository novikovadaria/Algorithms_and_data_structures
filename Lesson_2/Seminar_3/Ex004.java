/**
 * 
 * Реализуем метод добавления новых элементов в конец списка и удаление
 * последнего элемента связного списка. Теперь, когда мы понимаем, как можно
 * искать значения внутри связного списка, мы можем сделать методы добавления и
 * удаления элементов в конец нашего односвязного списка.
 */
public class Ex004 {

  public static void main(String[] args) {

    MyList ml = new MyList();
    ml.addFirst("Раз", "Два", "Три");

    var item = ml.head;

    while (item != null) {
      System.out.println(item);
      item = item.getNext();
    }

    System.out.println(ml.contains("Два"));
    System.out.println();

    ml.removeLast();

    System.out.println();
    item = ml.head;
    while (item != null) {
      System.out.println(item);
      item = item.getNext();
    }

    ml.addLast("Пять");
    System.out.println(

    );
    item = ml.head;
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

  public boolean contains(String value) {
    Node node = head;
    while (node != null) {
      if (node.getValue().equals(value)) {
        return true;
      }
      node = node.getNext();
    }
    return false;
  }

  public void addLast(String value) {
    Node node = new Node(value);

    if (head == null) {
      head = node;
    } else {
      Node last = head;
      while (last.getNext() != null) {
        last = last.getNext();
      }
      last.setNext(node);
    }
  }

  public void removeLast() {
    if (head != null) {
      Node node = head;

      while (node.getNext() != null) {
        if (node.getNext().getNext() == null) {
          node.setNext(null);
          return;
        }
        node = node.getNext();
      }
      head = null;
    }
  }
}

class Node {

  private Node next;
  String value;

  public Node(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
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
