package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_12_Alert {
    WebDriver driver;
    // dung cho 3 TCs below
    By resultText = By.cssSelector("p#result");


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01_Accept_alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        sleepInsecond(2);

        // Phai dung ham switch to de thao tac tiep
        // co 3 TH: alert, frame, window

        Alert alert= driver.switchTo().alert();
        // verify text tren alert
        Assert.assertEquals(alert.getText(),"I am a JS Alert");

        // accept/ cancel alert thi alert mất luôn
        alert.accept();
        sleepInsecond(2);

        // verify text sau khi accept alert
        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked an alert successfully");

        //driver.switchTo().frame(1);
        //driver.switchTo().window("");
        // cancel Alert:
        //  void dismiss();

        // accept alert:
        // void accept();

        // get text trong alert ra, verify:
        // String getText();

        // input text vao alert:
        // void sendKeys(String keysToSend);
    }
    @Test
    public void TC_02_Confirm_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        sleepInsecond(2);
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(),"I am a JS Confirm");

        alert.dismiss();
        sleepInsecond(2);

        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked: Cancel");

    }

    @Test
    public void TC_03_Prompt_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        sleepInsecond(2);
        Alert alert = driver.switchTo().alert();

        String text = "Hana Nguyen";
        alert.sendKeys(text);
        sleepInsecond(2);
        alert.accept();
        sleepInsecond(2);

        Assert.assertEquals(driver.findElement(resultText).getText(),"You entered: "+text);

    }
    // nen dung 3 TCs voi explicitWait.until(ExpectedConditions.alertIsPresent()

    @Test
    public void TC_04_Authentication_Alert(){
        // Thu vien alert ko support cho authen dc, lien quan toi security

        // cách 1: truyền thẳng user/ pw vào URLz
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

        // cách 2: chỉ sử dụng trên windows( dùng thư viện AutoIT)

        // cách 3: dùng chrome dev tool Protocol

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


