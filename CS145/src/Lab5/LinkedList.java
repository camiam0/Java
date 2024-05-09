package Lab5;

import java.util.NoSuchElementException;

public class LinkedList {

    private ListNode firstNode;
    private ListNode lastNode;
    private String phonebook;

    public LinkedList(String phoneBookName) {

        this.phonebook = phoneBookName;
        firstNode = lastNode = null;

    } // end of LinkedList constructor

    public void insertAtFront(String in_LastName, String in_FirstName, String in_Address, int in_ZipCode, int in_PhoneNum, ListNode address_node) {

        if(isEmpty()) {firstNode = lastNode = new ListNode(in_LastName, in_FirstName, in_Address, in_ZipCode, in_PhoneNum, address_node);}
        
        else{
            
            ListNode newNode = new ListNode(in_LastName, in_FirstName, in_Address, in_ZipCode, in_PhoneNum, address_node);
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        
        }

    } // end of insertAtFront

    public ListNode removeFromFront() throws NoSuchElementException {

        if(isEmpty()) {throw new NoSuchElementException(phonebook + "is empty");}

        ListNode removedItem = firstNode.getNextNode();

        if(firstNode == lastNode) {firstNode = lastNode = null;}

        else {firstNode = firstNode.nextNode;}

        return removedItem;

    } // end of removeFromFront

    public ListNode removeAtIndex(int index) throws NoSuchElementException {

        if(isEmpty()) {throw new NoSuchElementException(phonebook + "is empty");}

        if(index < 0) {throw new IllegalArgumentException("Index cannot be negative");}

        if(index == 0) {return removeFromFront();} // If index is 0, just remove from the front

        ListNode previous = null;
        ListNode current = firstNode;
        int currentIndex = 0;

        // Traverse the list to find the node at the specified index
        while(current != null && currentIndex < index) {

            previous = current;
            current = current.getNextNode();
            currentIndex++;

        }

        // If index is out of bounds
        if(current == null) {throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");}

        // Remove the node at the specified index
        if(current == lastNode) {lastNode = previous;} // Update lastNode if the last node is being removed

        if(previous != null) {previous.setNextNode(current.getNextNode());} // Bypass the current node
        else {firstNode = current.getNextNode();} // Update firstNode if the first node is being removed

        return current;

    } // end of removeAtIndex

    public boolean isEmpty() {return firstNode == null;}

    public void print() {

        if(isEmpty()) {System.out.printf("Empty %s%n", phonebook); return;}

        System.out.printf("People in the %s: %n", phonebook);
        ListNode current = firstNode;

        while(current != null) {

            System.out.printf("%s %s, %s, %d, %d%n", current.getLastName(), current.getFirstName(), current.getAddress(), current.getZipCode(), current.getPhoneNum());
            current = current.nextNode;

        }

        System.out.println();

    } // end of print

} // end of LinkedList class