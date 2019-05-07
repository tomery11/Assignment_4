public class SimplificationDemo {


    public static void main(String [] args){

        //((x^y)^z)---> (x^(y * z))
        Expression e1 = new Pow(new Pow("x","y"),"z");
        System.out.println(e1.toString());
        System.out.println(e1.simplify().toString());
    }

}
