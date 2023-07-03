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

    public Boolean checkItem() {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_item")))
                .isDisplayed();
        return true;
    }
}
