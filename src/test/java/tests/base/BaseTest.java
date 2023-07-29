package tests.base;

import common.CommonActions;
import constants.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.HomePage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public abstract class BaseTest {
    private final WebDriver driver = CommonActions.createDriver();
    private String BASE_URL = Constants.getBaseUrl();

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage openBaseUrl() {
        getDriver().get(BASE_URL);
        return new HomePage(getDriver());
    }

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if(CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite (alwaysRun = true)
    public void close() {
        if(HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
