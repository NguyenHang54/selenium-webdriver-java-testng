package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_23_Wait_04_Static_Dead_Hard {
    WebDriver driver;
    WebDriverWait explicitwait;

    FluentWait<WebDriver> fluentWait;


    @BeforeClass
    public void beforeClass() {
        //driver = new FirefoxDriver();
        driver = new FirefoxDriver();
        //explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(10));

    }

    @Test
    public void TC_01_equal5s() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        sleepInsecond(5);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_02_less_than_5second() {

        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        sleepInsecond(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_02_greater_than_5second() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        // nếu như dùng implicit/ Explicit/ fluent thì khi đk đc thoả mãn ko cần chờ hết time out
        // còn sleep cứng ko quan tâm
        sleepInsecond(10);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

}


    // quit
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInsecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

    public String getDateTimeNow() {
         Date date = new Date();
         return date.toString();

    }
}

