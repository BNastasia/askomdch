package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public abstract class BaseTest {
    private WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(getDriver());

    public WebDriver getDriver() {
        return driver;
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
