package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollUpTest extends BaseTest{

    @Test
    public void verifyScrollUpArrow() throws InterruptedException {
        homePage.openWebsite();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.scrollToBottom();
        Assert.assertTrue(homePage.isSubscriptionVisible());
        homePage.scrollUp();
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }
}
