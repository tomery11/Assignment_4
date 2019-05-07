import java.util.Map;
import java.util.TreeMap;

/**
 * Expression test class.
 *
 * @author Tomer Yona
 */
public class ExpressionsTest {
    /**
     * main function that runs a basic test.
     *
     * @param args .
     * @throws Exception .
     */
    public static void main(String[] args) throws Exception {

        Expression expTest = new Plus(new Plus(new Mult(2, "x"),
                new Sin(new Mult(4, "y"))), new Pow("e", "x"));
        System.out.println(expTest.toString());

        Map<String, Double> assignment1 = new TreeMap<String, Double>();
        assignment1.put("x", 2.0);
        assignment1.put("y", 0.25);
        //print Expression
        System.out.println(expTest.evaluate(assignment1));
        Expression dervative = expTest.differentiate("x");
        //print derivative
        System.out.println(dervative.toString());
        Expression simpleExp = dervative.simplify();
        //print evaluated dervavtive.
        System.out.println(simpleExp.evaluate(assignment1));
        //print simplify Expression.
        System.out.println(simpleExp.toString());

    }
}
