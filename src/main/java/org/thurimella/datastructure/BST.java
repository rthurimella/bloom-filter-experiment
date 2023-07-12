package org.thurimella.datastructure;

import org.thurimella.model.Node;

public class BST {
    private Node root;

    public void insert(int x) {
        root = insert(root, x);
    }

    public boolean found(int x) {
        return found(root, x);
    }

    private Node insert(Node node, int x) {
        if (node == null) {
            return new Node(x);
        } else if (x < node.data) {
            node.left = insert(node.left, x);
        } else if (x > node.data) {
            node.right = insert(node.right, x);
        }
        return node;
    }

    private boolean found(Node node, int x) {
        if (node == null) {
            return false;
        } else if (x == node.data) {
            return true;
        } else if (x < node.data) {
            return found(node.left, x);
        } else {
            return found(node.right, x);
        }
    }
}

