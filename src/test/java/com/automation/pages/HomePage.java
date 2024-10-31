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

    public void openWebsite(){
        driver.get(ConfigReader.getConfigValue("application.url"));
    }
    public WebElement getLinkByText(String linkText) {
        return driver.findElement(By.xpath("//a[text()=' " + linkText + "']"));
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
