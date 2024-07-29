package javaTester;

public class Topic_11_Compare {
    int number =8 ;

    public static void main(String[] args){
        // 1 vùng nhớ cho biến x
        int x = 5 ;

        // 1 vùng nhớ cho biến y
        int y = x ;
        System.out.println("x = " + x );
        System.out.println(" y = " + y );

        y = 10;
       // System.out.println("x = " + x );
       // System.out.println(" y = " + y );

        Topic_11_Compare firstVariable = new Topic_11_Compare();
        Topic_11_Compare secondVariable = firstVariable;

        System.out.println("numer = " + firstVariable.number);
        System.out.println("number = " + secondVariable.number);

        secondVariable.number = 15;

        System.out.println("numer = " + firstVariable.number);
        System.out.println("number = " + secondVariable.number);

    }
}
