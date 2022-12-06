package com.cydeo.Steps;

import com.cydeo.Pages.BooksPage;
import com.cydeo.Utility.ConfigurationReader;
import com.cydeo.Utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class US4_StepDefinitions {
    BooksPage bookPg=new BooksPage();
    @When("I open book {string}")
    public void i_open_book(String string) {
        bookPg.searchBox.sendKeys(string, Keys.ENTER);
    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        String actualBookName = bookPg.bookName.getAttribute("value");
        String actualAuthorName = bookPg.author.getAttribute("value");
        String actualISBN=bookPg.isbn.getAttribute("value");
        String actualYear = bookPg.year.getAttribute("value");
        String actualBorrowedBy = bookPg.borrowedBy.getAttribute("value");

        DB_Util.createConnection(ConfigurationReader.getProperty("library2.db.url"), ConfigurationReader.getProperty("library2.db.username"), ConfigurationReader.getProperty("library2.db.password"));

        DB_Util.runQuery(" select name, author, year from books where name="+bookPg.bookName);
        Map<String, String> bookInfo = DB_Util.getRowMap(1);

        String expectedBookName = bookInfo.get("name");
        System.out.println(expectedBookName);
        String expectedAuthorName = bookInfo.get("author");
        String expectedISBN = bookInfo.get("isbn");
        String expectedYear = bookInfo.get("year");
        String borrowedBy = bookInfo.get("description");

        Assert.assertEquals(expectedBookName,actualBookName);
        Assert.assertEquals(expectedAuthorName,actualAuthorName);
        Assert.assertEquals(expectedISBN,actualISBN);
        Assert.assertEquals(expectedYear,actualYear);
        Assert.assertEquals(borrowedBy,actualBorrowedBy);

        DB_Util.destroy();
    }

}
