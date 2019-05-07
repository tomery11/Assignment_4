import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This is a class that describes a variable.
 *
 * @author Tomer Yona
 * @version 1.0
 * @since 2019-04-10
 */
public class Var implements Expression {
    private List<String> varList = new ArrayList<>();
    private String variable;
    private Map<String, Double> assignment = new TreeMap<String, Double>();

    /**
     * constructor of Variable.
     *
     * @param v .
     */
    public Var(String v) {
        this.variable = v;
        //add var to list
        this.varList.add(v);
    }


    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment1 .
     * @return double
     * @throws Exception .
     */
    @Override
    public double evaluate(Map<String, Double> assignment1) throws Exception {
        if (variable.equals("e")) {
            return 2.71828;
        }
        if (variable.equals("Pi")) {
            return 3.14;
        }
        if (assignment1.get(variable) == null) {
            throw new RuntimeException("empty map");
        }
        return assignment1.get(variable);
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
        throw new RuntimeException("cannot return var without map");
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return List .
     */
    @Override
    public List<String> getVariables() {
        return this.varList;
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return String .
     */
    public String toString() {
        return this.variable;
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

    public Expression assign(String var, Expression expression) {
        if (this.toString().equals(var)) {
            return expression;
        } else {
            return this;
        }

    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var .
     * @return Expression .
     */
    @Override
    public Expression differentiate(String var) {
        if (this.variable.equals(var)) {
            return new Num(1);
        }
        return new Num(0);
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return Expression .
     */
    @Override
    public Expression simplify() {
        return this;
    }
}
