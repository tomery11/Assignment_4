
import java.util.List;
import java.util.Map;

/**
 * Plus class.
 *
 * @author Tomer Yona
 * @date 22.4.19
 */
public class Plus extends BinaryExpression implements Expression {
    /**
     * Plus Constructor.
     *
     * @param leftExp  .
     * @param rightExp .
     */
    public Plus(Expression leftExp, Expression rightExp) {
        super(leftExp, rightExp);

    }

    /**
     * Plus Constructor.
     *
     * @param var .
     * @param num .
     */
    public Plus(String var, double num) {
        super(var, num);

    }

    /**
     * Plus Constructor.
     *
     * @param num .
     * @param var .
     */
    public Plus(double num, String var) {
        super(num, var);

    }

    /**
     * Plus Constructor.
     *
     * @param num1 .
     * @param num2 .
     */
    public Plus(double num1, double num2) {
        super(num1, num2);

    }

    /**
     * Plus Constructor.
     *
     * @param var1 .
     * @param var2 .
     */
    public Plus(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * Plus Constructor.
     *
     * @param var1 .
     * @param exp2 .
     */
    public Plus(String var1, Expression exp2) {
        super(var1, exp2);

    }

    /**
     * Plus Constructor.
     *
     * @param exp1 .
     * @param var2 .
     */
    public Plus(Expression exp1, String var2) {
        super(exp1, var2);
    }

    /**
     * Plus Constructor.
     *
     * @param num1 .
     * @param exp2 .
     */
    public Plus(double num1, Expression exp2) {
        super(num1, exp2);

    }

    /**
     * Plus Constructor.
     *
     * @param exp1 .
     * @param num2 .
     */
    public Plus(Expression exp1, double num2) {
        super(exp1, num2);
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
        Expression tempLeftExp = this.getLeftExpression();
        Expression tempRightExp = this.getRightExpression();


        if (this.getLeftExpression() instanceof Var) {
            tempLeftExp = new Num(assignment.get(this.getVariables().get(0)));
            if (this.getRightExpression() instanceof Var) {
                tempRightExp = new Num(assignment.get(this.getVariables().get(1)));
            }
        } else if (this.getRightExpression() instanceof Var) {
            tempRightExp = new Num(assignment.get(this.getVariables().get(0)));
        }

        BinaryExpression toCalc = new Plus(tempLeftExp, tempRightExp);
        double ans = toCalc.evaluate();
        return ans;

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
        if (super.getLeftExpression() instanceof Var || super.getRightExpression() instanceof Var) {
            throw new RuntimeException("Cannot use map without Var");
        }
        return super.getLeftExpression().evaluate() + super.getRightExpression().evaluate();

    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return
     */
    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return String
     */
    public String toString() {
        String str = "(" + super.getLeftExpression() + " + " + super.getRightExpression() + ")";
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

        return super.assign(var, expression);
    }

    @Override
    public Expression assignExpression(Expression left, Expression right) {
        return new Plus(left, right);
    }

    /**
     * setter for left expression.
     *
     * @param leftExp .
     */
    public void setLeftExpression(Expression leftExp) {
        super.setLeftExpression(leftExp);
    }

    /**
     * Plus Constructor.
     *
     * @param rightExp .
     */
    public void setRightExpression(Expression rightExp) {
        super.setRightExpression(rightExp);
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
        return new Plus(getLeftExpression().differentiate(var), getRightExpression().differentiate(var));

    }


}
