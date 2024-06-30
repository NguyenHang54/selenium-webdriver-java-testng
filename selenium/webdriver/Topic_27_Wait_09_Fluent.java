package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Topic_27_Wait_09_Fluent {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    WebDriverWait explicitwait;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement;

    FluentWait<String> fluentString;


    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // time - default polling time: 0.5s (500 milis)
        explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // time- polling: default polling time 0.3s
        explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));

        fluentDriver = new FluentWait<WebDriver>(driver);

    }

    @Test
    public void TC_01() {
        // KHOI TAO
        fluentDriver = new FluentWait<WebDriver>(driver);
        // khai bao element sau do truyen vao() or khai bao truc tiep
        WebElement element = driver.findElement(By.cssSelector(""));
        fluentElement = new FluentWait<WebElement>(element);

        fluentString = new FluentWait<String>("Hello Word!");

        // SETTING (Time, polling, exception)
        // xét tổng thời gian là bao nhiêu
        fluentDriver.withTimeout(Duration.ofSeconds(10));
        // Xet polling time: 0.3s
        fluentDriver.pollingEvery(Duration.ofMillis(300));
        // ignore exception: nếu chỉ có 1, dùng của selenium, ko phải của Java
        // ignore No such element exception
        fluentDriver.ignoring(NoSuchElementException.class);
        // ignore TimeoutException
        fluentDriver.ignoring(TimeoutException.class);
        // nếu có 2 exceptions
        // nếu có nhiều exceptions

        // CONDITION
        fluentDriver.until(new Function<WebDriver, Object>() {

            @Override
            public String apply(WebDriver webDriver) {
                return driver.findElement(By.cssSelector("")).getText();
            }
        });

        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(400))
                .ignoring(NoSuchElementException.class, TimeoutException.class)
                .until(new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return webDriver.findElement(By.cssSelector("")).isDisplayed();
                    }
                });


    }

    @Test
    public void TC_02_() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();

        // cho cho tu "Hello World" hien thi
        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(java.util.NoSuchElementException.class);

        // condition

        fluentDriver.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed();

            }
        });

        // condition: String
        String helloText = fluentDriver.until(new Function<WebDriver, String>() {

            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
            }
        });

        Assert.assertEquals(helloText, "Hello World!");

    }


    @Test
    public void TC_03() {
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countDownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));

        fluentElement = new FluentWait<WebElement>(countDownTime);

        fluentElement.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        fluentElement.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                String text = webElement.getText();
                System.out.println(text);
                return webElement.getText().endsWith("00");
            }
        });

    }

    // quit
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

