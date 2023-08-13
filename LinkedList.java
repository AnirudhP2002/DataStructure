
/*
 * This is a linked list functionality where it creates a linked list and insert the node at the begining or end or at any required positon
 * It also deletes the node which is specified by the user 
 * Displays the linked list
 * 
 * 
 * Time Complexity:
 *      ->insert at begining or end {O(1)}
 *      ->insert at any position or delete or displaying {O(n)}
 */

import java.util.*;

class LinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public static void insertAtBegining(LinkedList t, int value) {
        Node newNode = new Node(value);
        if (t.head == null) {
            t.head = t.tail = newNode;
        } else {
            newNode.next = t.head;
            t.head = newNode;
        }
    }

    public static void insertAtEnd(LinkedList t, int value) {
        Node newNode = new Node(value);
        if (t.head == null) {
            t.head = t.tail = newNode;
        } else {
            t.tail.next = newNode;
            t.tail = newNode;
        }
    }

    public static void insertAfterPosition(LinkedList t, int value, int position) {
        Node newNode = new Node(value);
        if (t.head == null) {
            t.head = t.tail = newNode;
        } else {
            Node tt = t.head;
            for (int i = 0; i < position - 1; i++)
                tt = tt.next;
            newNode.next = tt.next;
            tt.next = newNode;
        }

    }

    public static void display(LinkedList node) {
        if (node.head == null)
            System.out.println("List is empty");
        Node temp = node.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void delete(LinkedList node, int value) {
        if (node.head == null)
            System.out.print("List is empty");
        else if (node.head.data == value)
            node.head = node.head.next;
        else {
            Node previous = node.head;
            Node current = node.head;
            while (current != null) {
                if (current.data == value) {
                    previous.next = current.next;
                    break;
                }
                previous = current;
                current = current.next;

            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList LL = new LinkedList();
        while (true) {
            System.out.println(
                    "\n\nEnter your choice:\n1.Insert At Begining\n2.Insert At End\n3.Insert After A Position\n4.Delete\n5.Display\n6.Exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the value: ");
                    int value = scan.nextInt();
                    insertAtBegining(LL, value);
                    break;
                }
                case 2: {
                    System.out.println("Enter the value: ");
                    int value = scan.nextInt();
                    insertAtEnd(LL, value);
                    break;
                }
                case 3: {
                    System.out.println("Enter the value: ");
                    int value = scan.nextInt();
                    System.out.println("Ent er the  position: ");
                    int position = scan.nextInt();
                    insertAfterPosition(LL, value, position);
                }

                case 4: {
                    System.out.println("Enter the value: ");
                    int value = scan.nextInt();
                    delete(LL, value);
                    break;
                }
                case 5: {
                    display(LL);
                    break;

                }
                case 6: {
                    System.exit(0);
                }

            }
        }
        //scan.close();
    }
}
