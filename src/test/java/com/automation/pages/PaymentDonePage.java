package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.time.Duration;

public class PaymentDonePage extends BasePage{

    @FindBy(xpath = "//b[text()='Order Placed!']")
    WebElement orderPlacedText;

    @FindBy(xpath = "//a[text()='Download Invoice']")
    WebElement downloadInvoiceBtn;

    public void downloadInvoice(){downloadInvoiceBtn.click();}
    public boolean isOrderPlacedDisplayed(){
        try{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return orderPlacedText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void printInvoiceData() throws FileNotFoundException {
        FileUtils fileUtils=new FileUtils(ConfigReader.getConfigValue("invoice.path"));
        System.out.println(fileUtils.getFileContent());
    }
}
