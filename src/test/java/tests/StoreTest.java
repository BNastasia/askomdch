package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;

public class StoreTest extends BaseTest {
    @Test
    public void addItemToCard() {
        basePage.open(HOME_PAGE);
        Boolean itemExist = new HomePage(driver)
                .clickShopNowAndGoToStore()
                .clickAddToCart()
                .clickViewCart()
                .checkItem();

        Assert.assertTrue(itemExist);
    }
}
