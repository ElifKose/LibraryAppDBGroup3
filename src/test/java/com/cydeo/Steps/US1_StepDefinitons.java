package com.cydeo.Steps;

import com.cydeo.Utility.ConfigurationReader;
import com.cydeo.Utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US1_StepDefinitons {

    List<String> actualColumnNames;

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {


        DB_Util.runQuery("select * from users");
        actualColumnNames =DB_Util.getAllColumnNamesAsList();

    }
    @Then("verify the below columns are listed in the result")
    public void verify_the_below_columns_are_listed_in_the_result(List<String> expectedColumnNames) {
        System.out.println("actualColumnNames = " + actualColumnNames);
        System.out.println("expectedColumnNames = " + expectedColumnNames);
        Assert.assertEquals(expectedColumnNames,actualColumnNames);

    }
}
