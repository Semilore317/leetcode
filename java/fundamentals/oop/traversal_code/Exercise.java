package fundamentals.oop.traversal_code;

import fundamentals.linked_lists.Node;

public class Exercise {

    private Node root;

    public static class Node {
        String data;
        Node left, right;
        public Node(String data) {
            this.data = data;
            left = right = null;
        }
    }

    // Method to set the root
    public void setRoot(Node root) {
        this.root = root;
    }

    // public wrapper
    public void postorder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (root == null) return;
        postOrder(node.left);
        postOrder(node.right);
    }

    public static void main(String[] args) {
        // model the actual tree
        //      X
        //     / \
        //    Y   Z
        //   /    /
        //  A     B
        Exercise obj = new Exercise();

        Node root = new Node("X");
        root.left = new Node("Y");
        root.right = new Node("Z");
        root.left.left = new Node("A");
        root.right.left = new Node("B");

        obj.setRoot(root);

        System.out.println("Postorder Traversal: ");
        obj.postorder();
    }
}
