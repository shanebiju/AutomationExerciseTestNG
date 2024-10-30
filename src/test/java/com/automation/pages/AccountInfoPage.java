package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountInfoPage extends BasePage{

    @FindBy(id = "id_gender1")
    WebElement titleInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "days")
    WebElement daySelect;

    @FindBy(id = "months")
    WebElement monthSelect;

    @FindBy(id = "years")
    WebElement yearSelect;

    @FindBy(id = "first_name")
    WebElement firstnameInput;

    @FindBy(id = "last_name")
    WebElement lastnameInput;

    @FindBy(id = "company")
    WebElement companyInput;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "state")
    WebElement stateInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "zipcode")
    WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//button[@type='submit' and text()='Create Account']")
    WebElement createAccountBtn;

    public void fillAccountInfo(){
        titleInput.click();
        passwordInput.sendKeys(ConfigReader.getConfigValue("user.password"));
        Select days=new Select(daySelect);
        Select months=new Select(monthSelect);
        Select years=new Select(yearSelect);
        days.selectByIndex(12);
        months.selectByIndex(6);
        years.selectByVisibleText("2002");
        firstnameInput.sendKeys(ConfigReader.getConfigValue("user.firstname"));
        lastnameInput.sendKeys(ConfigReader.getConfigValue("user.lastname"));
        address.sendKeys(ConfigReader.getConfigValue("user.address"));
        stateInput.sendKeys(ConfigReader.getConfigValue("user.state"));
        cityInput.sendKeys(ConfigReader.getConfigValue("user.city"));
        zipcodeInput.sendKeys(ConfigReader.getConfigValue("user.zipcode"));
        mobileNumberInput.sendKeys(ConfigReader.getConfigValue("user.mobile"));
    }

    public boolean isAccountInfoPageDisplayed(){
        try{
            return createAccountBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickCreateAccountBtn(){
        try{
            createAccountBtn.click();
        } catch (Exception e) {
            executor.executeScript("arguments[0].click()",createAccountBtn);
        }
    }
}
