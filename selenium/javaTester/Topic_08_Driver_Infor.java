package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_08_Driver_Infor {

    WebDriver driver;

    @Test
    public void testDriverInformation(){
        driver = new FirefoxDriver();
        System.out.println(driver.toString());
        // OS nào
        // Browser nào
        // ID của driver là gì
        //FirefoxDriver: firefox on mac (7f5c6aaa-0601-4792-8b5e-ae9b8da5dbad)

        if(driver.toString().contains("firefox")){
            // scroll
        }

        driver.quit();
    }
}
