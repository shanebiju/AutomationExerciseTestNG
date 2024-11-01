package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{

    ////div[@id='recommended-item-carousel']//p names
    ////div[@id='recommended-item-carousel']//div[@class='item active']//p
    ////div[@id='recommended-item-carousel']//div[@class='item active']/div
    ////div[@id='recommended-item-carousel']//div[@class='item']/div
    @FindBy(xpath = "//div[@id='recommended-item-carousel']/div//div[@class='col-sm-4']")
    List<WebElement> recommendedItems;

    @FindBy(xpath = "//a[@class='right recommended-item-control']")
    WebElement moveCarousel;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "//h2[text()='recommended items']")
    WebElement recommendedItemsText;

    @FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
    WebElement homeTitle;

    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement subscriptionText;

    @FindBy(id = "scrollUp")
    WebElement scrollUpBtn;

    public void scrollUp(){executor.executeScript("arguments[0].click()",scrollUpBtn);}

    public boolean isSubscriptionVisible(){
        try{
            return subscriptionText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHomePageDisplayed(){
        try{
            return homeTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void openWebsite(){
        driver.get(ConfigReader.getConfigValue("application.url"));
    }
    public WebElement getLinkByText(String linkText) {
        return driver.findElement(By.xpath("//a[text()=' " + linkText + "']"));
    }

    public boolean isLoggedIn(){
        try{
            return this.getLinkByText(ConfigReader.getConfigValue("navlink.logout")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollToBottom(){
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public  void addRecommendedItemsToCart(){
        // Scroll to the bottom of the page
        executor.executeScript("arguments[0].scrollIntoView(true);",recommendedItemsText);
        StringBuilder s=new StringBuilder();
        for(WebElement recommendedItem:recommendedItems){
            while(true) {
                try {
                    wait.until(ExpectedConditions.visibilityOf(recommendedItem));
                    break;
                } catch (Exception e) {
                    moveCarousel.click();
                }
            }
            String name=recommendedItem.findElement(By.xpath(".//p")).getText();
            while (name.isEmpty()){
                name=recommendedItem.findElement(By.xpath(".//p")).getText();
            }
            s.append(name+",");
            recommendedItem.findElement(By.xpath(".//a")).click();
            driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        }
        s.deleteCharAt(s.length()-1);
        ConfigReader.setConfigValue("homepage.recommendedItems",s.toString());
    }

}
