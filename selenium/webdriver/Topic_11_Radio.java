package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_11_Radio {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void TC_01_Default_Telerik() {

        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        By dualCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']//preceding-sibling::span/input");
        By realSiteCheckbox = By.xpath("//label[text()='Rear side airbags']//preceding-sibling::span/input");

        // kiem tra xem da select vao checkbox chua
        // neu chua chon thi vao click
        if (!driver.findElement(realSiteCheckbox).isSelected()) {
            driver.findElement(realSiteCheckbox).click();
            sleepInsecond(2);
        }

        if (!driver.findElement(dualCheckbox).isSelected()) {
            driver.findElement(dualCheckbox).click();
            sleepInsecond(2);
        }

        sleepInsecond(3);

        // verify checkbox da duoc chon
        Assert.assertTrue(driver.findElement(dualCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(realSiteCheckbox).isSelected());

        // bo chon checkbox: bo ! trc driver
        if (driver.findElement(realSiteCheckbox).isSelected()) {
            driver.findElement(realSiteCheckbox).click();
        }
        if (driver.findElement(dualCheckbox).isSelected()) {
            driver.findElement(dualCheckbox).click();
        }

        Assert.assertFalse(driver.findElement(dualCheckbox).isSelected());
        Assert.assertFalse(driver.findElement(realSiteCheckbox).isSelected());
    }


    @Test
    public void TC_02_Default_Radio_bt() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        // radio button chi cho phep chon, ko bo chon dc
        By petrolradio = By.xpath("//label[text()='2.0 Petrol, 147kW']//preceding-sibling::span/input");
        By diezelRadio = By.xpath("//label[text()='1.6 Diesel, 77kW']//preceding-sibling::span/input");

        if (!driver.findElement(petrolradio).isSelected()) {
            driver.findElement(petrolradio).click();
        }

        sleepInsecond(3);

        Assert.assertTrue(driver.findElement(petrolradio).isSelected());
        Assert.assertFalse(driver.findElement(diezelRadio).isSelected());

        if (!driver.findElement(diezelRadio).isSelected()) {
            driver.findElement(diezelRadio).click();
        }
        sleepInsecond(3);

        Assert.assertTrue(driver.findElement(diezelRadio).isSelected());
        Assert.assertFalse(driver.findElement(petrolradio).isSelected());

    }

    @Test
    public void TC_03_Check_all_checkbox() {
        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement> allCheckboxItems = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        // chon het all chekbox
        for (WebElement checkbox : allCheckboxItems) {
            if (!checkbox.isSelected()) {
                checkbox.click();
                //sleepInsecond(1);
            }
        }
        // verify het cac checkbox da dc chon
        for (WebElement checkbox : allCheckboxItems) {
            Assert.assertTrue(checkbox.isSelected());

        }

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        allCheckboxItems = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
        By heartOption = By.cssSelector("div.form-single-column input[value='Heart Attack']");
        if (!driver.findElement(heartOption).isSelected()){
            driver.findElement(heartOption).click();
        }
        // Verify gia tri da dc select
        for (WebElement checkbox : allCheckboxItems) {
            if (checkbox.getAttribute("value").equals("Heart Attack")) {
                Assert.assertTrue(checkbox.isSelected());
            } else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }

    }

    @Test
    public void TC_04_custom_ubuntu() {
        driver.get("https://login.ubuntu.com/");

    }

@Test
    public void sleepInsecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}

