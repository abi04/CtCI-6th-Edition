package Q2_01_Remove_Dups;

import java.util.HashSet;
import CtCILibrary.LinkedListNode;

public class QuestionA {
  public static void deleteDups(LinkedListNode n) {
    HashSet<Integer> set = new HashSet<Integer>();
    LinkedListNode previous = null;
    while (n != null) {
      if (set.contains(n.data)) {
        previous.next = n.next;
      } else {
        set.add(n.data);
        previous = n;
      }
      n = n.next;
    }
  }

  public static void myDeleteDups(LinkedListNode n) {
    LinkedListNode head = n;
    HashSet<Integer> set = new HashSet<>();
    while (head != null) {
      if (!set.contains(head.data)) {
        set.add(head.data);
      } else {
      	head.data = head.next.data;
      	head.next = head.next != null ? head.next.next : null;
      }

      head = head.next;
    }
  }

  public static void main(String[] args) {
    LinkedListNode first =
        new LinkedListNode(0, null, null); // AssortedMethods.randomLinkedList(1000, 0, 2);
    LinkedListNode head = first;
    LinkedListNode second = first;
    for (int i = 1; i < 8; i++) {
      second = new LinkedListNode(i % 2, null, null);
      first.setNext(second);
      second.setPrevious(first);
      first = second;
    }
    System.out.println(head.printForward());
    myDeleteDups(head);
    System.out.println(head.printForward());
  }
}
