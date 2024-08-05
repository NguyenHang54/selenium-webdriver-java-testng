package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Topic_15_Condition_Statement {
    public static void main(String[] args) {
        WebDriver driver = null;
        boolean status = 5 < 3;
        System.out.println(!status);
        //Hàm if sẽ nhận vào 1 đk đúng
        // Kiểm tra duy nhất 1 đk
        // nếu dkd đúng thì sẽ  trong phần thân
        if (status) {
            // đúng thì vào phần thân của if
            // sai thì bỏ qua
            System.out.println("Go to If");
        }

        int studentNumber = 10;
        status = (studentNumber == 10);
        System.out.println(status);

        // Uncheck to checkbox
        WebElement languageCheckbox = driver.findElement(By.id(""));
        if (languageCheckbox.isDisplayed()) {
            languageCheckbox.click();
        }
        // check to checkbox:nếu chưa chọn thì click dùng !()
        if (!languageCheckbox.isDisplayed()) {
            languageCheckbox.click();
        }

        // điều kiệnh if else
        if (driver.toString().contains("Internet Explorer")) {
            System.out.println("Click by Java Expcutor");
        } else {
            System.out.println("Click by Selenium WebElement");
        }

        // điều kiện if else if else
    }
    public void TC_03_If_else_double(String browserName){
        String chrome , firefox, edge, ie;
       // if (browserName.equalsIgnoreCase(chrome)){
         //   System.out.println("run with Chrome");
        // } else if (browserName.equalsIgnoreCase(firefox)) {
       //     System.out.println("run with firefox");
       // } else if (browserName.equalsIgnoreCase(edge)) {
       //     System.out.println("run with Edge");
      //  } else if (browserName.equalsIgnoreCase(ie)) {
        //    System.out.println("Run with IE");
      //  } else{
     //       throw new RuntimeException("please correct the Browser name");
        }

     //   int age = 20;
        // cach 1
      //  int ageX =20;
      //  String access = (ageX<18) ? "you can not access" : "welcome to our system!";

        // cach 2
       // if (age <18){
          //  access = "you can not access";
       // }else {
          //  access = "welcome to our system!";
        //}

    }
