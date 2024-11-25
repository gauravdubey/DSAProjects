package dsatopics.linkedlist.doubly;

public class DoublyLinkedListMain {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList= new DoublyLinkedList();
        System.out.println("********* Welcome to Doubly Linked List ***********");
        doublyLinkedList.insertAtStart(10);
        doublyLinkedList.insertAtStart(20);
        doublyLinkedList.insertAtEnd(30);
//        doublyLinkedList.insertAtPosition(40,3);
        doublyLinkedList.insertAtStart(5);
//        doublyLinkedList.insertAtPosition(55,1);
        doublyLinkedList.printListForward();
        System.out.println();
//        doublyLinkedList.deleteFromStart();
//        doublyLinkedList.deleteFromEnd();
//        doublyLinkedList.deleteAtPosition(2);
//        doublyLinkedList.searchNode(40);
        doublyLinkedList.printListBackward();
    }
}
