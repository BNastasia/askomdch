package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.base.BaseTest;

public class StoreTest extends BaseTest {
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
