package fundamentals.oop.traversal_code;

public class VerifyBST {
    private Traversal.Node root;

    public VerifyBST(Traversal.Node root) {
        this.root = root;
    }

    public boolean verifyBST() {
        // Print in-order traversal using Traversal class
        System.out.print("In-order traversal: ");
        Traversal traversal = new Traversal();
        traversal.setRoot(root);
        traversal.inOrder();

        // Verify BST property using range check
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(Traversal.Node node, String minVal, String maxVal) {
        if (node == null) {
            return true;
        }
        // Check if node.data is within bounds (minVal < node.data < maxVal)
        if (minVal != null && node.data.compareTo(minVal) <= 0) {
            return false;
        }
        if (maxVal != null && node.data.compareTo(maxVal) >= 0) {
            return false;
        }
        return isValidBST(node.left, minVal, node.data) && isValidBST(node.right, node.data, maxVal);
    }

    public static void main(String[] args) {
        // Test Case 1: Valid BST
        //       "10"
        //      /    \
        //     "5"   "15"
        //    / \      \
        //   "3" "7"  "18"
        Traversal.Node root1 = new Traversal.Node("10");
        root1.left = new Traversal.Node("5");
        root1.right = new Traversal.Node("15");
        root1.left.left = new Traversal.Node("3");
        root1.left.right = new Traversal.Node("7");
        root1.right.right = new Traversal.Node("18");

        // Test Case 2: Invalid BST
        //       "10"
        //      /    \
        //     "5"   "15"
        //    / \     /
        //   "3" "7" "12"
        Traversal.Node root2 = new Traversal.Node("10");
        root2.left = new Traversal.Node("5");
        root2.right = new Traversal.Node("15");
        root2.left.left = new Traversal.Node("3");
        root2.left.right = new Traversal.Node("7");
        root2.right.left = new Traversal.Node("12"); // Violates BST: "12" < "15" but in left subtree

        // Run tests
        System.out.println("Test Case 1 (Valid BST):");
        VerifyBST bst1 = new VerifyBST(root1);
        System.out.println("\nIs valid BST? " + bst1.verifyBST());
        System.out.println();

        System.out.println("Test Case 2 (Invalid BST):");
        VerifyBST bst2 = new VerifyBST(root2);
        System.out.println("\nIs valid BST? " + bst2.verifyBST());
    }
}