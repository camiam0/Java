package Lab5;

public class ListNode {

    protected String lastName;
    protected String firstName;
    protected String address;
    protected int zipCode;
    protected int phoneNum;
    protected ListNode nextNode;

    public ListNode(String in_LastName, String in_FirstName, String in_Address, int in_ZipCode, int in_PhoneNum, ListNode address_node) {

        this.lastName = in_LastName;
        this.firstName = in_FirstName;
        this.address = in_Address;
        this.zipCode = in_ZipCode;
        this.phoneNum = in_PhoneNum;
        this.nextNode = address_node;

    } // end of Node_List

    // setter methods
    public void setLastName(String up_LastName) {this.lastName = up_LastName;}
    public void setFirstName(String up_FirstName) {this.firstName = up_FirstName;}
    public void setAddress(String up_Address) {this.address = up_Address;}
    public void setZipCode(int up_ZipCode) {this.zipCode = up_ZipCode;}
    public void setPhoneNum(int up_PhoneNum) {this.phoneNum = up_PhoneNum;}
    public void setNextNode(ListNode next_address) {this.nextNode = next_address;}

    // getter methods
    public String getLastName() {return this.lastName;}
    public String getFirstName() {return this.firstName;}
    public String getAddress() {return this.address;}
    public int getZipCode() {return this.zipCode;}
    public int getPhoneNum() {return this.phoneNum;}
    public ListNode getNextNode() {return this.nextNode;}

} // end of ListNode class