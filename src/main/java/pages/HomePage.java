package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class HomePage extends BasePage {
    @FindBy(className = "site-title")
    private WebElement title;

    @FindBy(xpath = "//a[@href = '/store']")
    private WebElement buttonShopNow;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage getTitle() {
        title.getText();
        return this;
    }

    public StorePage clickShopNowAndGoToStore() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href = '/store']")))
                .click();
        return new StorePage(driver);
    }

    public HomePage addItemToCart() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By
                .xpath("(//a[contains(@href, 'add-to-cart')])[1]")))
                .click();
        return this;
    }

    public CartPage viewCart() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title = 'View cart']")))
                .click();
        return new CartPage(driver);
    }
}
