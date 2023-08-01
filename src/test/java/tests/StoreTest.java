package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.base.BaseTest;

public class StoreTest extends BaseTest {

    @Description("Add item to the card")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addItemToCard() {
        openBaseUrl();
        Boolean itemExist = new HomePage(getDriver())
                .clickShopNowAndGoToStore()
                .clickAddToCart()
                .clickViewCart()
                .checkItemIsVisible();

        Assert.assertTrue(itemExist);
    }

    @Test
    public void deleteItemFromCart() {
        openBaseUrl();
        Boolean itemIsDeleted =  new HomePage(getDriver())
                .addItemToCart()
                .viewCart()
                .deleteItem()
                .checkItemIsDeleted();

        Assert.assertTrue(itemIsDeleted);
    }
}
