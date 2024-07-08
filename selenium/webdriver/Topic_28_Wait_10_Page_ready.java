package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Topic_28_Wait_10_Page_ready {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    WebDriverWait explicitwait;




    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        explicitwait = new WebDriverWait(driver,Duration.ofSeconds(20));


    }

    @Test
    public void TC_01_Admin_nopCommerce() {

        driver.get("https://admin-demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("input#Email")).clear();
        driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("input#Password")).clear();
        driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.login-button")).click();

        Assert.assertTrue(isPageLoadedSuccess());

        driver.findElement(By.xpath("//i[contains(@class,'fa-user')]//following-sibling::p")).click();
        driver.findElement(By.xpath("//ul[contains(@style,'display: block')]//i[contains(@class,'fa-dot-circle')]//following-sibling::p[contains(string(),'Customers')]")).click();

        Assert.assertTrue(isPageLoadedSuccess());

        driver.findElement(By.xpath("//i[contains(@class,'fa-book')]//following-sibling::p")).click();
        driver.findElement(By.xpath("//ul[contains(@style,'display: block')]//i[contains(@class,'fa-dot-circle')]//following-sibling::p[contains(string(),'Products')]")).click();

        Assert.assertTrue(isPageLoadedSuccess());

        driver.findElement(By.xpath("//i[contains(@class,'fa-shopping-cart')]//following-sibling::p")).click();
        driver.findElement(By.xpath("//ul[contains(@style,'display: block;')]//i[contains(@class,'fa-dot-circle')]//following-sibling::p[contains(string(),'Orders')]"));
        Assert.assertTrue(isPageLoadedSuccess());
    }

    @Test
    public void TC_02_orangeHrm_API() {
        driver.get("https://api.orangehrm.com/");
        // find element co san, chi can implicitwait cung dc
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // cach khac
        Assert.assertTrue(explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loader>div.spinner"))));

        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='OrangeHRM REST API Documentation']")).isDisplayed());
    }


    @Test
    public void TC_03() {
    }

    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }





    // quit
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

