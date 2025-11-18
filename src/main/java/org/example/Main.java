package org.example;

import javafx.application.Application;


public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int[] nums = {41, 12, 45, 30, 43, 85, 15, 71, 27, 62};
        for (int num : nums) {
            tree.insert(num);
        }

        System.out.print("PreOrder:\t");
        tree.preOrder();
        System.out.print("InOrder:\t");
        tree.inOrder();
        System.out.print("PostOrder:\t");
        tree.postOrder();


        tree.delete(90);
        tree.delete(63);
        tree.delete(12);

        System.out.print("PreOrder:\t");
        tree.preOrder();
        System.out.print("InOrder:\t");
        tree.inOrder();
        System.out.print("PostOrder:\t");
        tree.postOrder();

    }
}