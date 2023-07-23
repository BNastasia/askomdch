package pages;

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

    @FindBy(xpath = "(//a[contains(@href, 'add-to-cart')])[1]")
    private WebElement addItem;

    @FindBy(xpath = "//a[@title = 'View cart']")
    private WebElement viewCart;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage getTitle() {
        title.getText();
        return this;
    }

    public StorePage clickShopNowAndGoToStore() {
        getWait(5).until(ExpectedConditions.elementToBeClickable(buttonShopNow))
                .click();
        return new StorePage(getDriver());
    }

    public HomePage addItemToCart() {
        getWait(5).until(ExpectedConditions.elementToBeClickable(addItem)).click();
        return this;
    }

    public CartPage viewCart() {
        getWait(5).until(ExpectedConditions.elementToBeClickable(viewCart)).click();
        return new CartPage(getDriver());
    }
}
