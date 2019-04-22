import javax.naming.directory.Attributes;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * BaseExpression class.
 * @author Tomer Yona
 * @date 22.4.19
 */
public class BaseExpression  {
    private Expression exp;
    private Map<String, Double> assignment;
    private List<String> varList;

    /**
     * constructor of BaseExpression.
     * @param expression .
     */
    public BaseExpression(Expression expression) {
        this.exp= expression;
        this.varList = expression.getVariables();
        this.assignment = new TreeMap<String, Double>();
    }

    /**
     * defaul constructor of BaseExpression.
     */
    public BaseExpression() {
    }

    /**
     * basic getter.
     * @return Expression .
     */
    public Expression getExp() {
        return this.exp;
    }

    /**
     * basic setter.
     * @param exp .
     */
    public void setExp(Expression exp) {
        this.exp = exp;
    }

    /**
     * setter.
     * @param list .
     */
    public void setVarList(List<String> list){
        this.varList = list;
    }

    /**
     * getter for variables .
     * @return List .
     */
    public List<String> getVariables() {
        return this.varList;
    }
}
