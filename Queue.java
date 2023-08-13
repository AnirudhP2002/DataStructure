
/*
 * Basic implementation of queue using array is created 
 * 
 * Time complexity:
 *      Enqueue: O(1)
 *      Dequeue: O(1)
 */
import java.util.Scanner;

public class Queue {
    int front = -1, rear = -1;
    int[] array = new int[5];

    public void Enqueue() {
        if (rear == 4)
            System.out.print("queue is full");
        else {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the element: ");
            int element = scan.nextInt();
            if (rear == -1)
                front++;

            array[++rear] = element;
        }
    }

    public void Dequeue() {
        if (front == -1)
            System.out.print("queue is empty");
        else {

            System.out.println(array[front]);
            if (front == rear) {
                front = -1;
                rear = -1;
            } else
                front++;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int range = 5;
        Queue q = new Queue();
        while (true) {
            System.out.println("Enter your choice:\n1.Enqueue\n2.Dequeue\n3.Exit\n");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {

                    q.Enqueue();
                    break;
                }
                case 2: {
                    q.Dequeue();
                    break;
                }
                case 3: {
                    System.exit(0);
                }
            }
        }
    }
}
