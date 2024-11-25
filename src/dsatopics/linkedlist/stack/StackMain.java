package dsatopics.linkedlist.stack;

public class StackMain {

    public static void main(String[] args) {
        System.out.println("********* Welcome to Stack ***********");
        System.out.println("********** Stack Implementation using Linked List **********");
        StackImplLinkedList stackImplLinkedList=new StackImplLinkedList();
        stackImplLinkedList.push(10);
        stackImplLinkedList.push(20);
        stackImplLinkedList.push(30);
        stackImplLinkedList.push(40);
        stackImplLinkedList.display();
        stackImplLinkedList.pop();
        stackImplLinkedList.pop();
        stackImplLinkedList.pop();
        stackImplLinkedList.display();
    }
}
