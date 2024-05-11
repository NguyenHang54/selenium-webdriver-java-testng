package javaTester;

import java.util.Random;

public class Topic_04_Random {
    public static void main (String[] args){
        Random rand= new Random();
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());

        System.out.println(rand.nextDouble());
        System.out.println(rand.nextBoolean());
        System.out.println(rand.nextFloat());

    }
}
