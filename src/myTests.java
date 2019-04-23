import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class myTests {

    public static void main(String[] args) throws Exception {
        Map<String, Double> assignment1 = new TreeMap<String, Double>();

        assignment1.put("x", 2.0);
        assignment1.put("y", 4.0);


        Num four = new Num(4);
        Num two = new Num(2);
        //test number 1 - simple plus test
        System.out.println("test number 1, plus test: ");
        Expression e1 = new Plus(new Num(2), new Num(4));
        e1.toString();
        System.out.println(e1);

        //test number 2 - simple minus test
        System.out.println("test number 2, minus test: ");
        Expression e2 = new Minus(four, two);
        System.out.println(e2.toString());
        System.out.println(e2.evaluate() == 2);


        //test number 3 - simple plus test
        System.out.println("test number 3, plus test with Var Object: ");
        Var x = new Var("x");
        Var y = new Var("y");
        Expression e3 = new Plus(x, y);
        System.out.println(e3.toString());
        System.out.println("test number 4, minus test with Var Object: ");
        Expression e4 = new Minus(x, four);
        System.out.println(e4.toString());
        Expression e_m2 = e4.assign("x", new Num(3));
        System.out.println("test 4 should print true");
        System.out.println(e4.evaluate(assignment1));
        System.out.println(e_m2.evaluate() == -1);
        System.out.println("test number 5, toString var: ");

        System.out.println(x.toString());

        Expression e6 = new Plus(new Var("x"), new Var("y"));
        System.out.println("test number 6, print var list (getVariables) should print:\nx\ny\n");
        List<String> vars = e6.getVariables();
        for (String v : vars) {
            System.out.println(v);
        }


        System.out.println("test number 7, print var list (getVariables) shouldn't print anything: ");
        List<String> vars2 = e1.getVariables();
        for (String v : vars2) {
            System.out.println(v);
        }

        System.out.println("test number 8, print a complex math exp: should print (4.0 + (2.0 + 2.0))");
        Expression e8 = new Plus(four, new Plus(two, two));
        System.out.println(e8.toString());

        System.out.println();
        System.out.println("test number 9, print ans of (4.0 + (2.0 + 2.0)) == 8.0");
        System.out.println(e8.evaluate() == 8);
        System.out.println();
        System.out.println("test number 10 contructor shortcut:");
        Expression e10 = new Plus("x", 3);
        System.out.println(e10.toString().equals("(x + 3.0)"));
        System.out.println();
        System.out.println("test number 11 Multiply:");
        Expression e11 = new Mul(5, 3);
        System.out.println(e11.evaluate() == 15);
        System.out.println();
        System.out.println("test number 12 Multiply:");
        System.out.println(e11.toString().equals("(5.0 * 3.0)"));
        System.out.println();
        System.out.println("test number 13 Multiply:");
        Expression e13 = new Mul("x", 3);
        System.out.println(e13.toString().equals("(x * 3.0)"));

        System.out.println();
        System.out.println("test number 14 complex Expression:");
        Expression e14 = new Mul(new Minus(4, 2), new Plus(3, 2));
        System.out.println(e14.toString());
        System.out.println(e14.evaluate());

        //this is good
        System.out.println("test number 15 complex Expression:");
        Expression e15 = new Plus(new Var("x"), new Var("y"));
        e15.getVariables();
        String s = e15.toString();
        System.out.println(s);


        System.out.println("test number 16 assign test: should be (x + (x + y))");
        Expression e16 = e15.assign("y", e15);
        System.out.println(e16);
        System.out.println("test number 17 complex var list test:");
        List<String> vars3 = e16.getVariables();
        for (String v : vars3) {
            System.out.println(v);
        }


        System.out.println("test for string, exp");
        Expression e18 = new Plus("x", e1);
        System.out.println(e18.toString());
        List<String> vars4 = e18.getVariables();
        for (String v : vars4) {
            System.out.println(v);
        }

        System.out.println("test for double, string");
        Expression e19 = new Plus(2, "y");
        System.out.println(e19.toString());
        List<String> vars5 = e19.getVariables();
        for (String v : vars5) {
            System.out.println(v);
        }

        System.out.println("test for string, double should print x");
        Expression e20 = new Plus("x", 2);
        System.out.println(e20.toString());
        List<String> vars6 = e20.getVariables();
        for (String v : vars6) {
            System.out.println(v);
        }

        Expression e21 = e20.assign("x", new Num(4));
        System.out.println("test 21: assign test for plus ");
        System.out.println(e21.toString());
        System.out.println(e21.toString().equals("(4.0 + 2.0)"));
        System.out.println(e21.evaluate());

        Map<String, Double> assignment = new TreeMap<String, Double>();
        System.out.println(e20.toString());
        assignment.put("x", 2.0);
        assignment.put("y", 4.0);
        System.out.println("after assignment");
        double value = e20.evaluate(assignment);
        System.out.println(value);
        System.out.println(value == 4);
        System.out.println(e19.toString());
        System.out.println(e19.evaluate(assignment) == 6);


        System.out.println("should print (x+(y+z))");
        Expression e22 = new Plus("x", new Plus("y", "z"));
        System.out.println(e22.toString());
        List<String> vars7 = e22.getVariables();
        for (String v : vars7) {
            System.out.println(v);
        }

        System.out.println("test 24 UnaryExpression test sin(90)");
        Expression e23 = new Sin(90);
        System.out.println(e23.toString());
        System.out.println(e23.evaluate());

        System.out.println("test 24 UnaryExpression test sin(90)");
        Expression e24 = new Sin("x");
        System.out.println(e24.toString());
        System.out.println(e24.evaluate(assignment));
        List<String> vars8 = e24.getVariables();
        for (String v : vars8) {
            System.out.println(v);
        }

        System.out.println();
        System.out.println("test 25 complex expression");
        Expression e25 = new Sin(new Mul(new Plus(new Num(2), new Mul(new Num(2), new Var("x"))),
                new Num(5)));
        System.out.println(e25.toString());

        System.out.println();
        System.out.println("test 26 const");
        Expression e26 = new Mul("e", 2);
        System.out.println(e26.toString());
        System.out.println(e26.evaluate());


        System.out.println();
        System.out.println("test 27 const");
        Expression e27 = new Mul(4, "Pi");
        System.out.println(e27.toString());
        System.out.println(e27.evaluate());

        System.out.println();
        System.out.println("test 28 derivative pow");
        Expression e28 = new Pow("x", 4);
        System.out.println(e28.toString());
        Expression e29 = e28.differentiate("x");
        System.out.println(e29.toString());

        System.out.println();
        System.out.println("test 29 dervative");
        Expression e30 = new Div("x", 4);
        System.out.println(e30.toString());
        Expression e31 = e30.differentiate("x");
        System.out.println(e31.toString());


        System.out.println();
        System.out.println("simplify mul test 30");
        Expression e32 = new Mul(1, "x");
        System.out.println(e32.toString());

        System.out.println(e32.simplify().toString());
/*
        Expression e33 = new Mul(3, 0);
        System.out.println(e33.toString());
        System.out.println(e33.simplify().toString());
*/
        //System.out.println(new Sin("Pi").evaluate());

/*
        System.out.println("test number 17 assignment map- result should be 36:");
        Map<String, Double> assignment = new TreeMap<String, Double>();
        assignment.put("x", (double) 2);
        assignment.put("y", (double) 4);
        double value = e15.evaluate(assignment);
        System.out.println("The result is: " + value);


        System.out.println("test number 14, Evaluate with map: ");
        Expression e9 = new Plus("x", 5);
        e9.assign("x", new Num(5));
        System.out.println(e9.evaluate() == 10);
*/
    }
}
