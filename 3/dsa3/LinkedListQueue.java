package dsa3;

import dsa3.Node;

class LinkedListQueue {
    private Node front, rear;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue underflow");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void removeTarget(int target) {
        if (front == null) return;

        // Remove from head
        while (front != null && front.data == target) {
            front = front.next;
        }

        Node current = front;
        while (current != null && current.next != null) {
            if (current.next.data == target) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        rear = current;
    }

    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}