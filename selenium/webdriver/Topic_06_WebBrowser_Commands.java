package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {

    // các câu lệnh để thao tác với Browser
    // đứng sau Driver.
    WebDriver driver;

    // cac cau lenh thao tac vs Element cung dung sau Element
    WebElement Element;

    FirefoxDriver ffDriver;
    ChromeDriver chDriver;





    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver(); //**
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new InternetExplorerDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//**
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_() throws MalformedURLException {
        // set trực tiếp
        driver.get("https://6sense.com/solutions/technology/");//**

        // khai báo biến vào rồi gán vào sau
        // nếu như biến này chỉ dùng duy nhất 1 lần thì ko nên tạo biến
         String homepageURL = "https://6sense.com/solutions/technology/";
        driver.get("homepageURL");
        driver.get(homepageURL);

        // nếu chỉ có 1 cửa sổ/ tab thì close và quit như nhau
        // close: nếu có nhiều hơn 1 tab, sẽ đóng cái đang active
        driver.close(); //*

        // nếu có nhiều tab/ cửa sổ thì sẽ quit sẽ đóng browser, ko care
        driver.quit(); //**

        // nó sẽ đi tìm với By nào và trả về Element nếu như đc tìm thấy
        // ko đc tìm thấy: fail tại step này và throư exception: NoSuchElementException
        driver.findElement(By.id("email")); //**
        // trả về 1 element, nếu tìm thấy nhiều hơn 1 cũng chỉ trả về 1
        // trả về 1 danh sách Elements nếu tìm với nhiều element
        // 2 ham findelement and findelements bi anh huong timeout cua implicitway

         List<WebElement> checkboxes= driver.findElements(By.xpath("//input[@type='checkbox']"));

         driver.findElement(By.cssSelector("button#Login")).click(); //**

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30) );

         //
        String LoginPageURL=driver.getCurrentUrl(); //*
        driver.getPageSource();
        // lay ra ID cua window or tab hien tai
        driver.getWindowHandles(); //*
        // lay ra title cua page hien tai
        driver.getTitle();
        // ko can khai bao bien neu chi dung 1 lan
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon.com/");

        // khai bao bien neu dung hon 1 lan
        Assert.assertEquals(LoginPageURL,"https://katalon.com/");


        // neu can open URL
        driver.get(LoginPageURL);

        // cookies - framework
        //driver.manage().addCookie(); //*
        // get ra log o Dev Tool - Framework
        driver.manage().logs().getAvailableLogTypes();//*
        //apply cho viec tim element (findElement or findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // cho cho 1 page load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));

        // set trc khi dung thu vien JavaExecuter
        // Inject 1 doan code JS khi vao Browser/ Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(40));
        // selenium 4. tro len moi co
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().getPageLoadTimeout();

        //chay full man hinh
        driver.manage().window().fullscreen();
        driver.manage().window().maximize(); //**
        driver.manage().window().minimize();

       // Test Responsive
        driver.manage().window().setSize(new Dimension(768,1024));

        driver.manage().window().getSize();
        // set cho browser o vui tri nao so vs do phan giai man hinh
        driver.manage().window().setPosition(new Point(0,0));

        // ham navigate dung de dieu huong trang web *
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
       // thao tac voi history cua web page
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));

       // Alert/ window (Tab)/ Frame (iFrame)  *
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();// cancel alert
        driver.switchTo().alert().getText();// get text Alert
        driver.switchTo().alert().sendKeys(""); // send data vao alert

        // handle window and tab
        // lay ID tu handle
        String homePageWindowID =  driver.getWindowHandle();
        // lay ID tren truyen vao
        driver.switchTo().window(homePageWindowID); // truyen vao ID of Page/webrowser
        // lay ID nhieu window
        Set<String> allWindowIds= driver.getWindowHandles();

        // Switch/ handle Frame
        // by Index, id(name),Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("");
        driver.switchTo().frame(driver.findElement(By.id("")));
        // switch ve HTML chua frame trc do
        driver.switchTo().defaultContent();
        // tu frame trong đi ra frame ngoài chứa nó
        driver.switchTo().parentFrame();



    }
    @Test
    public void TC_02_(){}

// quit
@Test
public void TC_03_Run_On_Edge() {
    driver = new EdgeDriver();
    driver.get("https://www.facebook.com/");
    driver.quit();
}
}


