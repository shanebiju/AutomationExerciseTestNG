package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage{

    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement accountCreatedText;

    @FindBy(xpath = "//a[contains(@class,'btn') and contains(@class,'btn-primary')]")
    WebElement continueBtn;

    public boolean isAccountCreatedTextDisplayed(){
        try{
            return accountCreatedText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickContinueBtn(){continueBtn.click();}
}
