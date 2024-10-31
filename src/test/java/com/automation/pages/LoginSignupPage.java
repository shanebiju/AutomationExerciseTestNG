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

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//form[@action='/login']/input[@name='email']")
    WebElement loginEmail;

    @FindBy(xpath = "//form[@action='/login']/input[@name='password']")
    WebElement loginPassword;

    public void enterSignupDetails(){
        signupUsername.sendKeys(ConfigReader.getConfigValue("user.username"));
        signupEmail.sendKeys(ConfigReader.getConfigValue("user.email"));
    }

    public void enterLoginDetails(){
        loginEmail.sendKeys(ConfigReader.getConfigValue("login.email"));
        loginPassword.sendKeys(ConfigReader.getConfigValue("login.password"));
    }
    public void clickSignup(){signupBtn.click();}

    public void clickLogin(){loginBtn.click();}
}
