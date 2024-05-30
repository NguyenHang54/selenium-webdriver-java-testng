package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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


