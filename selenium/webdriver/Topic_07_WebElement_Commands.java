package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

    }
    @Test
    public void TC_01_Element(){
        // tìm và trả về 1 Element:HTML element button, link, text, image,..
        // tim chưa tương tác
        driver.findElement(By.id(""));

        // tim và tương tác, sau By.id
        driver.findElement(By.id("")).getText();
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).sendKeys("");

        // tìm và lưu nó vào 1 biến WebElement mà chưa tương tác
        // khi dung biến này ít nhất 2 lần trở lên
        WebElement fullNameTextbox = driver.findElement(By.id(""));
        fullNameTextbox.clear();
        fullNameTextbox.sendKeys("Automation Test");
        fullNameTextbox.getAttribute("value 1");

        // ham Clear dung de xoa du lieu trong 1 field cho phep nhap
        // Textbox, textArea, Dropdown (editable)
        // thg dc su dung trc ham sendKeys de dam bao tinh toan ven cua data
        driver.findElement(By.id("")).clear();

        // dung de nhap lieu vao cac field tren
        driver.findElement(By.id("")).sendKeys("");

        // dung de click len Element: checkbox, button, link
        driver.findElement(By.id("")).click();

        // tim tu node cha vao node con
        driver.findElement(By.id("form-validate")).findElement(By.id("firstname"));
        driver.findElement(By.cssSelector("form#form-validate id#firstname"));
        driver.findElement(By.id("form-validate")).findElements(By.cssSelector("input"));

        // tra ve nhieu Element khop voi dk
        List<WebElement> Textboxes  =driver.findElements(By.cssSelector(""));

        //Java nonJeneric
        ArrayList name= new ArrayList();
        name.add("Automation testing");
        name.add(15);
        name.add('B');
        name.add(true);

        //Java Jeneric
        ArrayList<String> address= new ArrayList<String>();
        address.add("117 Ly Chinh Thang");
       // address.add(17); // bao loi do sai kieu, yc string nhap vao #string
       // address.add('B'); // sai type data input
        // address.add(true);// sai type data input

        // verify 1 checkbox, radio, dropdown: checked or not
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        // Dropdown (default/ custom) co 1 thu vien rieng de handle
        Select select = new Select(driver.findElement(By.id("")));

        // dung de verify 1 Element co displayed or not
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());

        // dung de verify 1 Element co thao tac len duoc ko
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        // HTML element
        // <input type="text" id="firstname" name="firstname" value="" title="First Name" maxlength="255" class="input-text required-entry">

        driver.findElement(By.id("")).getAttribute("type");
        driver.findElement(By.id("")).getAttribute("id");
        driver.findElement(By.id("")).getAttribute("name");

        // lien quan toi tab accessibility/ properties trong element
        driver.findElement(By.id("")).getAccessibleName(); // console -accessibility
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("validationMessage");

        // verify font/size/ color
        driver.findElement(By.id("")).getCssValue("background-color");
        driver.findElement(By.id("")).getCssValue("font-size");


       // vị trí của Element so với độ phân giải màn hình
        Point nameTextBoxLocation = driver.findElement(By.id("")).getLocation();
        nameTextBoxLocation.getX();
        nameTextBoxLocation.getY();

        // Location + size
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();
        // get location
        nameTextboxRect.getPoint();
        // size: width, height
        Dimension nameSize = nameTextboxRect.getDimension();
        nameSize.getHeight();
        nameSize.getWidth();

        // shadow element (hoc bai Javascript Excuter)
        driver.findElement(By.id("")).getShadowRoot();

        // chieu cao +rong
        driver.findElement(By.id("")).getSize();

        // tu id/class/name/css/xpath co the truy nguoc lai tagname HTML
        driver.findElement(By.id("firstName")).getTagName();
        driver.findElement(By.cssSelector("#firstName")).getTagName();
        driver.findElement(By.className("#form-instruction")).getTagName();

        //Element A > dau ra cua no la tag name cua Element A
        String formTag =driver.findElement(By.xpath("//*[@class='form-list']")).getTagName();

        // Element B se nhan tagname cua element A la tham so truyen vao

        // get text: thg hay su dung : vd text © 2015 Magento Demo Store. All Rights Reserved.
        driver.findElement(By.cssSelector("address.copyright")).getText();
        // chup hinh bi loi va luu duoi dang nao
        // luu dang byte
        // file: luu hinh co kich thuoc trong o cung: .png,.jpg,...
        // base 64: dang text
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BASE64);
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BYTES);

        // dung cho form/ nam trong the form
        // hanh vi nhu khi dung phim Enter: send request len

        driver.findElement(By.id("")).submit();

    }

    @AfterClass
    public void afterClass(){driver.quit();}
}


