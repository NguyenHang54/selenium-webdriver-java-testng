package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class Topic_03_Assert {
     WebDriver driver;
    @Test
    public void verifyTestNG(){
     driver.get("https://www.facebook.com/");

// trong Java có nhieu thư viện để verify
// Testing Framework (Unit, Integration, UI Automation
//Junit4, testNG, Junit5,
        // kiểu dữ liệu nhận vào là boo (true/false)
        // khi mong muốn đk trả về đúng thì dùng True thì dùng Assert True
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));

        // khi mong muốn đk trả về sai thì dùng Assert False
        Assert.assertFalse(driver.getPageSource().contains("Create new Account"));

        // cac ham tra ve kieu du lieu la boolean thi tra ve du lieu kieu True/False
        // Rule: bat dau voi tien to la is....
        // webElement
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();

        // Assert equal: mog doi Expected = Actual, tuyet doi
        Assert.assertEquals(driver.findElement(By.id("")).getText(),"Create new Account");

        // thuong dung cho Unit Test, cho 1 object
        Object name= null;
        Assert.assertNull(name);

        name = "H Test";
        Assert.assertNotNull(name);







    }

}
