package com.cydeo.Pages;

import com.cydeo.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends BasePage {

    public BooksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#book_categories")
    public WebElement categoriesDropdown;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "(//tbody/tr/td)[2]")
    public WebElement isbn;

    @FindBy(xpath = "(//tbody/tr/td)[3]")
    public WebElement bookName;
    @FindBy(xpath = "(//tbody/tr/td)[4]")
    public WebElement author;

    @FindBy(xpath = "(//tbody/tr/td)[6]")
    public WebElement year;
    @FindBy(xpath = "(//tbody/tr/td)[6]")
    public WebElement borrowedBy;


}
