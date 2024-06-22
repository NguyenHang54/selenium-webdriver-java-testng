package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_25_Wait_07_Explicit_03 {
    WebDriver driver;
    WebDriverWait explicitWait;
    String projectPath= System.getProperty("user.dir");
    String pic1 ="pic1.jpg";
    String pic2 = "pic2.jpg";
    String pic3 = "pic3.jpg";
    String pic4 = "pic4.jpg";

    // define dấu \\ or / trên window or mac bằng câu lệnh (1 trong 2)
    //Keys character = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL: Keys.COMMAND;
    String character = File.separator;
    // tạo đường dẫn: path project + \\ or / + folder name + // + file name
    String pic1FilePath = projectPath +character + "uploadFiles"+character + pic1;
    String pic2FilePath = projectPath + character+ "uploadFiles"+character + pic2;
    String pic3FilePath = projectPath + character+ "uploadFiles"+character + pic3;
    String pic4FilePath = projectPath + character+ "uploadFiles"+character + pic4;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));

    }
    // TC 1-3 dùng với invisible
    @Test
    public void TC_01_AjaxLoading() {

        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultvb.aspx?show-source=true");

        By selectedDateBy = By.cssSelector("span#ctl00_ContentPlaceholder1_Label1");
        WebElement selectedDate = driver.findElement(selectedDateBy);

        Assert.assertEquals(driver.findElement(selectedDateBy).getText(),"No Selected Dates to display.");

        driver.findElement(By.xpath("//a[text()='22']")).click();

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));

        Assert.assertEquals(driver.findElement(selectedDateBy).getText(),"Saturday, June 22, 2024");

    }

    @Test
    public void TC_02_Upload_File() {
        driver.get("https://gofile.io/welcome");
        // làm cho spinner icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border")));
        // wait + click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ajaxLink>button"))).click();
        // verify spinner icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border"))));
        // uppload files
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(pic1FilePath + "\n" + pic2FilePath + "\n" + pic3FilePath);
        // Wait Spinner icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border")));
        // wait progress bar biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.progress")));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink"))).click();
    }

    // quit
@AfterClass
public void afterClass() {
    driver.quit();
}

}


