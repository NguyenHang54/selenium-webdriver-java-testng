package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.internal.Utils.log;

public class Topic_17_Window_Tab {
    private static final Logger log = LoggerFactory.getLogger(Topic_17_Window_Tab.class);
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Basic_Form() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        sleepInsecond(2);

        // láy ID của ta hiện tại, sau đó switch qua ID của tab mới mở
        String parentFormId = driver.getWindowHandle();
        System.out.println("Parent Tab ID =" + parentFormId);


        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        System.out.println("sleepInsecond");
        sleepInsecond(3);

        //switchToWindowbyID(parentFormId);
        switchtoWindowbyTitle("Google");
        System.out.println(driver.getTitle());

        // thao tac
       driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("manual testing");
        sleepInsecond(3);
        // đã switch qua window of gg thì dùng hàm này get window tại màn hình đó
        String googleIDTab = driver.getWindowHandle();

       //switchToWindowbyID(googleIDTab);
        switchtoWindowbyTitle("Selenium WebDriver");
        sleepInsecond(3);
       //System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        System.out.println("sleepInsecond");
        sleepInsecond(3);

        switchtoWindowbyTitle("Facebook – log in or sign up");
        driver.findElement(By.cssSelector("input#email")).sendKeys("hangnguyen@gmail.com");
        sleepInsecond(3);

        switchtoWindowbyTitle("Selenium WebDriver");

    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_TechPanda() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInsecond(2);

        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInsecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The product Sony Xperia has been added to comparison list.");



    }

    @Test
    public void TC_04_Frame_01() {

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

    public void switchToWindowbyID(String expectedID) {
        //System.out.println("switchToWindowbyID");
        // lấy ra hết tất cả các tab & windowID
        Set<String> allIDs = driver.getWindowHandles();

        // dùng vòng lặp duyệt qua từng ID trong set trên, dùng for
        for (String id : allIDs) {
            //System.out.println(id + ":"+expectedID);
            if (!id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchtoWindowbyTitle(String expectedTitle){
        // lay ra het ID cua cac Window
        Set<String> allIDs = driver.getWindowHandles();
        // dung vong lap duyet qua cac Set ID tren

        for (String id: allIDs){
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)){
                break;
            }
        }

    }
}

