package stack;

import java.util.Stack;

public class BalancedParenthethes {

    static boolean arePair(char x, char y) {
        if (x == '(' && y == ')') {
            return true;
        } else if (x == '[' && y == ']') {
            return true;
        } else return (x == '{' && y == '}');
    }

    static boolean areBalanced(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == '[' || expression.charAt(i) == '{') {
                stack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')' || expression.charAt(i) == ']' || expression.charAt(i) == '}') {
                if (stack.isEmpty() || !arePair(stack.peek(), expression.charAt(i)))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String exp = "(4*4))";
        System.out.println(areBalanced(exp));
    }


}
