/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Converts an infix expression to a postfix expressions.
 *
 * @author silvia
 */
public class Converter {

    // Constant string used to parse square root function.
    private static String SQUARE_R = "sqrt";

    // Constant string used to parse sine function.
    private static String SINE = "sin";

    // Constant string used to parse cosine function.
    private static String COSINE = "cos";

    // Constant string used to parse tangent function.
    private static String TANGENT = "tan";

    // Constant string used to parse cosecant function.
    private static String COSECANT = "csc";

    // Constant string used to parse secant function.
    private static String SECANT = "sec";

    // Constant string used to parse cotangent function.
    private static String COTANGENT = "cot";

    // Constant string used to parse factorial function.
    private static String FACTORIAL = "fac";

    // Constant string used to parse logarithm function.
    private static String LOGARITHM = "log10";

    // Constant string used to parse natural logarithm function.
    private static String NLOGARITHM = "ln";

    // Constant string used to parse addition operator.
    private static String ADDITION = "+";

    // Constant string used to parse substraction operator.
    private static String SUBSTRACTION = "-";

    // Constant string used to parse multiplication operator.
    private static String MULTIPLICATION = "*";

    // Constant string used to parse division operator.
    private static String DIVISION = "/";

    // Constant string used to parse modulus operator.
    private static String MODULUS = "%";

    // Constant string used to parse power operator.
    private static String POWER = "^";

    // Constant string used to parse left parenthesis.
    private static String LEFTP = "(";

    // Constant string used to parse rigth parenthesis.
    private static String RIGHTP = ")";

    // Constant string used to separate elements in the postfix expression.
    private static String DELIMITER = " ";

    // Constant string used to indicate an empty string.
    private static String EMPTY = "";

    // Control stack to convert to postfix.
    private static Stack<String> ctrlStack;

    // Saves postfix espression.
    private static String postfix;

    /**
     * Converts an infix expression to a postfix expression.
     *
     * @param infixExpression Infix expression.
     * @return Postfix expression.
     * @throws Calculator.ExpressionSyntaxError
     */
    public static String infix2postfix(StringTokenizer infixExpression) throws ExpressionSyntaxError {
        postfix = EMPTY;
        ctrlStack = new Stack();
        while (infixExpression.hasMoreTokens()) {
            String token = infixExpression.nextToken();
            try {
                double numberElement = new Double(token);
                postfix += Double.toString(numberElement) + DELIMITER;
            } catch (NumberFormatException e) {
                try {
                    if (ctrlStack.empty()) {
                        ctrlStack.push(token);
                    } else if (token.equals(LEFTP)) {
                        ctrlStack.push(token); 
                    } else if (token.equals(RIGHTP)) {
                        while (!ctrlStack.peek().equals(LEFTP)) {
                            postfix += ctrlStack.pop() + DELIMITER;
                        }
                        ctrlStack.pop();
                    } else if (token.equals(POWER) & ctrlStack.peek().equals(POWER)) {
                        ctrlStack.push(token);
                    } else {
                        int priorityToken = getPriority(token);
                        int priorityStack = getPriority(ctrlStack.peek());

                        if (priorityStack >= priorityToken) {
                            postfix += ctrlStack.pop() + DELIMITER;
                        }
                        ctrlStack.push(token);
                    }
                } catch (Exception ex) {
                    throw new ExpressionSyntaxError("Syntax Error infix");
                }
            }
        }
        while (!ctrlStack.empty()) {
            postfix += ctrlStack.pop() + DELIMITER;
        }
        return postfix;
    }

    /**
     * Gets the priority of the element at the top of the stack.
     *
     * @param a Element to be evaluated.
     * @return Level of priority.
     */
    private static int getPriority(String a) {
//        boolean hasMorePriority = false;
//        
//        if (!ctrlStack.empty()) {
//            String b = ctrlStack.peek();
//            if (b.equals(ADDITION) | b.equals(SUBSTRACTION)) {
//                return a.equals(ADDITION) | a.equals(SUBSTRACTION);
//            } else if (b.equals(MULTIPLICATION) | b.equals(DIVISION) | b.equals(POWER) | b.equals(MODULUS)) {
//                return a.equals(ADDITION) | a.equals(SUBSTRACTION) | a.equals(MULTIPLICATION) | a.equals(DIVISION) | a.equals(MODULUS);
//            } else if (b.equals(FACTORIAL) | b.equals(SINE) | b.equals(COSINE) | b.equals(TANGENT) | 
//                       b.equals(COSECANT) | b.equals(SECANT) | b.equals(COTANGENT) | b.equals(LOGARITHM) | 
//                       b.equals(NLOGARITHM) b.equals(TANGENT)) {
//                
//            } 
//        }        
//        return hasMorePriority;

        if (a.equals(ADDITION) | a.equals(SUBSTRACTION)) {
            return 1;
        } else if (a.equals(MULTIPLICATION) | a.equals(DIVISION) | a.equals(MODULUS)) {
            return 2;
        } else if (a.equals(POWER) | a.equals(SQUARE_R) | a.equals(FACTORIAL) | a.equals(SINE) | a.equals(COSINE) | a.equals(TANGENT)
                | a.equals(COSECANT) | a.equals(SECANT) | a.equals(COTANGENT) | a.equals(LOGARITHM)
                | a.equals(NLOGARITHM)) {
            return 3;
        } else {
            return 0;
        }
    }
}
