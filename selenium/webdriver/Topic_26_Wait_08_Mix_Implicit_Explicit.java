package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Topic_26_Wait_08_Mix_Implicit_Explicit {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    WebDriverWait explicitwait;



    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
    @Test
    public void TC_01_Only_Implicit_Found(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.facebook.com/");

        //khi vào tìm element thì tìm thấy ngay
        // ko cần chờ hết timeout
        driver.findElement(By.cssSelector("input#email"));


    }
    @Test
    public void TC_02_Only_Implicit_Notfound(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.facebook.com/");

        // khi vào tìm element thì ko tìm thấy
        // mỗi nửa s tìm lại 1 lần, hết timeout sẽ bị fail testcase và throw exception
        driver.findElement(By.cssSelector("input#automation"));
    }

    @Test
    public void TC_03_Only_Exlicit_Found(){
        driver.get("https://www.facebook.com/");
        explicitwait = new WebDriverWait(driver,Duration.ofSeconds(5));
        explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

    }

    @Test
    public void TC_04_Only_Explicit_Notfound(){
        driver.get("https://www.facebook.com/");
        explicitwait = new WebDriverWait(driver,Duration.ofSeconds(5));

        explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
    }


    @Test
    public void TC_05_Mix_Explicit_Implicit(){
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        explicitwait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("input#email"));

        explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
        System.out.println("Start time: " + getDateTimeNow());
    }


    // quit
@AfterClass
public void afterClass() {
    driver.quit();
}
public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
}
}

