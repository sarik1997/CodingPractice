import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();

        obj.push(5);
        obj.push(3);
        obj.push(7);

        System.out.println("Top: " + obj.top());      // 7
        System.out.println("Min: " + obj.getMin());   // 3

        obj.pop(); // removes 7
        System.out.println("Top after pop: " + obj.top());    // 3
        System.out.println("Min after pop: " + obj.getMin()); // 3

        obj.pop(); // removes 3
        System.out.println("Top after pop: " + obj.top());    // 5
        System.out.println("Min after pop: " + obj.getMin()); // 5
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */