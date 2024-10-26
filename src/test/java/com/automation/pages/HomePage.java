package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public void openWebsite(){
        driver.get(ConfigReader.getConfigValue("application.url"));
    }
    public WebElement getLinkByText(String linkText) {
        return driver.findElement(By.xpath("//a[text()=' " + linkText + "']"));
    }

}
