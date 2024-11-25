package dsatopics.linkedlist.linkedlistprogramms;

/**
 * Linked List Class
 */
class LinkedListProgramms {
    Node head;

    LinkedListProgramms() {
        head = null;
    }

    /**
     * Insert the element at start
     *
     * @param data
     */
    void insertAtStart(int data) {
        if (head != null) {
            Node currentNode = new Node(data);
            currentNode.next = head;
            head = currentNode;
        } else {
            head = new Node(data);
        }
    }

    /**
     * Insert the element at end
     *
     * @param data
     */
    void insertAtEnd(int data) {
        if (head != null) {
            Node currentNode = new Node(data);
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = currentNode;
        } else {
            head = new Node(data);
        }
    }

    /**
     * Insert the element at position
     *
     * @param data
     * @param position
     */
    void insertAtPosition(int data, int position) {
        if (head != null) {
            Node currentNode = new Node(data);
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            currentNode.next = temp.next;
            temp.next = currentNode;
        } else {
            head = new Node(data);
        }
    }

    /**
     * Traverse the list
     */
    void traverseList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null \n");
    }

    /**
     * Delete the node at End
     */
    void deleteNodeAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            if (head.next == null) {
                head = null;
                System.out.println("The last node has been deleted, list is now empty.");
                return;
            } else {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        }
    }

    void deleteNodeAtStart() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            head = head.next;
        }
    }

    void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            System.out.println("The node at position " + position + " has been deleted.");
        }
    }

    /**
     * Remove duplicate elements from sorted linked list
     *
     * @return
     */
    void removeDuplicates() {
        // Your code here
        if (head == null) {
            return;
        }
        Node current = head;
        while (current.next != null) {
            // Compare the current node with the next node
            if (current.data == current.next.data) {
                // Skip the next node since it's a duplicate
                current.next = current.next.next;
            } else {
                // Move to the next node if there's no duplicate
                current = current.next;
            }
        }
    }

    /**
     * Remove duplicate elements from sorted linked list
     * Note : its not completed as of now
     */
    void removeDuplicateCompletely() {
        // Your code here
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current.next != null) {
            // Compare the current node with the next node
            if (current.data == current.next.data) {
                // Skip the next node since it's a duplicate
                current = current.next.next;
            } else {
                // Move to the next node if there's no duplicate
                current = current.next;
            }
        }

    }

    /**
     * Merge two sorted linked list
     *
     * @param head1
     * @param head2
     */
    Node mergeTwoSortedList(Node head1, Node head2) {
        Node head = new Node(0);
        Node tail = head;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return head.next;
    }
}
