import java.util.List;
import java.util.Map;
/**
 * Log Operator Class.
 *
 * @author Tomer Yona
 */
public class Log extends BinaryExpression implements Expression {
    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param leftExp .
     * @param rightExp .
     */
    public Log(Expression leftExp, Expression rightExp) {
        super(leftExp, rightExp);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param var .
     * @param num .
     */
    public Log(String var, double num) {
        super(var, num);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param num .
     * @param var .
     */
    public Log(double num, String var) {
        super(num, var);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param num1 .
     * @param num2 .
     */
    public Log(double num1, double num2) {
        super(num1, num2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param var1 .
     * @param var2 .
     */
    public Log(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param var1 .
     * @param exp2 .
     */
    public Log(String var1, Expression exp2) {
        super(var1, exp2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param exp1 .
     * @param var2 .
     */
    public Log(Expression exp1, String var2) {
        super(exp1, var2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param num1 .
     * @param exp2 .
     */
    public Log(double num1, Expression exp2) {
        super(num1, exp2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param exp1 .
     * @param num2 .
     */
    public Log(Expression exp1, double num2) {
        super(exp1, num2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     * @param expression .
     */
    public Log(Expression expression) {
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
        if (right == 0) {
            throw new RuntimeException("illegal log");
        }
        return Math.log(left / right);

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
        // need to switch here the log calculator and check if throuw exception
        if (Math.log(super.getRightExpression().evaluate()) == 0) {
            throw new RuntimeException("cannot divide by 0");
        }
        return Math.log(super.getLeftExpression().evaluate()) / Math.log(super.getRightExpression().evaluate());

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
        String str = "log(" + super.getLeftExpression() + ", " + super.getRightExpression() + ")";
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
        return new Log(left, right);
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
     * @return Expression.
     */

    public Expression differentiate(String var) {
        Expression firstTerm = new Div(1, new Mult(getRightExpression(), new Log("e", getLeftExpression())));
        Expression secondTerm = getRightExpression().differentiate(var);
        return new Mult(firstTerm, secondTerm);

    }

    @Override
    /**
     * Simplification of Expression.
     * @return Expression.
     */
    public Expression simplify() {


        Expression leftSimple = getLeftExpression().simplify();
        Expression rightSimple = getRightExpression().simplify();

        try {


            if (leftSimple.toString().equals(rightSimple.toString())) {
                return new Num(1);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            if (leftSimple instanceof Var && rightSimple instanceof Num) {
                if (leftSimple.toString().equals("e") && rightSimple.evaluate() == 2.71828) {
                    return new Num(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            if (rightSimple instanceof Var && leftSimple instanceof Num) {
                if (rightSimple.toString().equals("e") && leftSimple.evaluate() == 2.71828) {
                    return new Num(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            if (rightSimple instanceof Num && leftSimple instanceof Num) {
                if (rightSimple.evaluate() == leftSimple.evaluate()) {
                    return new Num(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Log(leftSimple, rightSimple);
    }
}
