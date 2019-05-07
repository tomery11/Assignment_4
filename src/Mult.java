import java.util.List;
import java.util.Map;
/**
 * This is a class that describes a Multiply Operator and implements expression.
 *
 * @author Tomer Yona
 * @version 1.0
 * @since 2019-04-10
 */
public class Mult extends BinaryExpression implements Expression {

    /**
     * constructor of Mult we also update the variable list of expression.
     *
     * @param leftExp  .
     * @param rightExp .
     */
    public Mult(Expression leftExp, Expression rightExp) {
        super(leftExp, rightExp);
    }

    /**
     * constructor of Mult we also update the variable list of expression.
     *
     * @param var .
     * @param num .
     */
    public Mult(String var, double num) {

        super(var, num);
    }

    /**
     * constructor of Mult we also update the variable list of expression.
     *
     * @param num .
     * @param var .
     */
    public Mult(double num, String var) {
        super(num, var);
    }

    /**
     * constructor of Mult we also update the variable list of expression.
     *
     * @param num1 .
     * @param num2 .
     */
    public Mult(double num1, double num2) {
        super(num1, num2);
    }

    /**
     * constructor of Mult we also update the variable list of expression.
     *
     * @param var1 .
     * @param var2 .
     */
    public Mult(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * constructor of Mult we also update the variable list of expression.
     *
     * @param var1 .
     * @param exp2 .
     */
    public Mult(String var1, Expression exp2) {
        super(var1, exp2);
    }

    /**
     * constructor of Mult we also update the variable list of expression.
     *
     * @param exp1 .
     * @param var2 .
     */
    public Mult(Expression exp1, String var2) {
        super(exp1, var2);
    }

    /**
     * constructor of Mult we also update the variable list of expression.
     *
     * @param num1 .
     * @param exp2 .
     */
    public Mult(double num1, Expression exp2) {
        super(num1, exp2);
    }

    /**
     * constructor of Mult we also update the variable list of expression.
     *
     * @param exp1 .
     * @param num2 .
     */
    public Mult(Expression exp1, double num2) {
        super(exp1, num2);
    }

    /**
     * constructor of Mult we also update the variable list of expression.
     *
     * @param expression .
     */
    public Mult(Expression expression) {
        super(expression);
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
        double left = getLeftExpression().evaluate(assignment);
        double right = getRightExpression().evaluate(assignment);

        return left * right;


    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return double .
     * @throws Exception .
     */
    @Override
    public double evaluate() throws Exception {

        if (super.getLeftExpression() instanceof Var || super.getRightExpression() instanceof Var) {
            throw new RuntimeException("Cannot use map without Var");
        }
        return super.getLeftExpression().evaluate() * super.getRightExpression().evaluate();

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
        String str = "(" + super.getLeftExpression() + " * " + super.getRightExpression() + ")";
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
    /**
     * auxilary function for assign expression.
     */
    public Expression assignExpression(Expression left, Expression right) {
        return new Mult(left, right);
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
        return new Plus(new Mult(getLeftExpression().differentiate(var), getRightExpression()),
                new Mult(getLeftExpression(), getRightExpression().differentiate(var)));
    }


    /**
     * Returned a simplified version of the current expression.
     *
     * @return Expression.
     */
    public Expression simplify() {

        Expression leftSimple = getLeftExpression().simplify();
        Expression rightSimple = getRightExpression().simplify();

        //0*x=0
        try {
            if (leftSimple instanceof Num) {


                if (0 == leftSimple.evaluate(super.getAssignment())) {
                    return (Expression) new Num(0);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        //x*0=0
        try {
            if (rightSimple instanceof Num) {


                if (0 == rightSimple.evaluate(super.getAssignment())) {
                    return (Expression) new Num(0);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        //1*x=x
        try {
            if (leftSimple instanceof Num) {

                if (1 == leftSimple.evaluate(super.getAssignment())) {
                    return rightSimple;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        //X*1=x
        try {
            if (rightSimple instanceof Num) {

                if (1 == rightSimple.evaluate(super.getAssignment())) {
                    return leftSimple;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Mult(leftSimple, rightSimple);
    }

}