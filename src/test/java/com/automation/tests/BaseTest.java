package com.automation.tests;

import com.automation.pages.AccountCreatedPage;
import com.automation.pages.AccountInfoPage;
import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    HomePage homePage;
    AccountInfoPage accountInfoPage;
    AccountCreatedPage accountCreatedPage;
    @BeforeMethod
    public void setUp(){
        ConfigReader.initConfig();
        DriverManager.createDriver();
        homePage=new HomePage();
        accountInfoPage=new AccountInfoPage();
        accountCreatedPage=new AccountCreatedPage();

    }

    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
