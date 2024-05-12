package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;



public class Topic_08_Dropdown {
    WebDriver driver;

    String firstName="Hana", lastName="Test", emailAddress= getEmailAddress();
    String companyName = "FPT" , passWord ="123456";
    String day ="15" , month ="May" , year = "2002";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01_Register(){
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));//selectByVisibleText("15")
        day.selectByVisibleText("15");
        Assert.assertFalse(day.isMultiple());
        Assert.assertEquals(day.getOptions().size(),32);

        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);


        driver.findElement(By.id("Email")).sendKeys(emailAddress);

        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(passWord);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(passWord);

        driver.findElement(By.id("register-button")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

    }
    @Test
    public void TC_02_verify_Info(){
        driver.findElement(By.cssSelector("a.register-continue-button")).click();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-logout")).click();
        driver.findElement(By.cssSelector("a.ico-login")).click();

        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(passWord);
        driver.findElement(By.cssSelector("button.login-button")).click();
        driver.findElement(By.cssSelector("a.ico-account")).click();
        sleepInSeconds(2);


        Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"),lastName);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year);

        Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"),emailAddress);
        Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"),companyName);
    }

@Test
public void TC_03_Run_On_Edge() {
    driver.quit();
}
    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress(){
        Random rand=new Random();
        return "Hana" + rand.nextInt(99999)+"@gmail.net";
    }

}




