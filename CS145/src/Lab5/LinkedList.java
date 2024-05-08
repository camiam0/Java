package Lab5;

public class LinkedList {

    listNode first;

    public void addNodeLast(String data) {

        listNode node = new listNode();
        node.data = data;
        node.next = null;

        if (first == null) first = node;

        else { // traverse the LinkedList

            listNode n = first;

            while (n.next != null) n = n.next;

            n.next = node; // adds new node at the end of the list

        }

    } // end of addNodeLast

    public void addNodeAt(int index, String data) { // adds node at specified index

        listNode node = new listNode();
        node.data = data;
        node.next = null;

        listNode n = first;

        if(index == 0) addNodeFirst(data); // if index is 0 (start) calls addNodeFirst

        else for(int i = 0; i < index-1; i++) n = n.next; // otherwise traverse list to specified index

        node.next = n.next;
        n.next = node;

    } // end of addNodeAt

    public void addNodeFirst(String data) {

        listNode node = new listNode();
        node.data = data;
        node.next = null;
        node.next = first;
        first = node;

    } // end of addNodeFirst

    public void deleteNodeAt(int index) {

        listNode n = first;
        listNode n1 = null;

        if(index == 0) first = first.next; // if index is 0 (start) changes first object to next object

        else for(int i = 0; i < index-1; i++) n = n.next; // otherwise traverse the list

        n1 = n.next;
        n.next = n1.next; // removes object from list

        n1 = null; // deletes removed object

    } // end of deleteNodeAt

    public void showData() { // prints LinkedList objects

        listNode node = first;

        while (node.next != null) {

            System.out.println(node.data);
            node = node.next;

        }

        System.out.println(node.data); // prints last "null" node

    } // end of showData

} // end of LinkedList class
