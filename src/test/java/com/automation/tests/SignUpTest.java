package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{
    @Test
    public void verifyUserCanSignUp(){
        homePage.openWebsite();
        homePage.getLinkByText(ConfigReader.getConfigValue("navlink.signupLogin")).click();
    }
}
