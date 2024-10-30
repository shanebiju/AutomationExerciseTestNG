package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage extends BasePage{
    @FindBy(xpath = "//b[text()='Account Deleted!']")
    WebElement accountDeletedText;

    @FindBy(xpath = "//a[contains(@class,'btn') and contains(@class,'btn-primary')]")
    WebElement continueBtn;

    public boolean isAccountDeletedTextDisplayed(){
        try{
            return accountDeletedText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickContinueBtn(){continueBtn.click();}
}
