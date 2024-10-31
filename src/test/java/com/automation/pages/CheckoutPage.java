package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//a[text()='Place Order']")
    WebElement placeOrderBtn;

    public  void clickPlaceOrder(){executor.executeScript("arguments[0].click()",placeOrderBtn);}
    public boolean isCheckoutPageDisplayed(){
        try{
            return placeOrderBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
