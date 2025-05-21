package dsa4;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinarySearchTree {
    private Node root;

    // Metode insert untuk BST
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            return new Node(data); // Jika node kosong, buat node baru
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data); // Insert ke kiri
        } else {
            root.right = insertRecursive(root.right, data); // Insert ke kanan (termasuk duplikat)
        }

        return root;
    }

    // In-order traversal untuk menampilkan data BST secara terurut
    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.data + " ");
            inOrderRecursive(root.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert data sesuai urutan
        int[] data = {15, 17, 12, 4, 17, 9, 2, 20, 21, 27};
        for (int num : data) {
            bst.insert(num);
        }

        // Tampilkan hasil in-order traversal
        System.out.println("In-order traversal (sorted):");
        bst.inOrderTraversal();
    }
}
