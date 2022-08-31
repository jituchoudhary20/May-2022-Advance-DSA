/*
Leetcode Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

package Tree.BinaryTree.Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class InorderTraversal {
    Node rootNode;

    static class Node {
        Node leftChild;
        int data;
        Node rightChild;

        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    private void insertNode(int data) {
        Node newNode = new Node(data);

        //first node of the tree
        if(rootNode == null) {
            rootNode = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);

        Node temp;
        while(!queue.isEmpty()) {
            temp = queue.poll();

            if(temp.leftChild == null) {
                temp.leftChild = newNode;
                break;
            }
            else {
                queue.add(temp.leftChild);
            }

            if(temp.rightChild == null) {
                temp.rightChild = newNode;
                break;
            }
            else {
                queue.add(temp.rightChild);
            }
        }
    }

    private void printInorder(Node currentRootNode) {
        if(currentRootNode != null) {
            printInorder(currentRootNode.leftChild);
            System.out.print(currentRootNode.data + " ");
            printInorder(currentRootNode.rightChild);
        }
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal
                = new InorderTraversal();

        for(int i = 0; i < 10; i++) {
            int randomNumber = (int)(Math.random() * 100); //range -> 0 to 99

            System.out.println("Inserting " + randomNumber + " in the tree...");
            inorderTraversal.insertNode(randomNumber);
        }

        System.out.println();
        System.out.println("Inorder: ");
        inorderTraversal.printInorder(inorderTraversal.rootNode);
        System.out.println();
    }
}
