package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_13_Actions {
    WebDriver driver;
    Actions actions;

    JavascriptExecutor javascriptExecutor;


    @BeforeClass
    public void beforeClass() {

        // chỉ bị lỗi khi chạy trên FireFox, ko bị trên chrome, chromium, opera..
        driver = new FirefoxDriver();
        // nó đang giả lập lại các hành vi của Mouse/ Keyboard, Pen nên khi nó đang chạy mình ko sử dụng các thiết bị
        // conflict
        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Hover() {
        actions.getActiveKeyboard();
        actions.click(driver.findElement(By.xpath(""))).perform();
        actions.click(driver.findElement(By.xpath(""))).build();
        // bai toan click and hold number, sau do select space
        actions.clickAndHold(driver.findElement(By.xpath("nguon")))
                .moveToElement(driver.findElement(By.xpath("dich")))
                .release().perform();

    }

    @Test
    public void TC_02_Hover_Tooltip() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));
        actions.moveToElement(ageTextbox).perform();
        sleepInsecond(2);
        // verify text:
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");

    }

    @Test
    public void TC_03_Hover_Menu_Login() {
        driver.get("https://www.fahasa.com/");

        actions.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();

        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Bách Hóa Online - Lưu Niệm']"))).perform();

        driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']")).click();
        sleepInsecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(), "THIẾT BỊ SỐ - PHỤ KIỆN SỐ");
        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Thiết Bị Số - Phụ Kiện Số']")).isDisplayed());
    }

    @Test
    public void TC_04_Click_and_Hover() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumbers = driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allNumbers.size(), 20);
        // chọn theo Block hàng ngang- dọc

        actions.clickAndHold(allNumbers.get(0))  //click lên 1 số và giữ chuột
                .pause(2000) // dung laij 2s
                .moveToElement(allNumbers.get(14)) // di chuột trái đến số 15
                .release()  // nhả chuột trái ra
                .perform(); // Execute tất cả action trên

        List<String> allNumberTextExpected = new ArrayList<String>();
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

        for (WebElement element : allNumbersSelected) {
            allNumberTextActual.add(element.getText());
        }

        Assert.assertEquals(allNumberTextExpected, allNumberTextActual);

    }

    @Test
    public void TC_05_Doubleclick() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double click me']"));

        // phải scroll tới element đó rồi mới double click, chỉ dảnh riêng cho Fire fox
        // nếu đổi driver = new FirefoxDriver() sang driver = new ChromeDriver thì run ko bị lỗi

        if (driver.toString().contains("firefox")) {
            // scrollIntoViewTrue: kéo mép trên của Element lên phía trên cùng của viewport
            // scrollintoviewFalse: kéo mép dưới của Element lên phía dưới cùng của viewport

            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", doubleClickButton);
            sleepInsecond(2);
        }

        actions.doubleClick(doubleClickButton).perform();
        sleepInsecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");

    }

    @Test
    public void TC_06_rightClick() {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

    // verify luc chua right click thi chua visible
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());

        actions.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        sleepInsecond(2);

        // click chuot phai thi cac element dc visible

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());
        actions.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
        sleepInsecond(2);

        // click vao paste, kiem tra xem hover dung hay ko

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste.context-menu-hover.context-menu-visible")).isDisplayed());
        // click len option Paste

        actions.click(driver.findElement(By.cssSelector("li.context-menu-icon-paste.context-menu-hover.context-menu-visible"))).perform();
        sleepInsecond(2);

       // khi bat len alert thi switch alert va accept no
        driver.switchTo().alert().accept();
        sleepInsecond(2);
        // verify button paste ko hien thi
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isSelected());


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


