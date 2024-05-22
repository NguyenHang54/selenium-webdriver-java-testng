package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_13_Actions {
    WebDriver driver;
    Actions actions;



    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        actions = new Actions(driver);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Hover(){
        actions.getActiveKeyboard();
        actions.click(driver.findElement(By.xpath(""))).perform();
        actions.click(driver.findElement(By.xpath(""))).build();
        // bai toan click and hold number, sau do select space
        actions.clickAndHold(driver.findElement(By.xpath("nguon")))
                .moveToElement(driver.findElement(By.xpath("dich")))
                .release().perform();

    }
    @Test
    public void TC_02_(){}

// quit
@AfterClass
public void afterClass() {
    driver.quit();
}

}


