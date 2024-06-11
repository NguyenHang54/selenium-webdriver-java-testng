package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_19_Upload_File {
    WebDriver driver;

    String projectPath= System.getProperty("user.dir");
    String pic1 ="pic1.jpg";
    String pic2 = "pic2.jpg";
    String pic3 = "pic3.jpg";
    String pic4 = "pic4.jpg";

    String pic1FilePath = projectPath + "uploadFiles" + pic1;
    String pic2FilePath = projectPath + "uploadFiles" + pic2;
    String pic3FilePath = projectPath + "uploadFiles" + pic3;
    String pic4FilePath = projectPath + "uploadFiles" + pic4;



    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void TC_01_SingleFile() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        // trên window sẽ định dạng \\ còn Mac sẽ là /
        // fix cứng path, chỉ máy này chạy đc, phải dùng đường dẫn tương đối
        String filePath = "/Volumes/Working/Selenium_online/03 - Java Hybrid Framework/selenium-webdriver-java-testng/uploadFiles";




        // file này nằm ở đâu, nếu push code lên và lấy xuống ở máy khác sẽ ko chạy đc
        // đưa file vào chính project/ filder luôn
        // tạo thư mục uploadFiles và bỏ file vào




    }

    @Test
    public void TC_02_MultipleFile() {
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

