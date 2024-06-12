package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_20_Wait_01_Element_Status {
    WebDriver driver;
    WebDriverWait explicitwait;

    By reconfirmEmailTextbox = By.cssSelector("input[name='reg_email_confirmation__']");


    @BeforeClass
    public void beforeClass() {
        //driver = new FirefoxDriver();
        driver = new FirefoxDriver();
        explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Visible() {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInsecond(2);
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("hangtest@gmail.com");
        sleepInsecond(3);

        // tại thời điểm này thì confirm email textbox đang hiển thị > apply wait visible
        explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        // make sure la textbox do displayed/ visible > verify

        Assert.assertTrue(driver.findElement(reconfirmEmailTextbox).isDisplayed());

    }

    @Test
    public void TC_02_Invisible_In_Dom() {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInsecond(2);
        // element ko xuất hiện trên UI nhưng vẫn có trên cây HTML
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInsecond(3);

        explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());


    }

    @Test
    public void TC_03_Invisible_Not_In_Dom() {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInsecond(2);
        // element ko xuất hiện trên UI và cả cây HTML
        // click on icon Close to close popup
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInsecond(3);
        // tại thời điểm này nó trở thành invisible trên UI and HTML tree
        explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        // ko dung assert vi se throw error: no such element, not in DOM

    }

    @Test
    public void TC_04_presence() {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInsecond(2);
        // click on icon Close to close popup
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("hangtest@gmail.com");
        sleepInsecond(3);
        // use PresenceofElementLocated, co trong HTML
        // dk 1: element co trong ca UI va HTML
        explicitwait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();

        //dk2: element ko co trong UI va nhung xuat hien tren HTML

       // explicitwait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));


    }
    @Test
    public void TC_04_staleness(){
        // element ko xuat hien tren UI va HTML
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInsecond(2);
        // click on icon Close to close popup
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("hangtest@gmail.com");
        sleepInsecond(3);
        // tai thoi diem nay co va xuat hien element

        WebElement reconfirmEmail = driver.findElement(reconfirmEmailTextbox);

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInsecond(3);

        // stalensessof phai truyen vao 1 Element, nen phai tao 1 element o tren
        explicitwait.until(ExpectedConditions.stalenessOf(reconfirmEmail));
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
}

