package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{
    @Test
    public void verifyUserCanSignUp(){
        homePage.openWebsite();
        homePage.getLinkByText(ConfigReader.getConfigValue("navlink.signupLogin")).click();
        loginSignupPage.enterSignupDetails();
        loginSignupPage.clickSignup();
        Assert.assertTrue(accountInfoPage.isAccountInfoPageDisplayed());
        accountInfoPage.fillAccountInfo();
        accountInfoPage.clickCreateAccountBtn();
        Assert.assertTrue(accountCreatedPage.isAccountCreatedTextDisplayed());
        accountCreatedPage.clickContinueBtn();
        homePage.getLinkByText(ConfigReader.getConfigValue("navlink.deleteAccount")).click();
        Assert.assertTrue(accountDeletedPage.isAccountDeletedTextDisplayed());
        accountDeletedPage.clickContinueBtn();
        Assert.assertTrue(homePage.getLinkByText(ConfigReader.getConfigValue("navlink.signupLogin")).isDisplayed());
    }
}
