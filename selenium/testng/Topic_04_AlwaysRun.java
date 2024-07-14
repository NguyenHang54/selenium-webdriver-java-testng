package testng;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class Topic_04_AlwaysRun {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Run Before Class");
        // nó bị fail ở beforeClass thì các test case sẽ skip

    }

    @Test
    public void test01(){
        System.out.println("Run TC 01");
    }

    @Test
    public void test02(){
        System.out.println("Run TC 02");
    }

    @Test
    public void test03(){
        System.out.println("Run TC 03");
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
        System.out.println("Run After Class");
    }

}
