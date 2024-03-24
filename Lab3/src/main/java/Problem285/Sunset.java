package Problem285;

import java.util.ArrayList;
import java.util.Stack;

public class Sunset {
    public static int sunset(ArrayList<Integer> street) {
        Stack<Integer> stack = new Stack<>();
        for (int block : street) {
            if (!stack.isEmpty()) {
                int last = stack.peek();
                while (!stack.isEmpty() && last < block) {
                    stack.pop();
                    last = Integer.MAX_VALUE;
                    if (!stack.isEmpty()) {
                        last = stack.peek();
                    }
                }
            }
            if (stack.isEmpty() || stack.peek() > block) {
                stack.push(block);
            }
        }
        return stack.size();
    }
}
