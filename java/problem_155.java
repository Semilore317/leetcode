import java.util.Stack;

/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

*/

class problem_155 {

    private Stack<Integer> stack;
    private int min;

    public problem_155() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
            stack.push(min); // Save current min before updating
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int popped = stack.pop();
        if (popped == min) {
            min = stack.pop(); // Restore previous min
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        problem_155 obj = new problem_155();
        obj.push(10);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}