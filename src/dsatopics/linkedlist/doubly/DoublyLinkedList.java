package dsatopics.linkedlist.doubly;

public class DoublyLinkedList {

    Node head;
    Node tail;
    DoublyLinkedList(){
        head=null;
        tail=null;
    }

    /**
     * Insert node/element at start
     * @param data
     */
    void insertAtStart(int data){
        if(head!=null){
            Node newNode=new Node(data);
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }else{
            head=new Node(data);
            tail=head;
        }
    }

    /**
     * Insert node/element at end
     * @param data
     */
     void insertAtEnd(int data){
        if(head!=null){
            Node newNode=new Node(data);
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }else{
            head=new Node(data);
            tail=head;
        }
    }

    /**
     * Insert node/element at given position
     * @param data
     * @param pos
     */
     void insertAtPosition(int data, int pos){
         Node newNode = new Node(data);
         // Case 1: Insert at first position
         if (pos==1 || pos==0){
             newNode.next=head;
             if(head!=null){
                head.prev=newNode;
             }
             head=newNode;
             tail=head;
             return;
         }

         // Case 2: Traverse to the node at (position - 1)
         Node temp=head;
         int count=1;

         while (temp!=null && count<pos-1){
             temp=temp.next;
             count++;
         }
         // If the position is out of bounds (temp is null), insert at the end
        if (temp==null){
            System.out.println("Position is out of bounds. Inserting at the end.");
            insertAtEnd(data);
            return;
        }
        // Case 3: Insert in the middle or at the end of the list
         newNode.next=temp.next;
        if (temp.next!=null){
            temp.next.prev=newNode;
        }
         temp.next=newNode;
         newNode.prev=temp;
    }

    /**
     * Print the linked list
     */
     void printListForward(){
        Node temp=head;
        while(temp!=null){
            if(temp.next!=null){
                System.out.print(temp.data+" <=> ");
            }else{
                System.out.print(temp.data);
            }
            temp=temp.next;
        }
    }

    /**
     * Print the list backward direction
     */
    void printListBackward(){
         Node temp=tail;
         while(temp!=null){
             if (temp.prev!=null){
                 System.out.print(temp.data+" <=> ");
             }else {
                 System.out.print(temp.data);
             }
             temp=temp.prev;
         }
    }

    /**
     * Delete Node from Start
     */
    void deleteFromStart(){
         if (head!=null){
             if(head.next==null){
                 head=null;
                 tail=null;
                 System.out.println(" Deleted!!");
                 return;
             }else {
                 head=head.next;
                 head.prev=null;
                 System.out.println(" Deleted!!");
             }
         }else {
             System.out.println("Doubly LinkedList is Empty!!");
         }
    }

    /**
     * Delete Node from End
     */
    void deleteFromEnd(){
        if(head!=null){
            if(head.next==null){
                head=null;
                tail=null;
                System.out.println(" Deleted!!");
                return;
            }else{
                tail=tail.prev;
                tail.next=null;
                System.out.println(" Deleted!!");
            }
        }else {
            System.out.println("Doubly LinkedList is Empty!!");
        }
    }

    /**
     * Delete Node from given position
     * @param pos
     */
    void deleteAtPosition(int pos){
        if(head!=null){
            Node temp=head;
            //case 1- Delete at start
            if (pos==0 || pos==1){
                if(head.next==null){
                    head=null;
                    tail=null;
                    System.out.println(" Deleted!!");
                    return;
                }else {
                    head=head.next;
                    head.prev=null;
                    System.out.println(" Deleted!!");
                }
            }else{
                for (int i = 1; i <pos-1 ; i++) {
                    temp=temp.next;
                }
                //case 2- Delete at end
                if(temp.next.next==null){
                    tail=temp;
                    tail.next=null;
                }else {
                    // case 3 - Delete at position
                    temp.next=temp.next.next;
                    temp.next.prev=temp;
                    System.out.println(" Deleted!!");
                }
            }
        }else {
            System.out.println("Doubly LinkedList is Empty!!");
        }
    }

    /**
     * Search the node in linked list
     * @param data
     */
    void searchNode(int data){
        Node temp=head;
        while(temp!=null){
            if(temp.data==data){
                System.out.println("Node "+data+" available in the list");
                return;
            }else{
                temp=temp.next;
            }
        }
        System.out.println("Node "+data+" is not available in the list");
    }
}
