/*
 * This is a Binary Search Tree functionality:
 *  1. insertion operation:
 *       if there is no tree created then the 1st element will be the root node. Other nodes will be created and it will be inserted to left of   its desired parent node if the created node is less than its desired parent or to the right if its greater than its desired parent
 * 
 *   2. traversal operation:
 *      PreOrder =  root  left  right
 *      InOrder =  left  root  right 
 *      PostOrder =  left  right  root
 *      LevelOrder =  The elements will printed based on its level i.e level 0 to level maxDepthOfBinaryTree
 * 
 *   3. deletion operation:
 *      if the desired element is not in the BST then null value is returned
 *      if the desired element is found
 *              if the element has only 1 child or 0 child then it would either return its left child or the right child
 *              if the element has 2 children then the desired element will be replaced by the smallest element of its right sub tree
 * 
 * 
 * 
 * Time Complexity:
 *      insertion: O(log n)         worst case: O(n)
 *      traversal: O(n)
 *      deletion: O(log n)          worst case: O(n)
 */

import java.util.*;

public class BinarySearchTree {
    static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        public Node(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    Node root;
    public static ArrayList<ArrayList<Integer>> al = new ArrayList<>();

    public static Node insert(Node tree, int data) {

        if (tree == null) {
            Node newNode = new Node(data);
            return newNode;
        } else {
            if (data < tree.data)
                tree.leftNode = insert(tree.leftNode, data);
            else
                tree.rightNode = insert(tree.rightNode, data);
        }
        return tree;
    }

    public static void preOrder(Node tree) {
        if (tree == null)
            return;
        System.out.println(tree.data);
        preOrder(tree.leftNode);
        preOrder(tree.rightNode);
    }

    public static void inOrder(Node tree) {
        if (tree == null)
            return;
        inOrder(tree.leftNode);
        System.out.println(tree.data);
        inOrder(tree.rightNode);
    }

    public static void postOrder(Node tree) {
        if (tree == null)
            return;
        postOrder(tree.leftNode);
        postOrder(tree.rightNode);
        System.out.println(tree.data);
    }

    public static void levelOrder(Node tree, int lvl) {
        if (tree == null)
            return;
        if (al.size() == lvl) {
            ArrayList<Integer> b = new ArrayList<>();
            b.add(tree.data);
            al.add(b);
        } else {
            al.get(lvl).add(tree.data);
        }
        levelOrder(tree.leftNode, lvl + 1);
        levelOrder(tree.rightNode, lvl + 1);

    }

    public static Node delete(Node tree, int value) {
        if (tree == null)
            return tree;
        if (value < tree.data) {
            tree.leftNode = delete(tree.leftNode, value);
            return tree;
        } else if (value > tree.data) {
            tree.rightNode = delete(tree.rightNode, value);
            return tree;
        }

        // with 1 or 0 child
        if (tree.leftNode == null)
            return tree.rightNode;
        if (tree.rightNode == null)
            return tree.leftNode;

        // with 2 child
        else {
            Node succParentNode = tree;
            Node succNode = tree.rightNode;
            while (succNode.leftNode != null) {
                succParentNode = succNode;
                succNode = succNode.leftNode;
            }
            if (succParentNode != tree)
                succParentNode.leftNode = succNode.rightNode;
            else
                succParentNode.rightNode = succNode.rightNode;
            tree.data = succNode.data;
            return tree;
        }

    }

    public static void main(String[] args) {
        // Scanner scan=new Scanner(System.in);
        BinarySearchTree BST = new BinarySearchTree();
        BST.root = insert(BST.root, 4);
        BST.root = insert(BST.root, 2);
        BST.root = insert(BST.root, 1);
        BST.root = insert(BST.root, 3);
        BST.root = insert(BST.root, 6);
        BST.root = insert(BST.root, 5);
        BST.root = insert(BST.root, 7);

        preOrder(BST.root);
        System.out.println();
        inOrder(BST.root);
        System.out.println();
        postOrder(BST.root);
        System.out.println();
        levelOrder(BST.root, 0);
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).size(); j++)
                System.out.println(al.get(i).get(j));
        }
        System.out.println();

        int value = 4;// scan.nextInt();
        BST.root = delete(BST.root, value);
        inOrder(BST.root);
    }
}
