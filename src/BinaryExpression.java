import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * BinaryExpression Class.
 *
 * @author Tomer Yona
 */
public class BinaryExpression extends BaseExpression {


    private Expression leftExpression;
    private Expression rightExpression;
    private Map<String, Double> assignment;
    private List<String> varList;

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param leftExp  .
     * @param rightExp .
     */
    public BinaryExpression(Expression leftExp, Expression rightExp) {
        //super();


        this.leftExpression = leftExp;
        this.rightExpression = rightExp;
        this.varList = new ArrayList<String>();
        updateVariables();
        this.assignment = new TreeMap<String, Double>();
        assignment.put("e", 2.71828);
        assignment.put("Pi", 3.14);

    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param var .
     * @param num .
     */
    public BinaryExpression(String var, double num) {

        this.leftExpression = new Var(var);
        this.rightExpression = new Num(num);
        if (var.equals("e")) {
            this.leftExpression = new Num(2.71828);
        }
        if (var.equals("Pi")) {
            this.leftExpression = new Num(3.14159);
        }
        this.varList = new ArrayList<String>();
        this.assignment = new TreeMap<String, Double>();
        assignment.put("e", 2.71828);
        assignment.put("Pi", 3.14);


    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param num .
     * @param var .
     */
    public BinaryExpression(double num, String var) {
        this.leftExpression = new Num(num);
        this.rightExpression = new Var(var);
        if (var.equals("e")) {
            this.rightExpression = new Num(2.71828);
        }
        if (var.equals("Pi")) {
            this.rightExpression = new Num(3.14159);
        }

        this.varList = new ArrayList<String>();
        this.assignment = new TreeMap<String, Double>();
        assignment.put("e", 2.71828);
        assignment.put("Pi", 3.14);


    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param num1 .
     * @param num2 .
     */
    public BinaryExpression(double num1, double num2) {
        this.leftExpression = new Num(num1);
        this.rightExpression = new Num(num2);
        this.varList = new ArrayList<String>();
        this.assignment = new TreeMap<String, Double>();
        assignment.put("e", 2.71828);
        assignment.put("Pi", 3.14);
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param var1 .
     * @param var2 .
     */
    public BinaryExpression(String var1, String var2) {

        this.leftExpression = new Var(var1);
        this.rightExpression = new Var(var2);
        if (var1.equals("e")) {
            this.leftExpression = new Num(2.71828);
        }
        if (var1.equals("Pi")) {
            this.leftExpression = new Num(3.14159);
        }
        if (var2.equals("e")) {
            this.rightExpression = new Num(2.71828);
        }
        if (var2.equals("Pi")) {
            this.rightExpression = new Num(3.14159);
        }
        this.varList = new ArrayList<String>();
        this.assignment = new TreeMap<String, Double>();
    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param var1 .
     * @param exp2 .
     */
    public BinaryExpression(String var1, Expression exp2) {
        this.leftExpression = new Var(var1);
        this.rightExpression = exp2;
        this.varList = new ArrayList<String>();
        this.assignment = new TreeMap<String, Double>();

    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param exp1 .
     * @param var2 .
     */
    public BinaryExpression(Expression exp1, String var2) {
        this.leftExpression = exp1;
        this.rightExpression = new Var(var2);
        this.varList = new ArrayList<String>();
        this.assignment = new TreeMap<String, Double>();


    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param num1 .
     * @param exp2 .
     */
    public BinaryExpression(double num1, Expression exp2) {
        this.leftExpression = new Num(num1);
        this.rightExpression = exp2;
        this.varList = new ArrayList<String>();
        this.assignment = new TreeMap<String, Double>();


    }

    /**
     * constructor of BinaryExpression we also update the variable list of expression.
     *
     * @param exp1 .
     * @param num2 .
     */
    public BinaryExpression(Expression exp1, double num2) {

        this.leftExpression = exp1;
        this.rightExpression = new Num(num2);
        this.varList = new ArrayList<String>();
        this.assignment = new TreeMap<String, Double>();


    }

    /**
     * constructor for binaryExpression.
     *
     * @param expression .
     */
    public BinaryExpression(Expression expression) {
        super(expression);
    }


    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment1 .
     * @return double .
     * @throws Exception .
     */

    public double evaluate(Map<String, Double> assignment1) throws Exception {

        return 0;
    }


    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return double
     * @throws Exception .
     */

    public double evaluate() throws Exception {
        return 0;
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return List
     */

    public List<String> getVariables() {
        updateVariables();
        return this.varList;

    }

    /**
     * this function updates the variable list accoring to the current expression fields, left & right.
     */
    public void updateVariables() {

        if (getLeftExpression().getVariables() == null & getRightExpression().getVariables() == null) {
            return;
            // might need to return here a new list
        } else if (getLeftExpression().getVariables() == null && getRightExpression().getVariables() != null) {
            this.setVarList(rightExpression.getVariables());
        } else if (getLeftExpression().getVariables() != null && getRightExpression().getVariables() == null) {
            this.setVarList(leftExpression.getVariables());
        } else {
            List<String> leftVar = new ArrayList<String>(getLeftExpression().getVariables());
            List<String> rightVar = new ArrayList<String>(getRightExpression().getVariables());
            List<String> toReturn = new ArrayList<String>(getLeftExpression().getVariables());
            for (String v1 : leftVar) {
                for (String v2 : rightVar) {
                    if (!v1.equals(v2)) {
                        if (!toReturn.contains(v2)) {
                            toReturn.add(v2);
                        }
                        if (!toReturn.contains(v1)) {
                            toReturn.add(v1);
                        }

                    } else {
                        if (!toReturn.contains(v1)) {
                            toReturn.add(v1);
                        }
                    }
                }
            }
            setVarList(toReturn);
        }
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     * need to get rid of var from var list
     *
     * @param var        .
     * @param expression .
     * @return Expression
     */

    public Expression assign(String var, Expression expression) {
        //updateVariables(var);
        return assignExpression(getLeftExpression().assign(var, expression),
                getRightExpression().assign(var, expression));
    }

    /**
     * auxilary function for assign Expression.
     *
     * @param left  .
     * @param right .
     * @return Expression
     */
    public Expression assignExpression(Expression left, Expression right) {
        return (Expression) new BinaryExpression(left, right);
    }

    /**
     * updates a list of variables.
     *
     * @param var .
     */
    public void updateVariables(String var) {
        for (String v : this.getVariables()) {
            if (v.equals(var)) {
                this.getVariables().remove(v);
            }
        }
    }


    /**
     * Returned a simplified version of the current expression.
     *
     * @return Expression .
     */

    public Expression simplify() {
        return null;
    }

    /**
     * getter.
     *
     * @return Expression.
     */
    public Expression getLeftExpression() {
        return leftExpression;
    }

    /**
     * getter.
     *
     * @return Expression.
     */
    public Expression getRightExpression() {
        return this.rightExpression;

    }

    /**
     * setter for expression.
     *
     * @param expression .
     */
    public void setLeftExpression(Expression expression) {
        this.leftExpression = expression;

    }

    /**
     * setter for expression.
     *
     * @param expression .
     */
    public void setRightExpression(Expression expression) {
        this.rightExpression = expression;
    }

    /**
     * setter for var list.
     *
     * @param newVarList .
     */
    public void setVarList(List<String> newVarList) {
        this.varList = newVarList;
    }

    /**
     * getter for map.
     * @return Map .
     */
    public Map<String, Double> getAssignment() {
        return assignment;
    }
}
