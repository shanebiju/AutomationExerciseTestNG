package com.automation.tests;

import com.automation.pages.*;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    HomePage homePage;
    AccountInfoPage accountInfoPage;
    AccountCreatedPage accountCreatedPage;
    LoginSignupPage loginSignupPage;
    AccountDeletedPage accountDeletedPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    PaymentDonePage paymentDonePage;
    @BeforeMethod
    public void setUp(){
        ConfigReader.initConfig();
        DriverManager.createDriver();
        homePage=new HomePage();
        accountInfoPage=new AccountInfoPage();
        accountCreatedPage=new AccountCreatedPage();
        loginSignupPage=new LoginSignupPage();
        accountDeletedPage=new AccountDeletedPage();
        cartPage=new CartPage();
        checkoutPage=new CheckoutPage();
        paymentPage=new PaymentPage();
        paymentDonePage=new PaymentDonePage();
    }

    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
