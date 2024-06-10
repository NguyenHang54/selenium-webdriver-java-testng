package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_18_Javascript_Executor {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_JE_Live_Techpanda() {
        // dùng javascriptExecutor
        //jsExecutor.executeScript("window.location='http://live.techpanda.org/'");
        executeForBrowser("window.location='http://live.techpanda.org/'");
        sleepInsecond(5);

        String techPandaDomain = (String) executeForBrowser("return document.domain;");
        Assert.assertEquals(techPandaDomain,"live.techpanda.org");

        String homepageURL = (String) executeForBrowser("return document.URL");
        Assert.assertEquals(homepageURL,"http://live.techpanda.org/");

        hightlightElement("//a[text()='Mobile']");
        clickToElementByJS("//a[text()='Mobile']");

        hightlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");

        Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

        hightlightElement("//a[text()='Customer Service']");
        clickToElementByJS("//a[text()='Customer Service']");

        String customerTitle = (String) executeForBrowser("return document.title;");
        Assert.assertEquals(customerTitle,"Customer Service");

        scrollToBottomPage();
        hightlightElement("//input[@id='newsletter']");
        sendkeyToElementByJS("//input[@id='newsletter']",getEmailAddress ());

        hightlightElement("//button[@title='Subscribe']");
        clickToElementByJS("//button[@title='Subscribe']");

        // có 2 cách verify text, get inner text or is expected text in inner text
        Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
        //Assert.assertTrue(isExpectedTextInInnerText("Thank you for your subscription."));

        // chuyển trang: dùng navigate to URL
        navigateToUrlByJS("https://www.facebook.com/");
        sleepInsecond(3);

        Assert.assertEquals(executeForBrowser("return document.domain;"),"facebook.com");


    }

    @Test
    public void TC_02() {
        driver.get("https://sieuthimaymocthietbi.com/account/register");
        driver.findElement(By.xpath("//button[text()='Đăng ký']")).click();
        sleepInsecond(2);

        Assert.assertEquals(getElementValidationMessage("//input[@id='lastName']"),"Please fill out this field.");

        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Automation");
        driver.findElement(By.xpath("//button[text()='Đăng ký']")).click();
        sleepInsecond(2);

        Assert.assertEquals(getElementValidationMessage("//input[@id='firstName']"),"Please fill out this field.");


    }

    @Test
    public void TC_03_register_Account() {
        navigateToUrlByJS("http://live.techpanda.org/");
        sleepInsecond(2);

        hightlightElement("//div[@id='header-account']//a[@title='My Account']");
        clickToElementByJS("//div[@id='header-account']//a[@title='My Account']");

        hightlightElement("//a[@title='Create an Account']");
        clickToElementByJS("//a[@title='Create an Account']");

        sendkeyToElementByJS("//input[@id='firstname']","Automation");
        sendkeyToElementByJS("//input[@id='lastname']","Test");
        sendkeyToElementByJS("//input[@id='email_address']",getEmailAddress());
        sendkeyToElementByJS("//input[@id='password']","12345678");
        sendkeyToElementByJS("//input[@id='confirmation']","12345678");

        sleepInsecond(2);
        hightlightElement("//button[@title='Register']");
        clickToElementByJS("//button[@title='Register']");
        sleepInsecond(2);

        //Assert.assertEquals(getInnerText(),"Thank you for registering with Main Website Store.");
        Assert.assertTrue(isExpectedTextInInnerText("Thank you for registering with Main Website Store."));


        hightlightElement("//div[@id='header-account']//a[text()='Log Out']");
        clickToElementByJS("//div[@id='header-account']//a[text()='Log Out']");

        navigateToUrlByJS("http://live.techpanda.org/index.php/");

        Assert.assertEquals(executeForBrowser("return document.domain;"),"live.techpanda.org");
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

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInsecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInsecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInsecond(3);
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));

    }

    public String getEmailAddress(){
        Random rand = new Random();
        return "kelvinlamp" + rand.nextInt(99999)+"@gmail.net";

    }
}