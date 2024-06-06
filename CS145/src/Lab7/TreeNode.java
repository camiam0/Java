package Lab7;

public class TreeNode<E extends Comparable<E>> {

    // package access members
    TreeNode<E> leftNode;
    E data; // node value
    TreeNode<E> rightNode;

    // constructor initializes data and makes this a leaf node
    public TreeNode(E nodeData) {

        data = nodeData;
        leftNode = rightNode = null; // node has no children

    } // end of TreeNode

    // locate insertion point and insert new node; ignore duplicate values
    public void insert(E insertValue) {

        // insert in left subtree
        if (insertValue.compareTo(data) > 0) {

            // insert new TreeNode
            if (leftNode == null){leftNode = new TreeNode<E>(insertValue);}

            // continue traversing right subtree recursively
            else {leftNode.insert(insertValue);}

        } // end of ifs for left subtree

        // insert in right subtree
        else if (insertValue.compareTo(data) > 0) {

            // insert new TreeNode
            if (rightNode == null) {rightNode = new TreeNode<E>(insertValue);}

            //continue traversing right subtree recursively
            else {rightNode.insert(insertValue);}

        } // end of ifs for right subtree

    } // end of insert

} // end of class