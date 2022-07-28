package LinkedList;

public class LinkedList {
    LinkedListNode head;

    public static void main(String[] args) {
        int[] values = { 1, 2, 3, 4 };

        LinkedList linkedList = new LinkedList(values);
        System.out.println(linkedList);
    }

    public LinkedList() { }
    
    public LinkedList(int[] values) {
        LinkedListNode next = null;

        for (int i = values.length - 1; i >= 0; i--) {
            next = new LinkedListNode(values[i], next);
        }

        this.head = next;
    }

    public void add(int value) {
        LinkedListNode tail = this.getLastNode();
        tail.setNext(new LinkedListNode(value));
    }

    public void add(int value, int index) {
        if (index == 0) {
            this.head = new LinkedListNode(value, this.head);

            return;
        }

        LinkedListNode previousNode = this.getNode(index - 1);
        previousNode.setNext(
            new LinkedListNode(value, previousNode.getNext())
        );
    }
    
    public void remove(int value) {
        if (this.head.getValue() == value) {
            this.head = this.head.getNext();
        }

        LinkedListNode previousNode = this.head;

        while (previousNode.getNext() != null) {
            if (previousNode.getNext().getValue() == value) {
                previousNode.setNext(previousNode.getNext().getNext());
            }

            previousNode = previousNode.getNext();
        }
    }

    public LinkedListNode getNode(int index) {
        int currentIndex = 0;
        LinkedListNode currentNode = head;

        while (currentIndex != index) {
            if (currentNode == null) {
                return null;
            }

            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode;
    }

    public LinkedListNode getFirstNode() {
        return this.head;
    }

    public LinkedListNode getLastNode() {
        LinkedListNode currentNode = this.head;

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }
    
    public String toString() {
        LinkedListNode currentNode = head;
        String str = "";

        while (currentNode != null) {
            str += currentNode.getValue();

            if (currentNode.getNext() != null) {
                str += " -> ";
            }

            currentNode = currentNode.getNext();
        }

        return str;
    }
}

class LinkedListNode {
    private int value;
    private LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }

    public LinkedListNode(int value, LinkedListNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return this.value;
    }

    public LinkedListNode getNext() {
        return this.next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}