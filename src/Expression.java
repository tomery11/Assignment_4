import java.util.List;
import java.util.Map;

/**
 * This is a class that describes a Expression interface.
 *
 * @author  Tomer Yona
 * @version 1.0
 * @since   2019-04-10
 */
public interface Expression {


    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     * @param assignment .
     * @return double
     * @throws Exception .
     */
    double evaluate(Map<String, Double> assignment) throws Exception;



    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return double
     * @throws Exception .
     */
    double evaluate() throws Exception;



    /**
     * Returns a list of the variables in the expression.
     * @return List .
     */
    List<String> getVariables();



    /**
     * Returns a nice string representation of the expression.
     * @return String
     */
    String toString();



    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     * @param var .
     * @param expression .
     * @return Expression
     */
    Expression assign(String var, Expression expression);




    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     * @param var .
     * @return Expression .
     */
    Expression differentiate(String var);



    /**
     * Returned a simplified version of the current expression.
     * @return Expression.
     */
    Expression simplify();
}
