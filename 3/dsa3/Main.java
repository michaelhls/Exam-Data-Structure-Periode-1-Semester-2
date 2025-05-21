package dsa3;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {39, 88, 102, 64, 128, 113, 124, 248, 46, 39, 92, 117, 184, 351, 52, 60, 104, 77, 208, 94};

        // Array Queue
        System.out.println("Array Queue:");
        ArrayQueue arrayQueue = new ArrayQueue(numbers.length);
        for (int num : numbers) {
            arrayQueue.enqueue(num);
        }
        System.out.println("Sebelum penghapusan:");
        arrayQueue.display();
        arrayQueue.removeTarget(92);
        System.out.println("Setelah penghapusan:");
        arrayQueue.display();

        // Linked List Queue

        System.out.println("\nLinked List Queue:");
        LinkedListQueue linkedQueue = new LinkedListQueue();
        for (int num : numbers) {
            linkedQueue.enqueue(num);
        }
        System.out.println("Sebelum penghapusan:");
        linkedQueue.display();
        linkedQueue.removeTarget(92);
        System.out.println("Setelah penghapusan:");
        linkedQueue.display();
    }
}