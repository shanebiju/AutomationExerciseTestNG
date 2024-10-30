package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSignupPage extends BasePage{

    @FindBy(xpath = "//form[@action='/signup']/input[@name='name']")
    WebElement signupUsername;

    @FindBy(xpath = "//form[@action='/signup']/input[@name='email']")
    WebElement signupEmail;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signupBtn;

    public void enterSignupDetails(){
        signupUsername.sendKeys(ConfigReader.getConfigValue("user.username"));
        signupEmail.sendKeys(ConfigReader.getConfigValue("user.email"));
    }
    public void clickSignup(){signupBtn.click();}
}
