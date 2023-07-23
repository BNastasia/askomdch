package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    private final WebDriver driver;
    private WebDriverWait wait;

    private long time;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {return driver;}

    public void open(String url) {
        driver.get(url);
    }

    protected WebDriverWait getWait(long time) {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        }
        return wait;
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
