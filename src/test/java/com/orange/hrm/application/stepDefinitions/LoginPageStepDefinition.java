package com.orange.hrm.application.stepDefinitions;

import com.orange.hrm.application.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefinition {

    private LoginPage login = new LoginPage();


    @Given("The user enters the username as {string}")
    public void theUserEntersTheUsernameAs(String username) {
        login.setUserName(username);
    }
    @And("The user enters the password as {string}")
    public void theUserEntersThePasswordAs(String password) {
        login.setPassword(password);
    }

    @When("The user clicks the login button")
    public void theUserClicksTheLoginButton() {
        login.clickLoginButton();
    }
}
