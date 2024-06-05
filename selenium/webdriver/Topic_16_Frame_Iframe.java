package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_16_Frame_Iframe {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01_Form_Site(){
        // trang A, form Site.com
        driver.get("https://www.formsite.com/templates/education/course-withdrawal-due-to-covid-19-form/");
        // chứa iframe- trang B
        // từ A vào B

        driver.switchTo().frame("frame-one1626306927");
        // nếu có frame bên trong lại switch tiếp: id cua frame C

        driver.switchTo().frame("");
        // từ C back lại B: dùng parentFrame
        driver.switchTo().parentFrame();

        // B quay lai A: dung defaultContent
        driver.switchTo().defaultContent();






    }
    @Test
    public void TC_02_iframe(){
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        sleepInsecond(5);
        // iframe Element
        WebElement formIframe = driver.findElement(By.cssSelector("div#formTemplateContainer>iframe"));
        Assert.assertTrue(formIframe.isDisplayed());
        // thao tac voi dropdown list, lay text > lỗi ngay vì nó đang nằm trong iFrame,k thao tác trực tiếp đc
        // phải switch vào frame/ iframe trc khi thao tác với các Element bên trong
        // cách 1: dùng index (từ vị trí 0 > vị trí n)
        //driver.switchTo().frame(0);
        // cách 2:  dùng name or id
        //driver.switchTo().frame("frame-one85593366");
        // cách 3: dùng Element
        driver.switchTo().frame(formIframe);
        //nên dùng cách 3: để hạn chế việc refresh, thay đổi vị trí, ít bị thay đổi

        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Senior");
        sleepInsecond(5);

        // ra khoi frame, thao tac vs element khac
        // dùng parent or default content tuỳ vị trí của framge
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();


        driver.findElement(By.cssSelector("nav.header--desktop-floater a.menu-item-login")).click();
        sleepInsecond(3);

        driver.findElement(By.cssSelector("button#login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");

    }

    @Test
    public void TC_03_iframe_01 (){
        driver.get("https://skills.kynaenglish.vn/");

    }

    @Test
    public void TC_04_Frame_01 (){
        //  only run on Chrome

        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        // ko input vao textbox dc vi no dang nam trong frame
        // phai switch vao frame, name of frame
        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("hangtest");
        sleepInsecond(2);

        driver.findElement(By.cssSelector("a.login-btn")).click();

        // switch ve de thao tac nhap PW
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456");
        sleepInsecond(2);
    }


    // quit
    @AfterClass
    public void afterClass () {
        driver.quit();
    }
    public void sleepInsecond ( long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}

