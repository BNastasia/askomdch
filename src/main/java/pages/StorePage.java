package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class StorePage extends BasePage {
    @FindBy(xpath = "//a[@href='?add-to-cart=1215']")
    private WebElement buttonAddToCard;

    @FindBy(xpath = "//a[@title='View cart']")
    private WebElement viewCart;
    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage clickAddToCart() {
        getWait(5).until(ExpectedConditions.elementToBeClickable(buttonAddToCard))
                .click();
        return this;
    }

    public CartPage clickViewCart() {
        getWait(5).until(ExpectedConditions.elementToBeClickable(viewCart))
                .click();
        return new CartPage(getDriver());
    }
}
