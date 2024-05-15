package webdriver;

import net.bytebuddy.pool.TypePool;
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

            explicitWait.until(ExpectedConditions.
                    presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));

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
        public void TC_02_Jquery() {
            driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

            selectItemInDropdown("span#speed-button","ul#speed-menu div","Fast");
            sleepInsecond(2);

            selectItemInDropdown("span#files-button","ul#files-menu div","jQuery.js");
            sleepInsecond(2);


            selectItemInDropdown("span#number-button","ul#number-menu div","10");
            sleepInsecond(2);

            selectItemInDropdown("span#salutation-button","ul#salutation-menu div","Mrs.");
            sleepInsecond(2);

            Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Fast");

            Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(),"jQuery.js");

            Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"10");

            Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Mrs.");



        }
@Test
        public void TC_03_React(){
         driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
         selectItemInDropdown("i.dropdown.icon","div.item>span.text","Matt");
         Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Matt");
         sleepInsecond(3);

         selectItemInDropdown("i.dropdown.icon","div.item>span.text","Christian");
         Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Christian");
         sleepInsecond(3);

         selectItemInDropdown("i.dropdown.icon","div.item>span.text","Jenny Hess");
         Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Jenny Hess");
         sleepInsecond(3);

        }


@Test
    public void TC_04_Vuejs(){
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInDropdown("li.dropdown-toggle","ul.dropdown-menu a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");
        sleepInsecond(3);

        selectItemInDropdown("li.dropdown-toggle","ul.dropdown-menu a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");
        sleepInsecond(3);


    }

@Test
    public void TC_05_Editable(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemEditableInDropdown("input.search","div.selected.item","Belgium");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Belgium");
        sleepInsecond(3);

        selectItemEditableInDropdown("input.search","div.selected.item","Bangladesh");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Bangladesh");
        sleepInsecond(3);

        selectItemEditableInDropdown("input.search","div.selected.item","American Samoa");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"American Samoa");
        sleepInsecond(3);

    }

    @Test
    public void TC_06_Default_NopEcommerce(){
        driver.get("https://demo.nopcommerce.com/register");
        selectItemInDropdown("select[name='DateOfBirthDay']","select[name='DateOfBirthDay']>option","15");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']>option[value='15']")).isSelected());
        sleepInsecond(3);

        selectItemInDropdown("select[name='DateOfBirthMonth']","select[name='DateOfBirthMonth']>option","August");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']>option[value='8']")).isSelected());
        sleepInsecond(3);

        selectItemInDropdown("select[name='DateOfBirthYear']","select[name='DateOfBirthYear']>option","1997");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']>option[value='1997']")).isSelected());
        sleepInsecond(3);








    }

@AfterClass
        public void afterClass(){driver.quit();}

    public void sleepInsecond (long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
       public void selectItemInDropdown(String parentCss,String childItemCss, String itemTextExpected )
       {
           driver.findElement(By.cssSelector(parentCss)).click();
           List<WebElement >allItems = explicitWait.until(ExpectedConditions.
                   presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
           for (WebElement item : allItems) {
               if (item.getText().equals(itemTextExpected)){
                   item.click();
                   break;
               }
           }
       }
    public void selectItemEditableInDropdown(String parentCss,String childItemCss, String itemTextExpected ){
        driver.findElement(By.cssSelector(parentCss)).clear();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);
        List<WebElement >allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        for (WebElement item : allItems) {
            if (item.getText().equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }



}