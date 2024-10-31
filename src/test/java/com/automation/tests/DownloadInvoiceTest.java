package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class DownloadInvoiceTest extends BaseTest{
    @Test
    public void downloadInvoiceTest() throws InterruptedException, FileNotFoundException {
        homePage.openWebsite();
        homePage.getLinkByText(ConfigReader.getConfigValue("navlink.signupLogin")).click();
        loginSignupPage.enterLoginDetails();
        loginSignupPage.clickLogin();
        homePage.isLoggedIn();

        homePage.addRecommendedItemsToCart();
        homePage.getLinkByText(ConfigReader.getConfigValue("navlink.cart")).click();
        //Assert.assertTrue(cartPage.verifyCartItems("homepage.recommendedItems"));
        cartPage.proceedToCheckout();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
        checkoutPage.clickPlaceOrder();

        Assert.assertTrue(paymentPage.isPaymentPageDisplayed());
        paymentPage.enterCardDetails();
        paymentPage.clickPayAndConfirm();

        Assert.assertTrue(paymentDonePage.isOrderPlacedDisplayed());
        paymentDonePage.downloadInvoice();
        Thread.sleep(5000);
        paymentDonePage.printInvoiceData();
    }
}
