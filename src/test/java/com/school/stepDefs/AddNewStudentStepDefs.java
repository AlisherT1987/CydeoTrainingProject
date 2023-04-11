package com.school.stepDefs;

import com.school.pages.DashboardPage;
import com.school.pages.StudentPage;
import com.school.utilities.BrowserUtils;
import com.school.utilities.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddNewStudentStepDefs {
    DashboardPage dashboardPage=new DashboardPage();
    StudentPage studentPage=new StudentPage();
    @And("click {string} under {string} module on left side of page")
    public void clickUnderModuleOnLeftSideOfPage(String addStudent, String students) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals(students, dashboardPage.linkStudents.getText().trim());
        dashboardPage.linkStudents.click();
        BrowserUtils.waitFor(1);
       Assert.assertEquals(addStudent, dashboardPage.linkAddStudent.getText());
        System.out.println("dashboardPage.linkAddStudent.getText() = " + dashboardPage.linkAddStudent.getText());
        dashboardPage.linkAddStudent.click();
    }
    Map<String,String> uiStudentInfo=new HashMap<>();

    @Then("fill out all student information on {string} page")
    public void fillOutAllStudentInformationOnPage(String addStudent, Map<String,String> newStudent) {
        BrowserUtils.waitFor(1);
        studentPage.validInputs(newStudent);
        studentPage.buttonSubmit.click();
    }

    @Then("click {string} button")
    public void clickButton(String arg0) {
    }

    @Given("Establish the database connection")
    public void establishTheDatabaseConnection() {

    }
    List<Map<String,String>> allDBStudentInfo=new ArrayList<>();
    @When("Execute query to get all information using {string}")
    public void executeQueryToGetAllInformationUsing(String student) {
        String query="select * from students\n" +
                "where first_name='"+student+"'";
        DB_Util.runQuery(query);
       allDBStudentInfo=DB_Util.getAllRowAsListOfMap();
        System.out.println(allDBStudentInfo);
        System.out.println(uiStudentInfo);



    }



    @Then("Verify DB information matching with UI part")
    public void verifyDBInformationMatchingWithUIPart() {
    }

    @Given("I sent get request to {string} endpoint")
    public void iSentGetRequestToEndpoint(String arg0) {
    }

    @Then("information about new student from api and UI should match")
    public void informationAboutNewStudentFromApiAndUIShouldMatch() {
    }



}
