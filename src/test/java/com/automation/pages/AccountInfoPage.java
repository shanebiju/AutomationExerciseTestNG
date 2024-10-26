package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
