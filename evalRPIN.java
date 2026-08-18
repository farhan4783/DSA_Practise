class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;

        for (String token : tokens) {
            if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
                int b = stack[--top];
                int a = stack[--top];
                
                switch (token.charAt(0)) {
                    case '+':
                        stack[top++] = a + b;
                        break;
                    case '-':
                        stack[top++] = a - b;
                        break;
                    case '*':
                        stack[top++] = a * b;
                        break;
                    case '/':
                        stack[top++] = a / b;
                        break;
                }
            } else {
                stack[top++] = Integer.parseInt(token);
            }
        }

        return stack[0];
    }
}












//or//


import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
