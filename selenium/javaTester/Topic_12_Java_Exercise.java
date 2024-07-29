package javaTester;

import org.testng.annotations.Test;

public class Topic_12_Java_Exercise {
    @Test
    public void TC_01 (){
        int a = 6;
        int b = 2;

        System.out.println("Tong = "+ (a+b));
        System.out.println("Hieu = "+ (a-b));
        System.out.println("Tich = "+ (a*b));
        System.out.println("Thuong = "+ (a/b));

    }

    @Test
    public void TC_02 (){
        float width = 7.5f;
        float height = 3.8f;

        System.out.println("S = " + (width*height));
    }

    @Test
    public void TC_03(){
        String name=  "Automation Testing";
        System.out.println(" Hello "+ name);

    }
    @Test
    public void TC_04_swapNumber(){
        int a= 5;
        int b=6;
        a = a + b;
        b= a - b;
        a = a -b ;
        System.out.println(a);
        System.out.println(b);

    }
    @Test
    public void TC_05_Compare(){
        int a = 5;
        int b = 4;
        if (a > b){
            System.out.println(true);
        }

        int x = 4;
        int y =5;
        if(x<y){
            System.out.println(false);
        }

    }

    @Test
    public void TC_06_Age(){
        String name ="Tuan";
        int P1 = 23;
        int P2 = P1 + 15;
        System.out.println("After 15 years"+ "," +"age of Tuan will be "+  P2);

    }
}
