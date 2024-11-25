package dsatopics.linkedlist.singly;

public class SinglyLinkedlist {

    Node head;

    SinglyLinkedlist() {
        head = null;
    }

    /**
     * Insert node/ element at start
     *
     * @param data
     */
    public void insertAtStart(int data) {
        if (head != null) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } else {
            head = new Node(data);
        }
    }

    /**
     * insert node / element at end
     *
     * @param data
     */
    public void insertAtEnd(int data) {
        if (head != null) {
            Node temp = head;
            Node newNode = new Node(data);
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        } else {
            head = new Node(data);
        }
    }

    /**
     * Insert node/element at given position
     *
     * @param data
     * @param pos
     */
    public void insertAtPosition(int data, int pos) {
        if (head != null) {
            Node temp = head;
            Node newNode = new Node(data);
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            head = new Node(data);
        }
    }

    /**
     * Print the linked list
     */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            if (temp.next != null) {
                System.out.print(temp.data + " => ");
            } else {
                System.out.print(temp.data);
            }
            temp = temp.next;
        }
    }

    /**
     * Delete node at start
     */
    public void deleteAtStart() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("List is empty !!");
        }
    }

    /**
     * Delete the Node at end
     */
    public void deleteAtEnd() {
        if (head != null) {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        } else {
            System.out.println("List is empty !!");
        }
    }

    /**
     * Delete the node at given position
     *
     * @param pos
     */
    public void deleteAtPosition(int pos) {
        if (head != null) {
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        } else {
            System.out.println("List is empty !!");
        }
    }

    /**
     * Search the node in linked list
     *
     * @param data
     */
    public void searchNode(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data){
                System.out.println("Node available is the list");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Node is not available in the list");
    }


}
