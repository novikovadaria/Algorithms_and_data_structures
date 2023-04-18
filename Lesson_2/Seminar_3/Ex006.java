/**
 * 
 * Обновляем методы согласно новой структуре. Появилась дополнительная
 * переменная, которую необходимо отслеживать во всех операциях. Так же
 * благодаря ссылке на последний элемент списка операции работы с концом стали
 * проще и их стоит заменить на логику аналогичную работе с началом списка
 */
public class Ex006 {

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

    ml.addLast("Пять!");

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
  Node tail;

  public void addFirst(String... values) {
    for (String string : values) {
      this.addFirst(string);
    }
  }

  public void addFirst(String value) {
    Node node = new Node(value);

    if (head != null) {
      node.setNext(head);
      head.setPrev(node);
    } else {
      tail = node;
    }
    head = node;
  }

  public void removeFirst() {
    if (head != null && head.getNext() != null) {
      head.getNext().setPrev(null);
      head = head.getNext();
    } else {
      head = null;
      tail = null;
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

    if (tail != null) {
      node.setPrev(tail);
      tail.setNext(node);
    } else {
      head = node;
    }
    tail = node;
  }

  public void removeLast() {
    if (tail != null && tail.getPrev() != null) {
      tail.getPrev().setNext(null);
      tail = tail.getPrev();
    } else {
      head = null;
      tail = null;
    }
  }
}

class Node {

  private Node next;
  private Node prev;

  String value;

  public Node(String value) {
    this.value = value;
  }

  public Node getPrev() {
    return prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
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
