package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register");
    }
    @Test
    public void TC_01_ID(){
          //driver.findElement(By.id("FirstName"));
         // System.out.println( driver.findElement(By.id("FirstName")));
           driver.findElement(By.id("LastName")).sendKeys("Cao Nguyen");
    }
    @Test
    public void TC_02_class() {
        System.out.println(driver.findElement(By.className("cart-label")));
    }
    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthYear"));
    }
    @Test
    public void TC_04_Tagname() {
        driver.findElements(By.tagName("label"));
    }
    @Test
    public void TC_05_LinkText(){
        driver.findElement(By.linkText("Recently viewed products"));
    }
    @Test
    public void TC_06_Partial_LinkText(){
        driver.findElement(By.partialLinkText("Compare products"));
    }
    @Test
    public void TC_07_Css(){
        //css với Id
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));
        // css với name
        driver.findElement(By.cssSelector("input[name='FirstName']"));
        // css với class name
        driver.findElement(By.cssSelector("span[class='cart-label']"));
        //css với tag name
        driver.findElement(By.cssSelector("input"));
        //css với linktext: phải dùng attribute, href
        driver.findElement(By.cssSelector("a[href='/cart']"));
        //css với partial link text: lấy giữa *
        driver.findElement(By.cssSelector("a[href*='vendor/apply']"));
        //css với partial link text: lấy giữa đầu :^
        //driver.findElement(By.cssSelector("a[href^='vendor/apply']"));
        //css với partial link text: lấy đuôi $
        driver.findElement(By.cssSelector("a[href$='vendor/apply']"));


    }
    @Test
    public void TC_08_Xpath(){
        //Xpath với Id: như structure css, thêm // và @

        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // xpath không cho viết tắt như css
        //driver.findElement(By.cssSelector("input# First Name"));
        //driver.findElement(By.cssSelector("#First Name"));
        // Xpath với name: // và @

        driver.findElement(By.xpath("//input[@name='FirstName']"));
        // Xpath với class name: // và @

        driver.findElement(By.xpath("//span[@class='cart-label']"));
        //Xpath với tag name: chỉ //

        driver.findElement(By.xpath("//input"));
        //Xpath với linktext: phải dùng attribute, href

        driver.findElement(By.xpath("//a[@href='/cart']"));
        driver.findElement(By.xpath("//a[text()='Shopping cart']"));


        //Xpath với partial link text: lấy giữa *

        driver.findElement(By.xpath("//a[contains(@href,'vendor')]"));
        driver.findElement(By.xpath("//a[contains(text(),'vendor')]"));

    }
}



