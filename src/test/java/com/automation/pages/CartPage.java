package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage extends BasePage{

    @FindBy(xpath = "//tbody/tr")
    List<WebElement> cartItems;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    WebElement proceedToCheckoutBtn;

    public void proceedToCheckout(){proceedToCheckoutBtn.click();}

    public boolean isCartPageDisplayed(){
        try{
            return proceedToCheckoutBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> getCartItemNames(){
        List<String> cartItemNames=new ArrayList<>();
        for(WebElement cartItem:cartItems){
            String name=cartItem.findElement(By.xpath("./td[@class='cart_description']//a")).getText();
            cartItemNames.add(name);
        }
        return  cartItemNames;
    }

    public boolean verifyCartItems(String configKey){
        List<String> itemsAddedToCart= Arrays.asList(ConfigReader.getConfigValue(configKey).split(","));
        List<String> cartItems=this.getCartItemNames();
        return itemsAddedToCart.equals(cartItems);
    }
}
