package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Xpath_Css {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // Action len man hinh register
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //String emailAddressErrorMessage = driver.findElement(By.id("txtFirstname-error")).getText();
        //Assert.assertEquals(emailAddressErrorMessage,"Vui lòng nhập họ tên");
        // cach viet ngan gon hon, ko can khai bao bien
        // Verify

        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");


    }

    @Test
    public void Register_02_Invalid_Email_Address() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //action : input data valid and invalid
        driver.findElement(By.id("txtFirstname")).sendKeys("Hang Nguyen");
        driver.findElement(By.id("txtEmail")).sendKeys("test@123@yo");
        driver.findElement(By.id("txtCEmail")).sendKeys("test123@123");
        driver.findElement(By.id("txtPassword")).sendKeys("123456@");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456@");
        driver.findElement(By.id("txtPhone")).sendKeys("03099888888");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        // Verify email invalid
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");

    }
    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //action on Screen: input data
        driver.findElement(By.id("txtFirstname")).sendKeys("Hanna Nguyen");
        driver.findElement(By.id("txtEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("test@1234");
        driver.findElement(By.id("txtPassword")).sendKeys("123456@");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456@");
        driver.findElement(By.id("txtPhone")).sendKeys("03099888888");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify error message

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");

    }

    @Test
    public void Register_04_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //input
        driver.findElement(By.id("txtFirstname")).sendKeys("Hana Test");
        driver.findElement(By.id("txtEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("1234");
        driver.findElement(By.id("txtCPassword")).sendKeys("12@");
        driver.findElement(By.id("txtPhone")).sendKeys("03099888888");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //verify

        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void Register_05_Invalid_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // input data
        driver.findElement(By.id("txtFirstname")).sendKeys("Hana Test");
        driver.findElement(By.id("txtEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456@");
        driver.findElement(By.id("txtCPassword")).sendKeys("1234556");
        driver.findElement(By.id("txtPhone")).sendKeys("03099888888");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //verify

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");


    }

    @Test
    public void Register_06_Invalid_Phone_Number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //input data: phone invalid format
        driver.findElement(By.id("txtFirstname")).sendKeys("Hana Test");
        driver.findElement(By.id("txtEmail")).sendKeys("testt@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("testt@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456@");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456@");
        driver.findElement(By.id("txtPhone")).sendKeys("12445");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        // verify

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");


        //clear tr khi input data
        driver.findElement(By.id("txtPhone")).clear();
        // phone less than 10 characters
        driver.findElement(By.id("txtPhone")).sendKeys("0987");

        // van phai click button Submit
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
        // verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

    }
}

//practice

