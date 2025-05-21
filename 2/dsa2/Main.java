package dsa2;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    // (a) Insert semua angka ke linked list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // (b) Insert 32 setelah angka 30
    public void insertAfter(int target, int newData) {
        Node current = head;
        while (current != null) {
            if (current.data == target) {
                Node newNode = new Node(newData);
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    // (c) Delete angka 42
    public void delete(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Tampilkan isi linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] numbers = {100, 12, 70, 24, 40, 36, 16, 35, 14, 30, 25, 43, 5, 9, 42, 6, 11, 41, 7, 13};

        // (a) Insert semua angka
        for (int num : numbers) {
            list.insert(num);
        }
        System.out.println("Setelah insert semua angka:");
        list.display();

        // (b) Insert 32 setelah 30
        list.insertAfter(30, 32);
        System.out.println("Setelah insert 32 setelah 30:");
        list.display();

        // (c) Delete 42
        list.delete(42);
        System.out.println("Setelah delete 42:");
        list.display();
    }
}