package Main;

import com.udojava.evalex.Expression;

import java.util.ArrayList;
import java.util.Arrays;

public class ExpressionSetup {
    //to store the entire expression for display
    private String expression;
    //to store the current parsing equation, set to the basic '0+1'
    private ArrayList<String> current = new ArrayList<String>(Arrays.asList( "0", "+", "1"));
    //to store the actual value of the current expression
    private String value;
    //A boolean value stating if the expression is able to give an answer
    private boolean ready;
    //Detects when an expression has just been evaluated. Used to stop user overwriting answer.
    private boolean evalCheck;
    //An array of allowed numbers
    final String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
    //An array of allowed operators
    final String[] operators = {"+","-","*"};

    //Instantiator, sets original value and expression to 1.
    public ExpressionSetup() {
        expression = "1";
        value = "1";
        ready = true;
        evalCheck = false;
    }
    
    //Gets the current expression for displaying in graphics
    public String getExpression() {
        return expression;
    }

    //Gets the current actual value of the expression
    public String getValue() {
        expression = value;
        return value;
    }

    // Get the ready state of the expression, is it ready to be evaluated?
    public boolean getReady() {
        return ready;
    }

    // Sets the check if an evaluation has just occurred.
    public void setEval() {
        evalCheck = true;
    }

    //Resets the expression
    public void reset() {
        current = new ArrayList<String>(Arrays.asList( "0", "+", "1"));
        expression = "1";
        value = "1";
        ready = true;
        evalCheck = false;
    }
    //Validates, and adds an integer to the expression
    public void addValue(String newVal) {
        if(!evalCheck) {
            if (Arrays.asList(numbers).contains(expression.substring(expression.length() - 1))) {
                expression = expression.substring(0, expression.length() - 1) + newVal;
            }
            else {
                expression += newVal;
            }
            
            current.set(2, newVal);
            ready = true;
        }
    }

    //Validates, and adds an operator to the expression
    public void addOperator(String newOperator) {
        if (Arrays.asList(operators).contains(expression.substring(expression.length() - 1))) {
            expression = expression.substring(0, expression.length() - 1) + newOperator; 
        }
        else {
            evaluateCurrent();
            expression += newOperator;
        }
        current.set(1, newOperator);
        ready = false;
        evalCheck = false;
    }

    //Evaluates the value of the current expression, and resets the current expression
    public void evaluateCurrent(){
        StringBuilder build = new StringBuilder();
        for (String s : current) {
            build.append(s);
        }
        value = new Expression(build.toString()).eval().toPlainString();
        if (10000 < Integer.parseInt(value) || Integer.parseInt(value) < -10000) {
            reset();
        }
        //TODO Produce a message for going out of bounds
        current.set(0, value);
        current.set(1, "*");
        current.set(2, "1");

    }

}