import java.util.List;
import java.util.Map;

/**
 * This is a class that describes a number.
 *
 * @author  Tomer Yona
 * @version 1.0
 * @since   2019-04-10
 */
public class Num implements Expression{

    private double number;

    /**
     * constructor for Num.
     * @param n .
     */
    public Num(double n){
        this.number = n;
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment .
     * @return double
     * @throws Exception
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return 0;
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return double
     * @throws Exception .
     */
    @Override
    public double evaluate() throws Exception {
        return this.number;
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return
     */
    @Override
    public List<String> getVariables() {
        return null;
    }

    /**
     * Returns a nice string representation of the expression.
     * @return String
     */
    public String toString(){
        String str = Double.toString(this.number);
        return str;
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        .
     * @param expression .
     * @return Expression
     */
    @Override
    public Expression assign(String var, Expression expression) {
        if(this.toString().equals(var)){
            return expression;
        }else{
            return this;
        }
    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var .
     * @return
     */
    @Override
    public Expression differentiate(String var) {
        return null;
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return
     */
    @Override
    public Expression simplify() {
        return null;
    }
}
