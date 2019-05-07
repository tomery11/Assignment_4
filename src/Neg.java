import java.util.Map;

/**
 * This is a class that describes a Negative Operator and implements expression.
 *
 * @author Tomer Yona
 * @version 1.0
 * @since 2019-04-10
 */
public class Neg extends UnaryExpression implements Expression {
    /**
     * UnaryExpression constructor.
     *
     * @param exp .
     */
    public Neg(Expression exp) {
        super(exp);
    }

    /**
     * UnaryExpression constructor.
     *
     * @param var .
     */
    public Neg(Var var) {
        super(var);
    }

    /**
     * UnaryExpression constructor.
     *
     * @param num .
     */
    public Neg(Num num) {
        super(num);
    }

    /**
     * UnaryExpression constructor.
     *
     * @param var .
     */
    public Neg(String var) {
        super(var);
    }

    /**
     * UnaryExpression constructor.
     *
     * @param num .
     */
    public Neg(double num) {
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
        return -1 * (toCalc);
        /*
        Expression tempExp = this.getExpression();


        if (this.getExpression() instanceof Var) {
            tempExp = new Num(assignment.get(this.getVariables().get(0)));
        }

        UnaryExpression toCalc =  new Neg(tempExp);
        double ans = toCalc.evaluate();
        return ans;*/
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
        return toCalc * (-1);
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
        return new Neg(assign);
    }

    @Override
    public String toString() {
        return "(-" + super.getExpression() + ")";
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
        return new Neg(this.getExp().differentiate(var));
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return Expression .
     */
    @Override
    public Expression simplify() {

        Expression simplfied = this.getExp().simplify();
        if (simplfied.getVariables().isEmpty()) {
            try {
                return new Num(-1 * simplfied.evaluate());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Neg(simplfied);

    }
}
