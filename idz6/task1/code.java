package com.tasks7.rpn;

import java.util.Deque;
import java.util.LinkedList;

public class Application {
    public static double parse(String rpnString) {
        Deque<Double> stack = new LinkedList<>();

        String[] tokens = rpnString.split(" ");

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new RPNParserException();
                }

                double operand2 = stack.pop();
                double operand1 = stack.pop();

                double result = performOperation(operand1, operand2, token);
                stack.push(result);
            } else {
                throw new RPNParserException();
            }
        }

        if (stack.size() != 1) {
            throw new RPNParserException();
        }

        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException();
                }
                return operand1 / operand2;
            default:
                throw new RPNParserException();
        }
    }

    public static void main(String[] args) {

    }
}
  
