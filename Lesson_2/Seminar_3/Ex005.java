/**
 * 
 * Расширяем структуру связного списка до двухсвязного. Мы научились работать с
 * односвязным список, теперь можно ближе познакомиться со структурой
 * двухсвязного списка и особенностей его внутреннего строения. Стоит напомнить
 * студентам, что двухсвязный список представляет из себя цепочку элементов,
 * которые умеют ссылаться не только на следующий элемент последовательности,
 * но и на предыдущий. Стоит предупредить студентов, что вносить корректировки
 * в уже готовые методы на текущий момент не стоит, их модификацией мы
 * займемся позднее
 */
public class Ex005 {

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
  private Node prev;
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
