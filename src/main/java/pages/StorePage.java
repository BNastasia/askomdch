package pages;

import org.openqa.selenium.By;
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
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='?add-to-cart=1215']")))
                .click();
        return this;
    }

    public CartPage clickViewCart() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='View cart']")))
                .click();
        return new CartPage(driver);
    }
}
