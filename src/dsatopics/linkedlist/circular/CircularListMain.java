package dsatopics.linkedlist.circular;

public class CircularListMain {

    public static void main(String[] args) {
        System.out.println("********* Welcome to Circular Linked List ***********");
        CircularDoubleLinkedList circularDoubleLinkedList=new CircularDoubleLinkedList();
        circularDoubleLinkedList.insertAtStart(10);
        circularDoubleLinkedList.insertAtStart(20);
        circularDoubleLinkedList.insertAtEnd(30);
        circularDoubleLinkedList.insertAtEnd(40);
        circularDoubleLinkedList.printCircularForward();
        circularDoubleLinkedList.deleteAtEnd();
        circularDoubleLinkedList.printCircularForward();
    }
}
