package stack;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionEvaluationUsingStack {

    // function to check if the char is an operator or not
    public static boolean isAnOperator(char op){
        return op == '+' || op == '-' || op == '*' || op == '/' ;
    }

    // function to preform the operation
    static int preformOperation(int firstE, int secondE, char op){

        return switch (op) {
            case '+' -> secondE + firstE;
            case '-' -> secondE - firstE;
            case '*' -> secondE * firstE;
            case '/' -> secondE / firstE;
            default -> 0;
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the postfix expression eg.(5 5 +): ");
        String exp = sc.nextLine();
        String[] tokens = exp.split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // if token matches a number
            if(token.matches("\\d+")){
                stack.push(Integer.parseInt(token));
            }
            // if token is an operator
            else if(token.length() == 1 && isAnOperator(token.charAt(0))){
                int topE = stack.pop();
                int element = stack.pop();
                int result = preformOperation(topE, element, token.charAt(0));
                stack.push(result);
            }

        }
        System.out.println("The answer is: " + stack.peek());
        sc.close();
    }

}
