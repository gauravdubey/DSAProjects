package dsatopics.linkedlist.singly;

import java.util.Scanner;

public class SinglyListMainClass {

    private static void printMainMenu() {
        System.out.println("\n********* Main Menu ***********");
        System.out.println("ENTER 1 TO INSERT");
        System.out.println("ENTER 2 TO DELETE");
        System.out.println("ENTER 3 TO SEARCH");
        System.out.println("ENTER 4 TO DISPLAY");
        System.out.println("ENTER 5 TO EXIT");
        System.out.println("********************************");
        System.out.println("ENTER YOUR CHOICE : ");
    }

    private static void printMenuInsert() {
        System.out.println("********* Insert Menu ***********");
        System.out.println("ENTER 1 TO INSERT AT START");
        System.out.println("ENTER 2 TO INSERT AT END");
        System.out.println("ENTER 3 TO INSERT AT GIVEN POSITION");
    }

    private static void printMenuDelete() {
        System.out.println("********* Delete Menu ***********");
        System.out.println("ENTER 1 TO DELETE AT START");
        System.out.println("ENTER 2 TO DELETE AT END");
        System.out.println("ENTER 3 TO DELETE AT GIVEN POSITION");
    }

    public static void main(String[] args) {

        System.out.println("********** Welcome to Singly Linked List ***********");
        SinglyLinkedlist singlyLinkedlist = new SinglyLinkedlist();
        Scanner scanner = new Scanner(System.in);
        while (true) {


            try {
                printMainMenu();
                int choice = scanner.nextInt();
                if (choice == 1) {
                    insertIntoLinkedList(singlyLinkedlist);

                } else if (choice == 2) {
                    deteleFromLinkedList(singlyLinkedlist);

                } else if (choice == 3) {
                    System.out.println("Enter the data to search : ");
                    int data = scanner.nextInt();
                    singlyLinkedlist.searchNode(data);

                } else if (choice == 4) {
                    singlyLinkedlist.printList();

                } else if (choice == 5) {
                    System.out.println("Thank you !!");
                    break;
                } else {
                    System.out.println("Invalid choice !!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Delete from linked list
     *
     * @param singlyLinkedlist
     */
    private static void deteleFromLinkedList(SinglyLinkedlist singlyLinkedlist) {
        printMenuDelete();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            singlyLinkedlist.deleteAtStart();
            System.out.println("Deleted!!");
        } else if (choice == 2) {
            singlyLinkedlist.deleteAtEnd();
            System.out.println("Deleted!!");
        } else if (choice == 3) {
            System.out.println("Enter the position : ");
            int pos = scanner.nextInt();
            singlyLinkedlist.deleteAtPosition(pos);
            System.out.println("Deleted!!");
        } else {
            System.out.println("Invalid choice !!");
        }
    }

    /**
     * Insert into linked list
     *
     * @param singlyLinkedlist
     */
    private static void insertIntoLinkedList(SinglyLinkedlist singlyLinkedlist) {
        printMenuInsert();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Enter the data to insert at start : ");
            int data = scanner.nextInt();
            singlyLinkedlist.insertAtStart(data);
            System.out.println("Success!!");
        } else if (choice == 2) {
            System.out.println("Enter the data to insert at end : ");
            int data = scanner.nextInt();
            singlyLinkedlist.insertAtEnd(data);
            System.out.println("Success!!");
        } else if (choice == 3) {
            System.out.println("Enter the data to insert at given position : ");
            int data = scanner.nextInt();
            System.out.println("Enter the position : ");
            int pos = scanner.nextInt();
            singlyLinkedlist.insertAtPosition(data, pos);
        } else {
            System.out.println("Invalid choice !!");
        }
    }
}
