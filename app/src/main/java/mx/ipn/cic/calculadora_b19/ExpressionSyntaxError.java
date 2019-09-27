/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 * Handles syntex errors.
 * @author silvia
 */
public class ExpressionSyntaxError extends Exception {
    public ExpressionSyntaxError(String message) {
        super (message);
    }
}
