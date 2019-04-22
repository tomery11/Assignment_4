
import java.util.List;
import java.util.Map;

/**
 * UnaryExpression.
 * @author Tomer Yona
 * @date 22.4.19
 */
public class UnaryExpression extends BaseExpression {


    private Expression expression;
    Map<String, Double> assignment;
    private List<String> varList;

    /**
     * UnaryExpression constructor.
     * @param exp .
     */
    public UnaryExpression(Expression exp) {
        super(exp);
    }

    /**
     * UnaryExpression constructor.
     * @param var .
     */
    public UnaryExpression(Var var) {
        super(var);
    }

    /**
     * UnaryExpression constructor.
     * @param num .
     */
    public UnaryExpression(Num num) {
        super(num);
    }

    /**
     * UnaryExpression constructor.
     * @param var .
     */
    public UnaryExpression(String var) {
        super(new Var(var));
    }

    /**
     * UnaryExpression constructor.
     * @param num .
     */
    public UnaryExpression(double num) {
        super(new Num(num));
    }

    /**
     * Getter for expression field.
     * @return Expression
     */
    public Expression getExpression() {
        return super.getExp();
    }

    @Override
    /**
     * getter for variables
     */
    public List<String> getVariables() {
        return super.getVariables();
    }

    /**
     * evaluates the expression according to the map assingment.
     * @param assignment .
     * @return double
     * @throws Exception
     */
    double evaluate(Map<String, Double> assignment) throws Exception {

        return 0;
    }

    /**
     * evaluates an expression
     * @return double .
     * @throws Exception
     */
    double evaluate() throws Exception{
        return 0;
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     * @param var .
     * @param expression .
     * @return Expression .
     */
    Expression assign(String var, Expression expression){
        return assignExpression(getExpression().assign(var, expression));
    }

    /**
     * auxialry function for assign method.
     * @param assign .
     * @return Expression .
     */
    private Expression assignExpression(Expression assign) {
        return (Expression) new UnaryExpression(assign);
    }
}