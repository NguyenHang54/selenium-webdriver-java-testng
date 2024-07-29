package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_12_Dependencies {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void TC_01_CreateNewUser(){
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_02_ViewandSearchUser(){
    }

    @Test
    public void TC_03_UpdateExistingUser(){
    }

    @Test
    public void TC_04_MoveExistingUserToOtherRole(){
    }

    @Test
    public void TC_05_DeleteExistingUser(){
    }


    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}


