package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_19_Upload_File {
    WebDriver driver;

    String projectPath= System.getProperty("user.dir");
    String pic1 ="pic1.jpg";
    String pic2 = "pic2.jpg";
    String pic3 = "pic3.jpg";
    String pic4 = "pic4.jpg";

    // define dấu \\ or / trên window or mac bằng câu lệnh (1 trong 2)
    //Keys character = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL: Keys.COMMAND;
   String character = File.separator;

    String pic1FilePath = projectPath +character + "uploadFiles"+character + pic1;
    String pic2FilePath = projectPath + character+ "uploadFiles"+character + pic2;
    String pic3FilePath = projectPath + character+ "uploadFiles"+character + pic3;
    String pic4FilePath = projectPath + character+ "uploadFiles"+character + pic4;



    @BeforeClass
    public void beforeClass() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void TC_01_SingleFile() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        // trên window sẽ định dạng \\ còn Mac sẽ là /
        // fix cứng path, chỉ máy này chạy đc, phải dùng đường dẫn tương đối
        //String filePath = "/Volumes/Working/Selenium_online/03 - Java Hybrid Framework/selenium-webdriver-java-testng/uploadFiles";

        // file này nằm ở đâu, nếu push code lên và lấy xuống ở máy khác sẽ ko chạy đc
        // đưa file vào chính project/ filder luôn
        // tạo thư mục uploadFiles và bỏ file vào

        By uploadBy= By.cssSelector("input[name='files[]']");
        driver.findElement(uploadBy).sendKeys(pic1FilePath);
        sleepInsecond(2);
        driver.findElement(uploadBy).sendKeys(pic2FilePath);
        sleepInsecond(2);
        driver.findElement(uploadBy).sendKeys(pic3FilePath);
        sleepInsecond(2);
        // list có 3 button Start, tìm và chạy vòng lặp
        List <WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        // verify file loaded success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+pic1+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+pic2+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+pic3+"']")).isDisplayed());


        // dung 2 cach de click button Start
        // classic for
        //for (int i = 0; i < startButtons.size() ; i++) {
          //  startButtons.get(i).click();
         //   sleepInsecond(2);
       // }
        // for each
        for (WebElement button: startButtons){
            button.click();
            sleepInsecond(2);
        }
//p[@class='name']/a[@title='fujiphilm-Tu_tEQcYKv8-unsplash.jpg']
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" +pic1+ "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" +pic2+ "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" +pic3+ "']")).isDisplayed());

    }

    @Test
    public void TC_02_MultipleFile() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadBy= By.cssSelector("input[name='files[]']");
        // up lên nhiều file cùng lúc, dùng "\n" ở giữa các file
        driver.findElement(uploadBy).sendKeys(pic1FilePath+"\n"+pic2FilePath+"\n"+pic3FilePath);
        sleepInsecond(3);
        // list có 3 button Start, tìm và chạy vòng lặp
        List <WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        // verify file loaded success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+pic1+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+pic2+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+pic3+"']")).isDisplayed());


        // dung 2 cach de click button Start
        // classic for
        //for (int i = 0; i < startButtons.size() ; i++) {
        //  startButtons.get(i).click();
        //   sleepInsecond(2);
        // }
        // for each
        for (WebElement button: startButtons){
            button.click();
            sleepInsecond(2);
        }
//p[@class='name']/a[@title='fujiphilm-Tu_tEQcYKv8-unsplash.jpg']
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" +pic1+ "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" +pic2+ "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" +pic3+ "']")).isDisplayed());

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

