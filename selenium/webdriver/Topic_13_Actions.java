package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_13_Actions {
    WebDriver driver;
    Actions actions;



    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    // nó đang giả lập lại các hành vi của Mouse/ Keyboard, Pen nên khi nó đang chạy mình ko sử dụng các thiết bị
    // conflict
        actions = new Actions(driver);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Hover(){
        actions.getActiveKeyboard();
        actions.click(driver.findElement(By.xpath(""))).perform();
        actions.click(driver.findElement(By.xpath(""))).build();
        // bai toan click and hold number, sau do select space
        actions.clickAndHold(driver.findElement(By.xpath("nguon")))
                .moveToElement(driver.findElement(By.xpath("dich")))
                .release().perform();

    }
    @Test
    public void TC_02_Hover_Tooltip(){
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageTextbox= driver.findElement(By.cssSelector("input#age"));
        actions.moveToElement(ageTextbox).perform();
        sleepInsecond(2);
        // verify text:
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");

    }

    @Test
    public void TC_03_Hover_Menu_Login(){
        driver.get("https://www.fahasa.com/");

       actions.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();

       actions.moveToElement(driver.findElement(By.xpath("//a[@title='Bách Hóa Online - Lưu Niệm']"))).perform();

       driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']")).click();
       sleepInsecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(), "THIẾT BỊ SỐ - PHỤ KIỆN SỐ");
        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Thiết Bị Số - Phụ Kiện Số']")).isDisplayed());
    }

    @Test
    public void TC_04_Click_and_Hover(){
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List< WebElement> allNumbers= driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allNumbers.size(),20);
        // chọn theo Block hàng ngang- dọc

        actions.clickAndHold(allNumbers.get(0))  //click lên 1 số và giữ chuột
                .pause(2000) // dung laij 2s
                .moveToElement(allNumbers.get(14)) // di chuột trái đến số 15
                .release()  // nhả chuột trái ra
                .perform(); // Execute tất cả action trên

        List <String> allNumberTextExpected = new ArrayList<String>();
        allNumberTextExpected.add("1");
        allNumberTextExpected.add("2");
        allNumberTextExpected.add("3");
        allNumberTextExpected.add("5");
        allNumberTextExpected.add("6");
        allNumberTextExpected.add("7");
        allNumberTextExpected.add("9");
        allNumberTextExpected.add("10");
        allNumberTextExpected.add("11");
        allNumberTextExpected.add("13");
        allNumberTextExpected.add("14");
        allNumberTextExpected.add("15");



// Tổng các số đã chọn
        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        Assert.assertEquals(allNumbersSelected.size(), 12);

        List<String> allNumberTextActual = new ArrayList<String>();

        for (WebElement element : allNumbersSelected){
            allNumberTextActual.add(element.getText());
        }

        Assert.assertEquals(allNumberTextExpected, allNumberTextActual);



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


