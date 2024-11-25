package dsatopics.linkedlist.linkedlistprogramms;


public class LinkedListSamples {

    public static void main(String[] args) {
        int[] arr = {10, 10, 20, 30, 30};
        LinkedListProgramms linkedList = new LinkedListProgramms();
        linkedList.insertAtEnd(arr[0]);
        linkedList.insertAtEnd(arr[1]);
        linkedList.insertAtEnd(arr[2]);
        linkedList.insertAtEnd(arr[3]);
        linkedList.insertAtEnd(arr[4]);
//        linkedList.insertAtPosition(arr[4], 2);
        linkedList.traverseList();
        linkedList.removeDuplicateCompletely();

//        linkedList.deleteAtPosition(2);
        linkedList.traverseList();
    }
}

