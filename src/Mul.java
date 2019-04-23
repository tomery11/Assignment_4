import java.util.List;
import java.util.Map;

public class Mul extends BinaryExpression implements Expression {

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param leftExp
     * @param rightExp
     */
    public Mul(Expression leftExp, Expression rightExp) {
        super(leftExp, rightExp);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param var
     * @param num
     */
    public Mul(String var, double num) {
        super(var, num);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param num
     * @param var
     */
    public Mul(double num, String var) {
        super(num, var);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param num1
     * @param num2
     */
    public Mul(double num1, double num2) {
        super(num1, num2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param var1
     * @param var2
     */
    public Mul(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param var1
     * @param exp2
     */
    public Mul(String var1, Expression exp2) {
        super(var1, exp2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param exp1
     * @param var2
     */
    public Mul(Expression exp1, String var2) {
        super(exp1, var2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param num1
     * @param exp2
     */
    public Mul(double num1, Expression exp2) {
        super(num1, exp2);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param exp1
     * @param num2
     */
    public Mul(Expression exp1, double num2) {
        super(exp1, num2);
    }

    public Mul(Expression expression) {
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

        BinaryExpression toCalc = new Mul(tempLeftExp, tempRightExp);
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
        return super.getLeftExpression().evaluate() * super.getRightExpression().evaluate();

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
    public Expression assignExpression(Expression left, Expression right) {
        return new Mul(left, right);
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
        return new Plus(new Mul(getLeftExpression().differentiate(var), getRightExpression()),
                new Mul(getLeftExpression(), getRightExpression().differentiate(var)));
    }

    // Returned a simplified version of the current expression.
    public Expression simplify(){
        try {
            if (1 == getLeftExpression().evaluate() && 1 != getRightExpression().evaluate()){
                return getRightExpression();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if( 1== getRightExpression().evaluate() && 1!= getLeftExpression().evaluate()){
                return getLeftExpression();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (0 == getLeftExpression().evaluate() && 1 != getRightExpression().evaluate()){
                return (Expression) new Num(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if( 0== getRightExpression().evaluate() && 1!= getLeftExpression().evaluate()){
                return (Expression) new Num(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

}