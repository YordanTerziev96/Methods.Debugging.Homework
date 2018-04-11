package Abstraction;

public class MyLinkedList {

    private static Node head;
    private static int size;

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList(10);
        list.addAtHead(5);
        list.addAtTail(15);
        list.addAtIndex(1, 555);
        list.addAtTail(28);
        list.addAtTail(67);
        list.removeAtIndex(2);
        System.out.println(list.find((Object) 28));
        System.out.println(list.find(3));
        System.out.println(list.getSize());
        printList();



    }

    public MyLinkedList(Object dat){
        head = new Node(dat);
        size++;
    }

    public void addAtHead(Object dat){
        if(size == 0){
            head = new Node(dat);
        }
        else {
            Node temp = head;
            head = new Node(dat);
            head.next = temp;

        }
        size++;
    }

    public void addAtTail(Object dat){

        Node temp = head;
        if(size == 0){
            head = new Node(dat);
        }
        else {
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(dat);

        }
        size++;
    }

    public void addAtIndex(int index, Object dat){

        Node temp = head;
        Node holder;

        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(index == 0){
            holder = head;
            head = new Node(dat);
            temp.next = holder;
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            holder = temp.next;
            temp.next = new Node(dat);
            temp.next.next = holder;
        }

        size++;

    }

    public void removeAtIndex(int index){
        Node temp = head;
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(index == 0){
            head = temp.next;
        }
        else if(index == size - 1){
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = null;

        }
        else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;

        }
        size--;
    }

    public int find(Object dat){
        Node t = head;
        int index = 0;
        while (t.data != dat){

            if(t.next == null){
                System.out.println("There is no such node in collection");
            }
            else {
                index++;
                t = t.next;
            }

        }
        return index;
    }

    public Object find(int index){
        Node temp = head;
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("Invalid index");
        }

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public static void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int getSize(){
        return size;
    }


    class Node{
        private Node next;
        private Object data;

        public Node(Object dat){
            data = dat;
        }

        public Object getData(){
            return data;
        }
    }
}
