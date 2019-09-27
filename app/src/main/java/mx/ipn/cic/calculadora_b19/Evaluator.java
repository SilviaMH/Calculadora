/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Class that evaluates a string in postfix notation with a delimiter.
 *
 * @author silvia
 */
public class Evaluator {

    // Constant string used to parse square root function.
    private final String SQUARE_R = "sqrt";

    // Constant string used to parse sine function.
    private final String SINE = "sin";

    // Constant string used to parse cosine function.
    private final String COSINE = "cos";

    // Constant string used to parse tangent function.
    private final String TANGENT = "tan";

    // Constant string used to parse cosecant function.
    private final String COSECANT = "csc";

    // Constant string used to parse secant function.
    private final String SECANT = "sec";

    // Constant string used to parse cotangent function.
    private final String COTANGENT = "cot";

    // Constant string used to parse factorial function.
    private final String FACTORIAL = "fac";

    // Constant string used to parse logarithm function.
    private final String LOGARITHM = "log10";

    // Constant string used to parse natural logarithm function.
    private final String NLOGARITHM = "ln";

    // Constant string used to parse addition operator.
    private final String ADDITION = "+";

    // Constant string used to parse substraction operator.
    private final String SUBSTRACTION = "-";

    // Constant string used to parse multiplication operator.
    private final String MULTIPLICATION = "*";

    // Constant string used to parse division operator.
    private final String DIVISION = "/";

    // Constant string used to parse modulus operator.
    private final String MODULUS = "%";

    // Constant string used to parse power operator.
    private final String POWER = "^";

    // Contains binary operators
    private final List<String> binOp = new ArrayList<>(Arrays.asList("+", "-", "*", "/", "^", "%"));

    // Stack to save token numbers.
    private Stack<Double> numberStack;

    // Result of a mathematical operation.
    private double result;

    // Constructs a string tokenizer for the postfix expression.
    private StringTokenizer postfixExpressionTokenizer;

    // Setter of the result used to make convertions.
    public void setResult(double result) {
        this.result = result;
    }

    /**
     * Initializes the postfix string tokenizer.
     *
     * @param postfixExpression Postfix expression.
     * @param delimiter Separates operators, numbers, constants and functions in
     * the postfix expression.
     */
    public Evaluator(String postfixExpression, String delimiter) {
        this.postfixExpressionTokenizer = new StringTokenizer(postfixExpression, delimiter);
        numberStack = new Stack<>();
    }

    /**
     * Evaluates a postfix expression.
     *
     * @return Result.
     * @throws Calculator.ExpressionSyntaxError
     */
    public double Evaluate() throws ExpressionSyntaxError {
        try {
            while (postfixExpressionTokenizer.hasMoreTokens()) {
                String tokenizer = postfixExpressionTokenizer.nextToken();
                try {
                    double numberElement = new Double(tokenizer);
                    numberStack.push(numberElement);
                } catch (NumberFormatException e) {

                    if (binOp.contains(tokenizer)) {
                        double a = numberStack.pop();
                        double b = numberStack.pop();

                        switch (tokenizer) {
                            case ADDITION:
                                result = b + a;
                                break;
                            case SUBSTRACTION:
                                result = b - a;
                                break;
                            case MULTIPLICATION:
                                result = b * a;
                                break;
                            case DIVISION:
                                result = b / a;
                                break;
                            case POWER:
                                result = Math.pow(b, a);
                                break;
                            case MODULUS:
                                result = b % a;
                                break;
                        }
                    } else {
                        double a = numberStack.pop();
                        tokenizer = tokenizer.toLowerCase();
                        switch (tokenizer) {
                            case SINE:
                                result = Math.sin(a);
                                break;
                            case SQUARE_R:
                                result = Math.sqrt(a);
                                break;
                            case COSINE:
                                result = Math.cos(a);
                                break;
                            case TANGENT:
                                result = Math.tan(a);
                                break;
                            case COSECANT:
                                result = 1 / Math.sin(a);
                                break;
                            case SECANT:
                                result = 1 / Math.cos(a);
                                break;
                            case COTANGENT:
                                result = 1 / Math.tan(a);
                                break;
                            case FACTORIAL:
                                result = fac(a);
                                break;
                            case LOGARITHM:
                                result = Math.log10(a);
                                break;
                            case NLOGARITHM:
                                result = Math.log(a);
                                break;
                        }
                    }
                    numberStack.push(result);
                }
            }
        } catch (Exception ex) {
            throw new ExpressionSyntaxError("Syntax Error postfix");
        }
        return result;
    }

    /**
     * Computes the factorial of a number.
     *
     * @param a Number.
     * @return Factorial of a number.
     */
    private double fac(double a) {
        double factorial = 1;
        while (a != 0) {
            factorial = factorial * a;
            a--;
        }
        return factorial;
    }
}
