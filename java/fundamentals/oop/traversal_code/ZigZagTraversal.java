package fundamentals.oop.traversal_code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ZigZagTraversal {
    private Traversal.Node root;
    public ArrayList<String> zigZag(String[] root) {
        // perform zig-zag level-order traversal and return node values
        //Array result = new String[root.length];
        ArrayList<String> result = new ArrayList<String>();
        if (root.length == 0) {
            return result;
        }
        Deque<Traversal.Node> queue = new ArrayDeque<>();
        boolean left_to_right = true;

        while(!queue.isEmpty()) {
            int level_size = queue.size();
            //int[] current_level = new int[level_size];
            ArrayList<Integer> current_level = new ArrayList<Integer>();

            // process all nodes at the current level
            for (int i = 0; i < level_size; i++) {
                Traversal.Node node = queue.poll();
                current_level.add(Integer.valueOf(node.data));

                if(node.left != null) {
                    queue.add(node.left);
                }else if(node.right != null) {
                    queue.add(node.right);
                }
            }

            // Reverse the current level if going right-to-left
            if(!left_to_right) {
                current_level.reversed();
            }

            result.add(current_level.toString());
            left_to_right = !left_to_right;
        }
        return result;
    }

    public static void main(String[] args) {
        //ZigZagTraversal tree = new ZigZagTraversal();
        Traversal tree = new Traversal();

        // Create a sample binary tree:
        //       A
        //      / \
        //     B   C
        //    / \   \
        //   D   E   F

        Traversal.Node root = new Traversal.Node("A");
        root.left = new Traversal.Node("B");
        root.right = new Traversal.Node("C");
        root.left.left = new Traversal.Node("D");
        root.left.right = new Traversal.Node("E");
        root.right.right = new Traversal.Node("F");

        tree.setRoot(root);
        System.out.println("ZigZag traversal:");
        //tree.zigzag(); // this raises an error because zigzag() isnt defined on tree's blueprint
        System.out.println(tree.zigZag());
    }
}
