package stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    // function to check whether the char is an operand or not
    static boolean isOperand(char e){
        return (e >= '0' && e <= '9') ||
                (e >= 'a' && e <= 'z') ||
                (e >= 'A' && e <= 'Z');
    }

    // function to check whether the char is an operator or not
    public static boolean isOperator(char op){
        return op == '+' || op == '-' || op == '*' || op == '/' ;
    }

    // function to get operator weight
    static int operatorWeight(char e){

        return switch(e){
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    // function to check the priority of the operations

    static boolean hasHighPriority(char e, char t){

        int weight1 = operatorWeight(e);
        int weight2 = operatorWeight(t);
        return weight1 > weight2;
    }

    public static String infixToPostfix(String expression){

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for(int i = 0; i < expression.length(); i++){

            char e = expression.charAt(i);

            if(e == ' ' || e == ',') continue;

            if(isOperand(e)){

                postfix.append(e);
            }
            else if(isOperator(e)){

                while(!stack.isEmpty() && stack.peek() == '(' && hasHighPriority(stack.peek(),e)){
                    postfix.append(stack.pop());
                }
                stack.push(e);
            }
            else if(e == '('){

                stack.push(e);
            }
            else if(e == ')'){

                while(!stack.isEmpty() && stack.peek() != '('){
                    postfix.append(stack.pop());
                }
                stack.pop(); // remove (
            }

        }

        while(!stack.isEmpty()){
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the infix series eg.( 6+7*9+(3-1) ):  ");
        String infix = sc.nextLine();
        System.out.println("postfix: " + infixToPostfix(infix));
        sc.close();
    }

}
