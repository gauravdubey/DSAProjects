package dsatopics.linkedlist.circular;

public class CircularDoubleLinkedList {
    private Node head;
    private Node tail;

    CircularDoubleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Insert Node at start
     *
     * @param data
     */
    void insertAtStart(int data) {
        if (head != null) {
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            tail.next = head;
            head.prev = tail;
        } else {
            head = new Node(data);
            tail = head;
            tail.next = head;
            head.prev = tail;
        }
    }

    /**
     * Insert Node at End
     *
     * @param data
     */
    void insertAtEnd(int data) {
        if (tail != null) {
            Node newNode = new Node(data);
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        } else {
            head = new Node(data);
            tail = head;
            tail.next = head;
            head.prev = tail;
        }
    }

    /**
     * Delete Node from Start
     */
    void deleteAtStart() {
        if (head != null) {
            if (head.next == head) {
                head = null;
                tail = null;
                System.out.println("Deleted!!");
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                System.out.println("\nDeleted!!");
            }
        } else {
            System.out.println("Circular List is Empty!!");
        }
    }

    /**
     * Delete Node from End
     */
    void deleteAtEnd() {
        if (head != null) {
            if (head.next == head) {
                head = null;
                tail = null;
                System.out.println("Deleted!!");
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                System.out.println("\nDeleted!!");
            }
        } else {
            System.out.println("Circular List is Empty!!");

        }
    }

    /**
     * Print the Circular List forward direction
     */
    void printCircularForward() {
        Node temp = head;
        if (head == null) {
            System.out.println("Circular List is Empty !!");
            return;
        }
        do {
            if (temp.next != head) {
                System.out.print(temp.data + " <=> ");
            } else {
                System.out.print(temp.data);
            }
            temp = temp.next;
        } while (temp != head);
    }

    /**
     * Print the Circular List backward direction
     */
    void printCircularBackward() {
        if (head == null) {
            System.out.println("Circular List is Empty !!");
            return;
        }
        Node temp = tail;
        do {
            if (temp.prev != tail) {
                System.out.print(temp.data + " <=> ");
            } else {
                System.out.print(temp.data);
            }
            temp=temp.prev;
        } while (temp != tail);

    }
}
