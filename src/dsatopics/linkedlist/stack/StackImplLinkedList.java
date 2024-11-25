package dsatopics.linkedlist.stack;

public class StackImplLinkedList {
    Node top;

    StackImplLinkedList() {
        this.top = null;
    }

    //Push
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    // Pop

    public int pop() {
        if (isStackEmpty()) {
            System.out.println("Stack is Empty!!");
            return -1;
        } else {
            int data = top.data;
            top = top.next;
            return data;
        }
    }

    // Empty
    public boolean isStackEmpty() {
        return top == null;
    }

    // Peek
    public int peek() {
        if (isStackEmpty()) {
            System.out.println("Stack is Empty!!");
            return -1;
        } else {
            System.out.println("Peek Element is: "+top.data);
            return top.data;
        }
    }

    // Display
    public void display() {
        if (isStackEmpty()) {
            System.out.println("Stack is Empty!!");
            return;
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.println("| "+temp.data+ " |");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
