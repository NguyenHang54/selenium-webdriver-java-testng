package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_09_custom_dropdown {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
        public void beforeClass() {

            driver = new FirefoxDriver();

            explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        }

        @Test
        public void TC_01_Register() {
           driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
           driver.findElement(By.cssSelector("span#number-button")).click();
            sleepInsecond(3);

            explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));

            List< WebElement> allItems= driver.findElements(By.cssSelector("ul#number-menu div"));
              for(WebElement item:allItems){
                  String textItem= item.getText();
                  System.out.println("Text item = " +textItem);

                if (textItem.equals("8")){
                    item.click();
                    break;
                }
              }
        }


        @Test
        public void TC_02_Login() {
        }
        public void sleepInsecond (long timeInSecond){
            try {
                Thread.sleep(timeInSecond * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }