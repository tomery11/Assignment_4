import java.util.Map;

/**
 * Cos Operator Class.
 *
 * @author Tomer Yona
 */
public class Cos extends UnaryExpression implements Expression {
    /**
     * UnaryExpression constructor.
     *
     * @param exp .
     */
    public Cos(Expression exp) {
        super(exp);
    }

    /**
     * UnaryExpression constructor.
     *
     * @param var .
     */
    public Cos(Var var) {
        super(var);
    }

    /**
     * UnaryExpression constructor.
     *
     * @param num .
     */
    public Cos(Num num) {
        super(num);
    }

    /**
     * UnaryExpression constructor.
     *
     * @param var .
     */
    public Cos(String var) {
        super(var);
    }

    /**
     * UnaryExpression constructor.
     *
     * @param num .
     */
    public Cos(double num) {
        super(num);
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment .
     * @return double .
     * @throws Exception .
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double toCalc = getExpression().evaluate(assignment);
        return Math.cos(toCalc);

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
        if (super.getExpression() instanceof Var) {
            throw new RuntimeException("Cannot use map without Var");
        }
        double toCalc = super.getExpression().evaluate();
        return Math.cos(toCalc);
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        .
     * @param expression .
     * @return Expression .
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return super.assign(var, expression);
    }

    /**
     * auxialry function for assigning expression.
     *
     * @param assign .
     * @return Expression .
     */
    private Expression assignExpression(Expression assign) {
        return new Cos(assign);
    }

    @Override
    public String toString() {
        return "cos(" + super.getExpression() + ")";
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
        Expression leftProduct = new Sin(this.getExp());
        Expression rightProduct = this.getExpression().differentiate(var);
        return new Neg(new Mult(leftProduct, rightProduct));
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return Expression
     */
    @Override
    public Expression simplify() {
        try {
            if (getExpression() instanceof Num) {
                if (0 == getExpression().evaluate()) {
                    return new Num(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return new Cos(getExpression().simplify());
    }
}
