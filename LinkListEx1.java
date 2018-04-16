public class LinkListEx1 {
    public static void main(String[] args) {
        // create a node
        Node fiveNode = new Node(5);

        // create a linked list with fiveNode at the head
        LinkedList myLinkedList = new LinkedList(fiveNode);

        // add a node with the value 4
        myLinkedList.addNode(4);
        System.out.println(fiveNode.getNext().getValue());

        // get count of linked list, should be 2
        System.out.println(myLinkedList.getCount());

        // remove node, print count of linked list should be 1 and nextnode for fiveNode should be null
        myLinkedList.removeNode();
        System.out.println(myLinkedList.getCount());
        System.out.println(fiveNode.getNext());

        // add a node of value 8, get the second element from linked list--should be 8
        myLinkedList.addNode(8);
        System.out.println(myLinkedList.get(2));

    }
}

class Node {
    int value;
    Node next;
    public Node(int value){
        this.value = value;
        next = null;
    }
    public Node(int value, Node next){
        this.value = value;
        next = next;
    }
    public int getValue(){
        return this.value;
    }
    public Node getNext(){
        return this.next;
    }
    public void setValue(int value){
        this.value = value;
    }
    public void setNext(Node next){
        this.next = next;
    }
}

// = = = = = = =
class LinkedList {
    // properties
    Node head;
    int count;

    // constructors
    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    public LinkedList (Node head){
        this.head = head;
        this.count = 1;
    }

    // ** Methods * *
    //public void addNode(int value) {}
    // public void removeNode() {}
    // public int getCount() {}
    // public Boolean isEmpty() {}
    // public int get(int nodeNum) {}

    //= = addNode = = =
    public void addNode(int value) {
        Node current = head;
        Node temp = new Node(value);

        if(current == null){
            this.head = temp;
            count+=1;
            return;
        }

        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(temp);
        count += 1;
    }

    //= = = removeNode = =
    public void removeNode() {
        Node current = head;

        if(current == null) {
            System.out.println("no Nodes to remove, empty Linked List");
            return;
        }

        else if(getCount() == 1) {
            System.out.println("only one Node in Linked List, deleting Node");
            this.head = null;
            count--;
            return;
        }

        while(current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
        count--;
    }

    //= = =getCount & isEmpty = = =
    public int getCount() {
        return this.count;
    }

    public Boolean isEmpty() {
        return getCount() == 0;
    }

    //= = = get(int nodeNum) = = =
    public int get(int nodeNum) {
        if (nodeNum <= 0) {
            return -1;
        }
        Node current = head;
        for(int i = 1; i < nodeNum; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }
}
