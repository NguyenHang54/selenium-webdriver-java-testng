package javaTester;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_12_Java_Exercise {
    WebDriver driver;
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01() {
        int a = 6;
        int b = 2;

        System.out.println("Tong = " + (a + b));
        System.out.println("Hieu = " + (a - b));
        System.out.println("Tich = " + (a * b));
        System.out.println("Thuong = " + (a / b));

    }

    @Test
    public void TC_02() {
        float width = 7.5f;
        float height = 3.8f;

        System.out.println("S = " + (width * height));
    }

    @Test
    public void TC_03() {
        String name = "Automation Testing";
        System.out.println(" Hello " + name);

    }

    @Test
    public void TC_04_swapNumber() {
        int a = 5;
        int b = 6;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);

    }

    @Test
    public void TC_05_Compare() {
        int a = 5;
        int b = 4;
        if (a > b) {
            System.out.println(true);
        }

        int x = 4;
        int y = 5;
        if (x < y) {
            System.out.println(false);
        }

    }

    @Test
    public void TC_06_Age() {
        String name = "Tuan";
        int P1 = 23;
        int P2 = P1 + 15;
        System.out.println("After 15 years" + "," + "age of Tuan will be " + P2);

    }

    @Test
    public void TC_07_inputFromMainScreen() {
        int age = scanner.nextInt();
        System.out.println(age);
    }

    @Test
    public void TC_08_chiaHetCho2() {

        //int number = scanner.nextInt(); : nhap vao tu man hinh
        int number = 34;
        if (number % 2 == 0) {
            System.out.println("so : " + number + " la so chan");
        } else {
            System.out.println("so :" + number + " la so le");
        }
    }

    @Test
    public void TC_09() {
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        if (numberA > numberB) {
            System.out.println(numberA + " lon hon or bang" + numberB);
        } else if (numberA == numberB) {
            System.out.println(numberA + "bang " + numberB);
        } else {
            System.out.println(numberA + " nho hon" + numberB);
        }
    }

    @Test
    public void TC_10() {
        String studentA = scanner.nextLine();
        String studentB = scanner.nextLine();
        if (studentA.equals(studentB)) {
            System.out.println(studentA + " giong ten" + studentB);
        } else {
            System.out.println(studentA + "khac ten" + studentB);
        }
    }

    @Test
    public void TC_11() {
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        int numberC = scanner.nextInt();

        if (numberA > numberB && numberA > numberC) {
            System.out.println(numberA + " la so lon nhat ");
        } else if (numberB > numberC) {
            System.out.println(numberB + " la so lon nhat");
        } else {
            System.out.println(numberC + " la so lon nhat");
        }
    }

    @Test
    public void TC_12() {
        int numberA = scanner.nextInt();
        if (10 < numberA && numberA < 100) {
            System.out.println(numberA + " nam trong khoang");
        } else {
            System.out.println(numberA + "nam ngoai khoang");
        }
    }

    @Test
    public void TC_13() {
        float score = scanner.nextFloat();
        if (score >= 0 && score < 5) {
            System.out.println(score + " la D");
        } else if (score >= 5 && score < 7.5) {
            System.out.println(score + " la C");
        } else if (score >= 7.5 && score < 8.5) {
            System.out.println(score + "la B");
        } else {
            System.out.println(score + "la A");
        }
    }

    @Test
    public void TC_14(){
        int month = scanner.nextInt();

        //1 3/5/7/8/10/12
        if (month == 1| month ==3 | month ==5| month==7| month ==8| month==10| month==12|){
            System.out.println("Thang nay co 31 ngay");
        } else if (month == 2) {
            System.out.println(" thang nay co 28 ngay");
        }else {
            System.out.println("thang nay co 30 ngay");
        }
    }
}

