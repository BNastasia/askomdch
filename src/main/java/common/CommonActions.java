package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import static common.Config.PLATFORM_AND_BROWSER;

public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch(PLATFORM_AND_BROWSER) {
            case "mac_chrome":
                driver = new ChromeDriver();
                break;
            case "mac_firefox":
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
