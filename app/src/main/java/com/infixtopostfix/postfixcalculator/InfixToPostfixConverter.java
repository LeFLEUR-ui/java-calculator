package com.infixtopostfix.postfixcalculator;

import java.util.Stack;

public class InfixToPostfixConverter {

    public static String convert(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ' ') continue;

            if (Character.isDigit(c) || c == '.') {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                result.append(' ');
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else {
                result.append(' ');
                while (!stack.isEmpty() && OperatorPrecedence.getPrecedence(c) <= OperatorPrecedence.getPrecedence(stack.peek())) {
                    result.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(' ').append(stack.pop());
        }

        return result.toString().trim();
    }
}
