package com.cydeo.Pages;

import com.cydeo.Utility.BrowserUtil;
import com.cydeo.Utility.ConfigurationReader;
import com.cydeo.Utility.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "#inputEmail")
    WebElement userEmailTextbox;

    @FindBy (css = "#inputPassword")
    WebElement userPasswordTextbox;

    @FindBy (xpath = "//button[.='Sign in']")
    WebElement signinButton;

    public void login(String userName,String password){
        BrowserUtil.waitFor(4);
        userEmailTextbox.sendKeys(userName);
        userPasswordTextbox.sendKeys(password, Keys.ENTER);


    }
}
