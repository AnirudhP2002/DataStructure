
/*
 * Basic implementation of stack using array is created 
 * 
 * Time complexity:
 *      push: O(1)
 *      pop: O(1)
 *      peak: O(1)
 */
import java.util.*;

public class Stack {
    static int top = -1;

    public static void push(int[] stack, int value) {
        if (top == 9)
            System.out.println("OVERFLOW");
        else
            stack[++top] = value;
    }

    public static void pop(int[] stack) {
        if (top == -1)
            System.out.println("UNDERFLOW");
        else
            System.out.println(stack[top--]);
    }

    public static void peak(int[] stack) {
        if (top == -1)
            System.out.println("UNDERFLOW");
        else
            System.out.println(stack[top]);
    }

    public static void display(int[] stack) {
        if (top == -1)
            System.out.println("UNDERFLOW");
        int i = top;
        while (i >= 0)
            System.out.println(stack[i--]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] stack = new int[10];
        while (true) {
            System.out.println("Enter your choice: ");
            System.out.println("1.Push");
            System.out.println("2.Pop");
            System.out.println("3.Peak");
            System.out.println("4.Display");
            System.out.println("5.Exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the value");
                    int value = scan.nextInt();
                    push(stack, value);
                    break;
                }
                case 2: {
                    pop(stack);
                    break;
                }
                case 3: {
                    peak(stack);
                    break;
                }
                case 4: {
                    display(stack);
                    break;
                }
                case 5:
                    System.exit(0);
            }
        }
    }
}
