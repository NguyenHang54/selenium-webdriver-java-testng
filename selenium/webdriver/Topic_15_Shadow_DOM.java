package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_15_Shadow_DOM {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01_Shadow_Dom(){
        driver.get("https://automationfc.github.io/shadow-dom/");
        // đi theo đúng cấu trúc của HTML/ DOM
        // find locator từ cha > con>...
        // đại diện cho real Dom: DOM bên ngoài
        WebElement shadowHostElement = driver.findElement(By.cssSelector("div#shadow_host"));
        // use: getShadowRoot
        // shadowRootContext: đại diện cho shadow dom bên trong (nằm trong real dom)
        SearchContext shadowRootContext = shadowHostElement.getShadowRoot();
        sleepInsecond(3);

        String someText = shadowRootContext.findElement(By.cssSelector("span#shadow_content>span")).getText();

        Assert.assertEquals(someText,"some text");
        // hoac in ra text
        System.out.println(someText);
        sleepInsecond(3);

        // đại diện cho nested shadow  ( shadow này nằm trong shadowRootContext)
       WebElement nestedShadowHostElement = shadowRootContext.findElement(By.cssSelector("div#nested_shadow_host"));

       // từ shadow này, get shadow root nằm trong đó ra
        SearchContext nestedShadowRootContext = nestedShadowHostElement.getShadowRoot();
        sleepInsecond(3);

        String nestedText = nestedShadowRootContext.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        Assert.assertEquals(nestedText, "nested text");
        System.out.println(nestedText);


        WebElement checkboxShadow = shadowRootContext.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxShadow.isSelected());


    }
    @Test
    public void TC_02_Shadow_Dom_Shopee(){
        driver.get("https://shopee.vn/");
        sleepInsecond(5);

        WebElement shadowhostElement = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));
        SearchContext shadowRootContext = shadowhostElement.getShadowRoot();

        // verify popup displayed

        if (shadowRootContext.findElement(By.cssSelector("div.home-popup__content")).isDisplayed()){
            shadowRootContext.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
            sleepInsecond(3);
        }

        // trong TH ko display popup ma close popup thi thuc hien Search
        driver.findElement(By.cssSelector("input.shopee-searchbar-input__input")).sendKeys("iPhone 15 Promax");
        sleepInsecond(3);
        driver.findElement(By.cssSelector("button.shopee-searchbar__search-button")).click();

    }

    @Test
    public void TC_10_Shadow_DOM_Popup()  {
        driver.get("https://shopee.vn/");
        sleepInsecond(3);
        WebElement shadowHost = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        if (shadowRoot.findElement(By.cssSelector("div.home-popup")).isDisplayed()){ // Step 2: Nếu hiển thị
            System.out.println("Shadow DOM is displayed");
            shadowRoot.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
        }

        // Step 2: Nếu không hiển thị
        driver.findElement(By.cssSelector("div.shopee-searchbar-input")).sendKeys("iphone 15 Pro Max");
        driver.findElement(By.cssSelector("button.shopee-searchbar__search-button")).click();

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

