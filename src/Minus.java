import java.util.List;
import java.util.Map;

/**
 * This is a class that describes a Minus Operator and implements expression.
 *
 * @author Tomer Yona
 * @version 1.0
 * @since 2019-04-10
 */
public class Minus extends BinaryExpression implements Expression {

    /**
     * constructor of Minus we also update the variable list of expression.
     *
     * @param leftExp  .
     * @param rightExp .
     */
    public Minus(Expression leftExp, Expression rightExp) {
        super(leftExp, rightExp);
    }

    /**
     * constructor of Minus we also update the variable list of expression.
     *
     * @param var .
     * @param num .
     */
    public Minus(String var, double num) {
        super(var, num);
    }

    /**
     * constructor of Minus we also update the variable list of expression.
     *
     * @param num .
     * @param var .
     */
    public Minus(double num, String var) {
        super(num, var);
    }

    /**
     * constructor of Minus we also update the variable list of expression.
     *
     * @param num1 .
     * @param num2 .
     */
    public Minus(double num1, double num2) {
        super(num1, num2);
    }

    /**
     * constructor of Minus we also update the variable list of expression.
     *
     * @param var1 .
     * @param var2 .
     */
    public Minus(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * constructor of Minus we also update the variable list of expression.
     *
     * @param var1 .
     * @param exp2 .
     */
    public Minus(String var1, Expression exp2) {
        super(var1, exp2);
    }

    /**
     * constructor of Minus we also update the variable list of expression.
     *
     * @param exp1 .
     * @param var2 .
     */
    public Minus(Expression exp1, String var2) {
        super(exp1, var2);
    }

    /**
     * constructor of Minus we also update the variable list of expression.
     *
     * @param num1 .
     * @param exp2 .
     */
    public Minus(double num1, Expression exp2) {
        super(num1, exp2);
    }

    /**
     * constructor of Minus we also update the variable list of expression.
     *
     * @param exp1 .
     * @param num2 .
     */
    public Minus(Expression exp1, double num2) {
        super(exp1, num2);
    }

    /**
     * constructor of Minus we also update the variable list of expression.
     *
     * @param expression .
     */
    public Minus(Expression expression) {
        super(expression);
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
        double left = getLeftExpression().evaluate(assignment);
        double right = getRightExpression().evaluate(assignment);

        return left - right;

    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return double /
     * @throws Exception .
     */
    @Override
    public double evaluate() throws Exception {
        if (super.getLeftExpression() instanceof Var || super.getRightExpression() instanceof Var) {
            throw new RuntimeException("Cannot use map without Var");
        }
        return super.getLeftExpression().evaluate() - super.getRightExpression().evaluate();

    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return List .
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
        String str = "(" + super.getLeftExpression() + " - " + super.getRightExpression() + ")";
        return str;
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

    @Override
    public Expression assignExpression(Expression left, Expression right) {
        return new Minus(left, right);
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
     * Returns the expression tree resulting from differentiating .
     * the current expression relative to variable `var`.
     *
     * @param var .
     * @return Expression .
     */
    @Override
    public Expression differentiate(String var) {
        return new Minus(getLeftExpression().differentiate(var), getRightExpression().differentiate(var));
    }


    @Override
    public Expression simplify() {

        Expression leftSimple = getLeftExpression().simplify();
        Expression rightSimple = getRightExpression().simplify();

        //x-0=x
        try {
            if (rightSimple instanceof Num) {
                if (0 == rightSimple.evaluate(super.getAssignment())) {
                    return leftSimple;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //0-x =-x
        try {
            if (leftSimple instanceof Num) {
                if (0 == leftSimple.evaluate(super.getAssignment())) {
                    return new Neg(rightSimple);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        //x-x=0
        try {
            if (leftSimple.toString().equals(rightSimple.toString())) {
                return new Num(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Minus(leftSimple, rightSimple);
    }
}