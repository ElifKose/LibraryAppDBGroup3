package com.cydeo.Steps;

import com.cydeo.Pages.BooksPage;
import com.cydeo.Pages.DashboardPage;
import com.cydeo.Utility.ConfigurationReader;
import com.cydeo.Utility.DB_Util;
import com.cydeo.Utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class US3_StepDefinition {
    BooksPage booksPg = new BooksPage();
    List<String> categoriesListUI;
    List<String> expectedCategoryList;

    @When("I navigate to {string} page")
    public void i_navigate_to_page(String string) {
        booksPg.books.click();
    }

    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        Select categoriesDropdown = new Select(booksPg.categoriesDropdown);
     categoriesListUI = new ArrayList<>();
        for (WebElement each : categoriesDropdown.getOptions()) {
           categoriesListUI.add(each.getText());
       }
        categoriesListUI.remove(0);
    }

    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        DB_Util.createConnection(ConfigurationReader.getProperty("library2.db.url"), ConfigurationReader.getProperty("library2.db.username"), ConfigurationReader.getProperty("library2.db.password"));

        DB_Util.runQuery("select name from book_categories");

     expectedCategoryList= DB_Util.getColumnDataAsList(1);
        DB_Util.destroy();

    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(expectedCategoryList,categoriesListUI);
    }

}
