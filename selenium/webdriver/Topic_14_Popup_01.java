package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_14_Popup_01 {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01_Fixed_popup_In_Dom_01(){
      // driver.switchTo().  : ham dung de switch, neu ko thi ko thao tac dc
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.cssSelector("button.login_ ")).click();
        sleepInsecond(2);
        By loginPopup = By.cssSelector("div[id='modal-login-v1'][style]>div");
        // verify login popup is displayed
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style]>div input#account-input")).sendKeys("automationfc");

        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style]>div input#password-input")).sendKeys("automationfc");

        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style]>div button.btn-login-v1")).click();
        sleepInsecond(2);

        // verify error message displayed
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style]>div div.error-login-panel")).getText(),"Tài khoản không tồn tại!");

        // close popup = click vao x button
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style]>div button.close")).click();
        sleepInsecond(2);

        // kiem tra login popup ko hien thi
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
    }

    @Test
    public void TC_02_Fixed_Popup_In_Dom_02(){
        driver.get("https://skills.kynaenglish.vn/dang-nhap");
        By loginPopup = By.cssSelector("div#k-popup-account-login-mb>div");
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        sleepInsecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(),"Sai tên đăng nhập hoặc mật khẩu");
        sleepInsecond(2);

        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
    }
    @Test
    public void TC_03_Fixed_Popup_Not_In_Dom_01(){
        driver.get("https://tiki.vn/");
        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        sleepInsecond(3);

        // verify popup hien thi
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());
        // click vao "login by Email"
        driver.findElement(By.cssSelector("p.login-with-email")).click();
        sleepInsecond(3);

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        // verify text

        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='email']/parent::div/following-sibling::span[1]")).getText(),"Email không được để trống");

        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='password']/parent::div/following-sibling::span")).getText(),"Mật khẩu không được để trống");

        driver.findElement(By.cssSelector("button.btn-close")).click();
        sleepInsecond(2);

        // khi popup Close thi HTML ko con trong DOM nua, ko dung Assert- isDisplayed
        // vi khong tim thay Element, ko dung ham nay de verify
        // neu ko tim thay Element thi cho het timeout of Implicitway, danh fail TC then throws exception: no such element
        // run se bi fail: Assert.assertFalse(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());
       // dung voi findElements (so nhieu)

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(),0);

    }

    @Test
    public void TC_04_Fixed_Popup_Not_In_Dom_02(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        sleepInsecond(2);

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).isDisplayed());

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInsecond(2);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).size(),0);

    }
    @Test
    public void TC_05_Random_Popup_Not_In_Dom_01(){
        driver.get("https://www.javacodegeeks.com/");
        sleepInsecond(15);
        // khi close random pupup thi van tim dc element nay, nhung no ko displayed
        By newsLetterPopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");
        // neu hien thi > close popup
        // luon chay dc vi element luon o trong HTML/DOM
        if (driver.findElements(newsLetterPopup).size()>0 && driver.findElements(newsLetterPopup).get(0).isDisplayed()){
            System.out.println("popup hien thi");
            driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none']) div.lepopup-element-html-content>a")).click();
            sleepInsecond(3);
        }
        else {
            System.out.println("popup ko hien thi");
        }

        // neu ko hien thi> qua step tiep theo
        // search input and verify
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        // click vao icon Search
        driver.findElement(By.cssSelector("button#search-submit")).click();
        sleepInsecond(3);

        // verify article:
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());
    }

    @Test
    public void TC_06_Random_Popup_In_Dom_02(){
      driver.get("https://vnk.edu.vn/");
      sleepInsecond(30); //có lúc mở popup có lúc ko nên để time sleep dài
      By marketingPopup = By.cssSelector("div.tve-leads-conversion-object");
      // khi close random pupup thi van tim dc element nay, nhung no ko displayed
        // display = block van hien thi nhung bi an, display None la ko hien thi

        if (driver.findElement(marketingPopup).isDisplayed()){
            System.out.println("popup is displayed");
            driver.findElement(By.cssSelector("svg.tcb-icon")).click();
            sleepInsecond(2);
        }else  {
            System.out.println("popup is not displayed");
        }

        driver.findElement(By.cssSelector("button.btn-danger")).click();
        // get text này là text trên UI, còn text truyền vào element sẽ có chữ thường..
        Assert.assertEquals(driver.findElement(By.cssSelector("div.title-content>h1")).getText(),"Lịch Khai Giảng Tháng 06");

    }


    @Test
    public void TC_07_Random_Popup_In_Dom_03(){
        driver.get("https://www.kmplayer.com/home");
        sleepInsecond(2);
        // khi close random pupup thi van tim dc element nay, nhung no ko displayed
        By marketingPopup2 = By.cssSelector("div.pop-conts");
        if (driver.findElement(marketingPopup2).isDisplayed())
        {
            System.out.println("popup is shown");
            driver.findElement(By.cssSelector("div.close")).click();
            sleepInsecond(2);
        }else {
            System.out.println("popup is not shown");
        }

    }

    @Test
    public void TC_08_Random_Popup_Not_In_Dom_01(){
        driver.get("https://dehieu.vn/");
        By contentPopup = By.cssSelector("div.modal-content");
        if (driver.findElement(contentPopup).isDisplayed())
        {
            System.out.println("content is displayed");
            driver.findElement(By.cssSelector("button.close")).click();
            sleepInsecond(2);
        }else {
            System.out.println("content is not displayed");
        }
    }
    @Test
    public void TC_09_Random_Popup_Not_In_Dom_02(){
        driver.get("https://dehieu.vn/");
        By testPopup = By.cssSelector("div.modal-content");
        // cach 2: kiem tra neu popup chua mo ra, get size & get phan tu dau tien hien thi
       if(driver.findElements(testPopup).size()>0 && driver.findElements(testPopup).get(0).isDisplayed()){
           System.out.println("popup hien thi");
           driver.findElement(By.cssSelector("button.close")).click();
           sleepInsecond(2);
       }else {
           System.out.println("popup ko hien thi");
       }

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


