import java.util.Map;

/**
 * Cos Operator Class.
 *
 * @author Tomer Yona
 */
public class Sin extends UnaryExpression implements Expression {
    /**
     * Sin constructor .
     *
     * @param exp .
     */
    public Sin(Expression exp) {
        super(exp);
    }

    /**
     * Sin constructor .
     *
     * @param var .
     */
    public Sin(Var var) {
        super(var);
    }

    /**
     * Sin constructor .
     *
     * @param num .
     */
    public Sin(Num num) {
        super(num);
    }

    /**
     * Sin constructor .
     *
     * @param var .
     */
    public Sin(String var) {
        super(var);
    }

    /**
     * Sin constructor .
     *
     * @param num .
     */
    public Sin(double num) {
        super(num);
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment .
     * @return double
     * @throws Exception .
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double toCalc = getExpression().evaluate(assignment);
        return Math.sin(toCalc);

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

        return Math.sin(toCalc);
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
        return super.assign(var, expression);
    }

    /**
     * auxilary function for assign.
     * @param assign .
     * @return Expression.
     */
    private Expression assignExpression(Expression assign) {
        return new Sin(assign);
    }

    @Override
    /**
     * to String function.
     * @return String.
     */
    public String toString() {
        return "sin(" + super.getExpression() + ")";
    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var .
     * @return Expression.
     */
    @Override
    public Expression differentiate(String var) {
        return new Mult(new Cos(this.getExp()), this.getExpression().differentiate(var));
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return Expression .
     */
    @Override
    public Expression simplify() {
        try {
            if (getExpression() instanceof Num) {
                if (0 == getExpression().evaluate()) {
                    return new Num(0);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return new Sin(getExpression().simplify());
    }
}