package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.support.Color; // import color of selenium
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Button {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Egov_button() {
        driver.get("https://egov.danang.gov.vn/reg");

       WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));
       Assert.assertFalse(registerButton.isEnabled());
       System.out.println(registerButton.getCssValue("background-color"));
       String registerBackgroundRGB = registerButton.getCssValue("background-color");
       Color registerBackgroundColour = Color.fromString(registerBackgroundRGB);

        String registerBackgroundHexa = registerBackgroundColour.asHex();
        System.out.println("Background Color Hexa + " + registerBackgroundHexa);
        Assert.assertEquals(registerBackgroundHexa.toLowerCase(), "#ef5a00");

        //Assert.assertEquals(Color.fromString(registerButton.getCssValue("background-color")).asHex().toLowerCase(),"rgb(239, 90, 0)");

    }

    @Test
    public void TC_02_Fahasha() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-item.popup-login-tab-login")).click();
        sleepInsecond(2);

        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));

        // Verify login button is disabled

        Assert.assertFalse(loginButton.isEnabled());
        // verify background color

        System.out.println(loginButton.getCssValue("background-color"));

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("hangtest@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");

        // verify login button
        Assert.assertTrue(loginButton.isEnabled());
        // verify background color
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#c92127");

        System.out.println(loginButton.getCssValue("background-color"));

    }

    // quit
    @Test
    public void TC_03_Run_On_Edge() {
        driver.quit();
    }

    public void sleepInsecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


