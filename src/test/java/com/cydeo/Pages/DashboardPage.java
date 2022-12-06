package com.cydeo.Pages;

import com.cydeo.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "#borrowed_books")
    public WebElement BorrowedBooksUI;


}
