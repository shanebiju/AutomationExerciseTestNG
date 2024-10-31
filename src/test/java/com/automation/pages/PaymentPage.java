package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{

    @FindBy(xpath ="//button[text()='Pay and Confirm Order']")
    WebElement payAndConfirmBtn;

    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement nameOnCardInput;

    @FindBy(xpath = "//input[@name='card_number']")
    WebElement cardNumberInput;

    @FindBy(xpath = "//input[@name='cvc']")
    WebElement cvcInput;

    @FindBy(xpath = "//input[@name='expiry_month']")
    WebElement expiryMonthInput;

    @FindBy(xpath = "//input[@name='expiry_year']")
    WebElement expiryYearInput;

    public void clickPayAndConfirm(){executor.executeScript("arguments[0].click()",payAndConfirmBtn);}

    public boolean isPaymentPageDisplayed(){
        try{
            return payAndConfirmBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterCardDetails(){
        nameOnCardInput.sendKeys(ConfigReader.getConfigValue("payment.cardName"));
        cardNumberInput.sendKeys(ConfigReader.getConfigValue("payment.cardNumber"));
        cvcInput.sendKeys(ConfigReader.getConfigValue("payment.cvc"));
        expiryMonthInput.sendKeys(ConfigReader.getConfigValue("payment.expiryMonth"));
        expiryYearInput.sendKeys(ConfigReader.getConfigValue("payment.expiryYear"));
    }
}
