package com.infixtopostfix.postfixcalculator;

public class OperatorPrecedence {
    public static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            default: return -1;
        }
    }
}
