package webdriver;

import org.openqa.selenium.Alert;
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

import java.time.Duration;

public class Topic_24_Wait_05_Explicit_01_Knowledge {
    WebDriver driver;

    WebDriverWait explicitWait;// khai bao, chua khoi tao

    @BeforeClass // predcondition/ data test/ page class/ variable init
    public void beforeClass() {
        driver = new FirefoxDriver();
        // khởi tạo 1 explicit wait với tổng thời gian là 10s , polling 0.5s là mặc định
        // 500 miliseconds= 0.5 second

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // khởi tạo với tổng là 10s, polling là 0.3s
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(300));
    }

    @Test
    public void TC_01() {
        // chờ 1 Alert presence trong HTML or Dom trước khi thao tác lên
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        // chờ cho Element ko còn trong Dom
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));
        // chờ cho Element có trong Dom, ko quan tâm có trên UI ko
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));
        // chờ cho 1 list Element có trong Dom
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        // chờ cho 1 đến n element đc hiển thị trên giao diện
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("")),driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("")),driver.findElement(By.cssSelector("")),driver.findElement(By.cssSelector(""))));

        //DÙNG NHIỂU: chờ cho element đc phép click: link, button, checkbox, radio...
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // dùng wait title trc sau đó dùng hàm get title
        // chờ cho page hiện tại có title như mong đợi
        explicitWait.until(ExpectedConditions.titleIs(""));
        driver.getTitle();

        // and: dùng cho nhiều điều kiện
        //explicitWait.until(ExpectedConditions.and(explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))
              //  ,explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector(""))));

        // or

        //explicitWait.until(ExpectedConditions.or(explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))
            //    ,explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector(""))));

        // Chờ 1 element có chứa attribute chứa giá trị mong đợi tương đối
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector(""),"placeholder",""));

        // chờ cho 1 element có attribute chứa giá trị mong đợi tuyệt đối
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector("input#search"),"placeholder","search entire"));

        // chờ cho 1 element có attribute khac Null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("")),""));

        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")),"",""));

       // chờ cho 1 element đc  thành công
        // checbok, radio, dropdownItem (default)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // chờ cho 1 element đc selected rồi
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),true));

        // chờ cho 1 element chưa đc selected, selected = false
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),false));
        // By or element
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(""));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(""))));

        // chờ cho 1 Element biến mất, ko hiển thị trên UI
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // chờ cho 1 đoạn code JS cần trả về giá trị kiểu String
        explicitWait.until(ExpectedConditions.jsReturnsValue("return arguments[0].validationMessage;"));

        // chờ cho 1 đoạn code js đc thực thi mà ko trả về 1 ngoại lệ nào
        // ko ném ra: true
        // ném ra: false
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.documentElement.innerText;"));
        Assert.assertTrue(explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.documentElement.innerText;")));

        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""),10));

        // chờ cho window/tab là bao nhiêu
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));

        // url tuyệt đối
        explicitWait.until(ExpectedConditions.urlToBe("https://support.smartbear.com/"));
       // url tương đối
        explicitWait.until(ExpectedConditions.urlContains("https://support.smartbear.com/"));
        // dùng regex
        explicitWait.until(ExpectedConditions.urlMatches("^abc"));

        // chờ cho 1 điều kiện mà element này update trạng thái= load lại HTML
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.cssSelector(""))));

        // dùng nhiều có 3 hàm: clickable, visible, invisible,

    }

    // quit
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

