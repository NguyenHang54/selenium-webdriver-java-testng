package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands_02_Practice {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void TC_01_Verify_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
          if (driver.findElement(By.cssSelector("input#email")).isDisplayed()){
            driver.findElement(By.cssSelector("input#email")).sendKeys("Automation Testing");
            System.out.println("Email Textbox is displayed");
        }
        else
          {
              System.out.println("Email Textbox is not displayed");
          }


        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("under_18 is displayed");
        }
        else
        {
            System.out.println("under_18 is not displayed");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed())
        {
        driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
        System.out.println("edu textarea is displayed");}
        else
        {
            System.out.println("edu textarea is not displayed");
        }

        if (driver.findElement(By.cssSelector("//h5[text()='Name: User5']")).isDisplayed())
        {
            System.out.println("Name User 5 is displayed");
        }
        else
        {
            System.out.println("Name User 5 is not displayed");
        }

    }

    @Test
    public void TC_02_Verify_Enabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#email")).isDisplayed()) {
            System.out.println("email textbox is enable");
        } else {
            System.out.println("Email textbox is not disable");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isEnabled()) {
            System.out.println("under 18 is enable");
        } else {
            System.out.println("under 18 is disable");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            System.out.println("Edu textare is enable");
        } else {
            System.out.println("Edu textarea is disable");
        }

        if (driver.findElement(By.xpath("//label[@for='slider-1']")).isEnabled())
        {
            System.out.println("slider-1 is enable");
        }
        else
        {
            System.out.println("slider-1 is disable");
        }
        if (driver.findElement(By.cssSelector("input#Development")).isEnabled())
        {
            System.out.println("Development is enable");}
        else {
            System.out.println("Development is disable");
        }

        if (driver.findElement(By.cssSelector("input#check-disbaled")).isEnabled())
        {
            System.out.println("check disabled is enable");}
        else {
            System.out.println("check disabled is disable");
        }

        if (driver.findElement(By.cssSelector("textarea#bio")).isEnabled()) {
            System.out.println("bio is enabled");
        } else {
            System.out.println("bio is disable");
        }

        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("disabled password is enabled");
        } else {
            System.out.println("disabled password is disable");
        }
    }


    @Test
    public void TC_03_verify_selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.cssSelector("input#under_18")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());

        driver.findElement(By.cssSelector("input#java")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());

        sleepInSeconds(3);

        driver.findElement(By.cssSelector("input#java")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#java")).isSelected());

    }

    @Test
    public void TC_04_Verify_Mailchimp() {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("hangtest@gmail.com");
        sleepInSeconds(3);

        // case1: input number only
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("145");
        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed();

        // case2: input lower-case
        driver.findElement(By.cssSelector("input#new_password")).clear();

        driver.findElement(By.cssSelector("input#new_password")).sendKeys("abc");
        driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed();

        // case3: input upper-case
        driver.findElement(By.cssSelector("input#new_password")).clear();

        driver.findElement(By.cssSelector("input#new_password")).sendKeys("ABC");
        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed();


        // case4: input special
        driver.findElement(By.cssSelector("input#new_password")).clear();

        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@#$");
        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed();

        // case5: input special
        driver.findElement(By.cssSelector("input#new_password")).clear();

        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@#$");
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed();


        // case6: input maxlength
        driver.findElement(By.cssSelector("input#new_password")).clear();

        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345678");
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed();


        // case7: valid data
        driver.findElement(By.cssSelector("input#new_password")).clear();

        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Test@12345");
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed();

        //case8: empty data

        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).click();
        sleepInSeconds(2);


        driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed();
        driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='8-char not completed']")).isDisplayed();


    }

    @Test
    public void Login_04_verify_Empty_Data() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);


        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");

    }
    @Test
    public void Login_05_verify_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys("1234@1234");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");

    }
    @Test
    public void Login_06_verify_Pass_Min() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");
        driver.findElement(By.cssSelector("button#send2")).click();


        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void Login_07_verify_Pass_Incorrect() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456789999");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(), "Invalid login or password.");
        sleepInSeconds(2);

    }

    @Test
    public void Login_08_Success_verify() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);

        String firstName="Automation", lastName="FC", emailAddress=getEmailAddress(), passWord="123456789";
        String fullName = firstName + " " + lastName;

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(passWord);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(passWord);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, Automation FC!");

        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        //logOut

        driver.findElement(By.cssSelector("a.skip-account")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        sleepInSeconds(5);

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#pass")).sendKeys(passWord);
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, Automation FC!");

        contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));


        // verify Account
        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute("value"),emailAddress);

    }


    @AfterClass
    public void afterClass()
    {
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
        return "Automation" + rand.nextInt(99999)+"@gmail.net";
    }
}
