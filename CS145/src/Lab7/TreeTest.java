package Lab7;

import java.security.SecureRandom;

public class TreeTest {

    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<Integer>();
        SecureRandom randomNumber = new SecureRandom();
        System.out.println("Insterting the following values: ");

        // insert 10 random integers from 0-99 in tree
        for (int i = 1; i <= 10; i++) {

            int value = randomNumber.nextInt(100);
            System.out.printf("%d", value);
            tree.insertNode(value);

        } // end of for loop

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();
        System.out.println();

    } // end of main

} // end of class