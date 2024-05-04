package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Scope {
  // cac bien duoc khai bao ngoai ham >> pham vi la class
  // Bien Global (toan cuc)


    WebDriver driver;
    String homePageURL ="https://facebook.com/";; // khai bao: Declare
    String fullName ="Automation FC"; // khai bao + khoi tao (initial)


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }
    @Test
    public void TC_01_(){
        // cac bien dc khai bao trong ham/ pham vi >> bien cuc bo
        String homePageURL ="https://facebook.com/";
        // trong 1 ham neu co 2 bien trung ten (global/local) thi uu tien lay bien local dung
        // bien local dc goi ma chua khoi tao thi se loi
        // bien local chua goi ra ma dung cung se loi
        driver.get(homePageURL); // goi bien local
        driver.get(this.homePageURL); // goi toi bien Global, dung this.

        driver.getCurrentUrl();


    }
    @Test
    public void TC_02_(){}

    @Test
    public void TC_03_(){}

    @Test
    public void TC_04_(){}

    @AfterClass

    public void afterClass (){
        driver.quit();
    }
    }




