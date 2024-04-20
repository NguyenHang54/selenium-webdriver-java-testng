package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_03_Relative_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");
        //Login button
        By loginButtonBy = By.cssSelector("button.login-button");
        WebElement LoginButtonElement = driver.findElement(By.cssSelector("button.login-button"));

        // forgot-password

        By forgotPasswordElement = By.cssSelector("span.forgot-password");
        //System.out.println(forgotPasswordBy);
       //WebElement forgotPasswordElement = driver.findElement(By.cssSelector("span.forgot-password"));

        // Remember me checkbox

        By rememberMeCheckboxBy = By.id("RememberMe");

        // password Textbox

        By passwordTextboxBy =By.cssSelector("input#Password");


        WebElement rememberMeTextElement= driver.findElement(RelativeLocator.with(By.tagName("label"))
            .above(loginButtonBy)
              .toRightOf(rememberMeCheckboxBy)
               .toLeftOf(forgotPasswordElement)
                .below(passwordTextboxBy)
                .near(forgotPasswordElement));

       System.out.println(rememberMeTextElement.getText());

    }

    @AfterClass
    public void afterclass() { driver.quit();}

}



