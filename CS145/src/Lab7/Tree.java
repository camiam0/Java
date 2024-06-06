package Lab7;

public class Tree<E extends Comparable<E>> {

    private TreeNode<E> root;

    // constructor initializes an empty Tree of integers
    public Tree() {root = null;}

    // insert new node in the binary search tree
    public void insertNode(E insertValue) {

        // create root node
        if (root == null) {root = new TreeNode<E>(insertValue);}

        // call the insert method
        else{root.insert(insertValue);}

    } // end of insertNode

    // begin preorder traversal
    public void preorderTraversal() {preorderHelper(root);}

    // recursive method to preform preorder traversal
    private void preorderHelper(TreeNode<E> node) {

        if (node == null) {return;}

        System.out.printf("%s", node.data); // output node data
        preorderHelper(node.leftNode); // traverse left subtree
        preorderHelper(node.rightNode); // traverse right subtree

    } // end of preorderHelper

    // begin inorder traversal
    public void inorderTraversal() {inorderHelper(root);}

    // recursive method to perform inorder traversal
    private void inorderHelper(TreeNode<E> node) {

        if (node == null) {return;}

        inorderHelper(node.leftNode); // traverse left subtree
        System.out.printf("%s", node.data); // output node data
        inorderHelper(node.rightNode); // traverse right subtree

    } // end of inorderHelper

    // begin postorder traversal
    public void postorderTraversal() {postorderHelper(root);}

    // begin postorder traversal
    public void postorderHelper(TreeNode<E> node) {

        if (node == null) {return;}

        postorderHelper(node.leftNode); // traverse left subtree
        postorderHelper(node.rightNode); // traverse right subtree
        System.out.printf("%s", node.data); // output data

    } // end of postorderHelper

} // end of class