package org.rvchavda.datastructure_and_alogs.linear;

public class SinglyLinkedList {
    private Node head;
    private int size;

    public SinglyLinkedList(int initVal) {
        head = new Node(initVal);
        size = 1;
    }

    public void push(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void add(int data) {
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = new Node(data);
        size++;
    }

    public Node head() {
        return head;
    }

    public void remove() {

    }

    static class Node {
        private int value;
        private Node next;

        public Node(int data) {
            value = data;
            next = null;
        }

        public Node next() {
            return next;
        }

        public int value() {
            return value;
        }
    }

    @Override
    public String toString() {
        Node n = head;
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.value).append("->");
            n = n.next;
        }
        return sb.toString();
    }
}
