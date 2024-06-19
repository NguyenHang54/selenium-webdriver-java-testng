package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import java.util.List;

public class Topic_21_Wait_02_Find_Element {
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
        driver.get("https://www.facebook.com/");

    }

    @Test
    public void TC_01_FindElement() {
        // case1: element dc tim thay nhung chi co 1
        // se ko can cho het timeout
        // tim thay se tra ve 1 webElement
        System.out.println("Start Step:  " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#email"));
        System.out.println("End Step: " + getDateTimeNow());

        // case2: element đc tìm thấy có hơn 1 node
        // lấy element đầu tiên dù có n node
       // driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("hangtest@gmail.com");

        // case3: element ko dc tim thay
        // chờ hết time-out là 10s, mỗi nửa s sẽ tìm lại 1
        // nếu tìm lại mà thấy cũng trả về element rồi qua step tiêp stheo
        // nếu tìm lại mà hết timeout thì đánh fail  và throw exception: nosuchElement
        //driver.findElement(By.cssSelector("input#not-found"));


    }

    @Test
    public void TC_01_FindElements() {
        List<WebElement> elementList;
        // case1: element dc tim thay nhung chi co 1
        //System.out.println("Start Step:  " + getDateTimeNow());
        //elementList= driver.findElements(By.cssSelector("input#email"));
       // elementList.get(0).sendKeys("");
        // co bao nhieu item trong list nay
        //System.out.println("List have: " + elementList.size());
        //System.out.println("End Step: " + getDateTimeNow());


        // case2: element đc tìm thấy có hơn 1 node
       System.out.println("Start Step:  " + getDateTimeNow());
        elementList=driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
        System.out.println("List have:"+ elementList.size());
        System.out.println("End Step: " + getDateTimeNow());


        // case3: element ko dc tim thay

        //System.out.println("Start Step:  " + getDateTimeNow());
        //driver.findElements(By.cssSelector("input[name='reg_email__']"));
        //System.out.println("End Step: " + getDateTimeNow());

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

