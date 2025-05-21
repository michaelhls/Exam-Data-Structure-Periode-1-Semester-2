package dsa3;

class ArrayQueue {
    private int[] arr;
    private int front = 0, rear = 0;

    public ArrayQueue(int size) {
        arr = new int[size];
    }

    public void enqueue(int data) {
        if (rear < arr.length) {
            arr[rear++] = data;
        } else {
            throw new IllegalStateException("Queue overflow");
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        return arr[front++];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void removeTarget(int target) {
        int[] temp = new int[arr.length];
        int idx = 0;
        while (!isEmpty()) {
            int val = dequeue();
            if (val != target) {
                temp[idx++] = val;
            }
        }
        // Reset front dan rear sebelum enqueue kembali
        front = 0;
        rear = 0;
        for (int i = 0; i < idx; i++) {
            enqueue(temp[i]);
        }
    }

    public void display() {
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}