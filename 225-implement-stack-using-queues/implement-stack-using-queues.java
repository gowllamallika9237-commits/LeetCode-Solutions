

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
 import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> main = new LinkedList<>();
    private Queue<Integer> auxiliary = new LinkedList<>();

    public void push(int x) {
        auxiliary.add(x);

        while (!main.isEmpty()) {
            auxiliary.add(main.remove());
        }

        Queue<Integer> temp = main;
        main = auxiliary;
        auxiliary = temp;
    }

    public int pop() {
        return main.remove();
    }

    public int top() {
        return main.element();
    }

    public boolean empty() {
        return main.isEmpty();
    }
}