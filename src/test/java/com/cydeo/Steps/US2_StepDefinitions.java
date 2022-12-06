package com.cydeo.Steps;


import com.cydeo.Pages.DashboardPage;
import com.cydeo.Pages.LoginPage;
import com.cydeo.Utility.BrowserUtil;
import com.cydeo.Utility.ConfigurationReader;
import com.cydeo.Utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboard = new DashboardPage();
    String actualBorrowedBookNumbers;

    @Given("user login as a librarian")
    public void user_login_as_a_librarian() {
        loginPage.login(ConfigurationReader.getProperty("librarian_username"), ConfigurationReader.getProperty("password"));
        BrowserUtil.waitFor(4);
    }

    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        actualBorrowedBookNumbers = dashboard.BorrowedBooksUI.getText();
        BrowserUtil.waitFor(4);
    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        DB_Util.createConnection(ConfigurationReader.getProperty("library2.db.url"), ConfigurationReader.getProperty("library2.db.username"), ConfigurationReader.getProperty("library2.db.password"));


        DB_Util.runQuery(" select count(*) as borrowedBooks from users u inner join book_borrow b on u.id = b.user_id where is_returned = 0");
        //Store Data
        String expectedBorrowedBook = DB_Util.getFirstRowFirstColumn();
        //Compare
        Assert.assertEquals(expectedBorrowedBook, actualBorrowedBookNumbers);


        DB_Util.destroy();
    }

}
