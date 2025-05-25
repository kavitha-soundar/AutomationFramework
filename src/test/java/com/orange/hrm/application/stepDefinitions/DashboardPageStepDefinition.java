package com.orange.hrm.application.stepDefinitions;


import com.orange.hrm.application.pages.DashBoardPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class DashboardPageStepDefinition {

    private final DashBoardPage dashboard = new DashBoardPage();

    @Then("Verify the dashboard page is displayed")
    public void verifyTheDashboardPageIsDisplayed() {
        Assert.assertEquals(dashboard.IsDashBoardPageDisplayed(), "Dashboard");
    }
}
