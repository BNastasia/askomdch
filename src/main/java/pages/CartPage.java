package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class CartPage extends BasePage {
    @FindBy(css = ".cart_item")
    private WebElement cartItem;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean checkItemIsVisible() {
        getWait(4).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_item")))
                .isDisplayed();
        return true;
    }

    public Boolean checkItemIsDeleted() {
        return getWait(5).until(ExpectedConditions.textToBePresentInElementLocated(By
                .xpath("//p[contains(@class, 'cart-empty')]"), "Your cart is currently empty."));
    }

    public CartPage deleteItem() {
        getWait(5).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".remove"))).click();
        return this;
    }


}
