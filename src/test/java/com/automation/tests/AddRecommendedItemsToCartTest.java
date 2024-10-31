package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRecommendedItemsToCartTest extends BaseTest{
    @Test
    public void addRecommendedItemsToCart() throws InterruptedException {
        homePage.openWebsite();
        homePage.addRecommendedItemsToCart();
        homePage.getLinkByText(ConfigReader.getConfigValue("navlink.cart")).click();
        Assert.assertTrue(cartPage.verifyCartItems("homepage.recommendedItems"));
    }
}
