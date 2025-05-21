package dsa5;

import java.util.LinkedList;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class HashTable {
    private LinkedList<Node>[] buckets;

    public HashTable(int size) {
        this.buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Fungsi hash menggunakan ASCII karakter pertama % ukuran tabel
    private int hash(String key) {
        return key.charAt(0) % buckets.length;
    }

    // Insert data ke hash table
    public void insert(String data) {
        int index = hash(data);
        Node newNode = new Node(data);
        buckets[index].add(newNode);
        System.out.println("Inserted \"" + data + "\" to bucket " + index);
    }

    // Tampilkan isi hash table
    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Node node : buckets[i]) {
                System.out.print(node.data + " → ");
            }
            System.out.println("null");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        String[] names = {"Andi", "Ingrit", "Dora", "Chris", "Della", "Jeremy", "Jessica", "Bella", "Emma", "Blake"};

        System.out.println("=== INSERT DATA ===");
        for (String name : names) {
            hashTable.insert(name);
        }

        System.out.println("\n=== HASH TABLE CONTENTS ===");
        hashTable.display();
    }
}