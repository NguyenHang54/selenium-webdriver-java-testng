package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class Topic_09_Parameter {

    WebDriver driver;

    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");


    @Parameters({"browser","version"})
    @BeforeClass
    public void beforeClass(String browserName, String browserVersion){
       driver = getBrowserDriver(browserName);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test()
    public void TC_01_LoginToSystem()  {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(passwordTextbox).sendKeys("111111");
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));

    }

    private WebDriver getBrowserDriver(String browserName){
        WebDriver driver;
        if(browserName.equals ("firefox")){
            driver = new FirefoxDriver();
        }else if (browserName.equals("chrome")){
            driver = new ChromeDriver();
        }else
        {
            driver = new EdgeDriver();
        }
        return driver;
    }

    private String etEnvironmentUrl(String environmentName ){
        String urlValue;
        if (environmentName.equals("dev")){
            urlValue = "http://dev.techpanda.org";
        } else if (environmentName.equals("testing")) {
            urlValue ="http://testing.techpanda.org";
        }
        else if (environmentName.equals("staging")) {
            urlValue ="http://staging.techpanda.org";
        }
        else if (environmentName.equals("live")) {
            urlValue ="http://live.techpanda.org";
        }else{
            throw new RuntimeException("Environment name is invalid");
        }
        return urlValue;
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
