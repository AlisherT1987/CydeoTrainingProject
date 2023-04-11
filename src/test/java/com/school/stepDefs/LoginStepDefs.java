package com.school.stepDefs;

import com.school.pages.BasePage;
import com.school.pages.DashboardPage;
import com.school.utilities.BrowserUtils;
import com.school.utilities.Driver;
import com.school.utilities.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs{
DashboardPage dashboardPage=new DashboardPage();
    @When("user on login page")
    public void userOnLoginPage() {
        Driver.get().get(Environment.URL);
        BrowserUtils.waitFor(2);
        dashboardPage.image.click();
        dashboardPage.logOutBtn.click();
        BrowserUtils.waitFor(2);


    }
    @And("login with valid credentials")
    public void loginWithValidCredentials() {
        dashboardPage.login();
        BrowserUtils.waitFor(2);


    }

    @Then("user on Dashboard page")
    public void userOnDashboardPage() {
    }
}
