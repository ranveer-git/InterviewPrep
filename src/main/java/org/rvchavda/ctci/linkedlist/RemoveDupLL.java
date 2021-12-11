package org.rvchavda.ctci.linkedlist;

import org.rvchavda.datastructure_and_alogs.linear.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupLL {
    public SinglyLinkedList removeDuplicate(SinglyLinkedList sll) {
        Set<Integer> bufSet = new HashSet<>();
        return null;
    }

    public static void main(String[] args) {
        try {
            SinglyLinkedList sll = new SinglyLinkedList(1);
            sll.add(2);
            sll.add(4);
            sll.add(3);
            sll.add(4);
            sll.push(10);

            System.out.println(sll);
            RemoveDupLL rem = new RemoveDupLL();
            System.out.println(rem.removeDuplicate(sll));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
