package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test
    public void TC_01_Displayed(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#email")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#email")).sendKeys("Hanna Test");
            System.out.println("Email Textbox is Displayed");
        }
        else
        {
            System.out.println("Email Textbox is not displayed");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("under 18 radio is Displayed");
        }
        else
        {
            System.out.println("under 18 radio is not displayed");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("University A");
            System.out.println("Education Textarea is Displayed");
        }
        else
        {
            System.out.println("Education Textarea is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("Name User 5 is Displayed");
        }
        else
        {
            System.out.println("Name User 5 is not displayed");
        }

    }

    @Test
    public void TC_02_Enabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.cssSelector("input#email")).isEnabled()) {
            System.out.println("email textbox is enabled");
        } else {
            System.out.println("Email textbox is disable");
        }

        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("Password is enabled");
        } else {
            System.out.println("Password is disable");
        }

        if (driver.findElement(By.cssSelector("input#check-disbaled")).isEnabled()) {
            System.out.println("Checkbox is enabled");
        } else {
            System.out.println("Checkbox is disable");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isEnabled()) {
            System.out.println("education is enabled");
        } else {
            System.out.println("education is disable");
        }

    }
    @Test
    public void TC_03_Selected(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.cssSelector("input#under_18")).click();

        driver.findElement(By.cssSelector("input#java")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());

        driver.findElement(By.cssSelector("input#java")).click();
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#java")).isSelected());

    }

    @Test
    public void TC_04_MailChimp(){
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("Hanatest@gmail.com");
        sleepInSeconds(3);

        // case1: Number only
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("123");
        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed();


        // case2: Lower case

        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("abc");
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed();


        // case3: Upper case
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("ABC");
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed();

        // case4: Special Characters
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@#$^%");
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed();

        // case5: maxlength
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345678");
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed();

        // case6: valid data
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Auto@3456!@");
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed();

        // case7: Empty Data
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        sleepInSeconds(2);


        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed();

    }



    @AfterClass
    public void afterClass(){driver.quit();}
    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}


