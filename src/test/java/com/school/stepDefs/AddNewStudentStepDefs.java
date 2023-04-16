package com.school.stepDefs;

import com.school.pages.DashboardPage;
import com.school.pages.StudentPage;
import com.school.pojo.Student;
import com.school.pojo.Students;
import com.school.utilities.BrowserUtils;
import com.school.utilities.DB_Util;
import com.school.utilities.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddNewStudentStepDefs {
    DashboardPage dashboardPage=new DashboardPage();
    StudentPage studentPage=new StudentPage();
    Response response;
    String actualUserName;
    int id;
    String firstName;
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
    public void fillOutAllStudentInformationOnPage(String addStudent,Map<String,String> newStudent) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals(addStudent, studentPage.header.getText());
        this.uiStudentInfo.putAll(newStudent);
        studentPage.validInputs(newStudent);

    }
    @Then("click {string} button and verify Username of new student on profile page")
    public void clickButtonAndVerifyUsernameOfNewStudentOnProfilePage(String submit) {
        Assert.assertEquals(submit, studentPage.buttonSubmit.getText());
        BrowserUtils.waitFor(1);
        studentPage.buttonSubmit.click();
        BrowserUtils.waitFor(2);
        String expectedUserName = studentPage.searchStudent(uiStudentInfo.get("Firstname"));
        this.actualUserName=uiStudentInfo.get("Firstname")+" "+uiStudentInfo.get("Lastname");
        id= Integer.parseInt(studentPage.studentID.getText());
        BrowserUtils.waitFor(2);
        Assert.assertEquals(expectedUserName, actualUserName);
        this.firstName=uiStudentInfo.get("Firstname");
    }


    @Given("Establish the database connection")
    public void establishTheDatabaseConnection() {

    }
    Map<String,String> allDBStudentInfo=new HashMap<>();
    @When("Execute query to get all information using {string}")
    public void executeQueryToGetAllInformationUsing(String student) {
        firstName="Anna";
        String query="select first_name as \"Firstname\",last_name as \"Lastname\",email_address as \"Email\",join_date as \"Joining Date\",subject as \"Subject\",phone as \"Mobile number\",gender as \"Gender\",birth_date as \"Birth Date\",major as \"Major\",batch as \"Batch\",company_name as \"Company Name\",title as \"Title\",start_date as \"Start date\",city as \"City\",street as \"Street\",zip_code as \"ZipCode\",state as \"State\",permanent_address \"Permanent Address\"  from students s join companies c on s.student_id = c.student_id join address a on c.company_id = a.company_id join contacts c2 on s.student_id = c2.student_id\n" +
                "where first_name='"+firstName+"'";
        DB_Util.runQuery(query);
       this.allDBStudentInfo=DB_Util.getRowMap(1);
       DB_Util.runQuery("select student_id from students\n" +
               "where first_name='"+firstName+"'");
      this.id= Integer.parseInt(DB_Util.getFirstRowFirstColumn());




    }



    @Then("Verify DB information matching with UI part")
    public void verifyDBInformationMatchingWithUIPart() {
        System.out.println(allDBStudentInfo);
        System.out.println(uiStudentInfo);
        System.out.println(actualUserName);
        System.out.println(id);

    }


    @Given("I sent get request to {string} endpoint")
    public void iSentGetRequestToEndpoint(String endpoint) {
        response=given().accept(ContentType.JSON).pathParam("id", 100).
                when().get(Environment.BASE_URL+endpoint).prettyPeek().then().extract().response();
        JsonPath jsonPath = response.jsonPath();

        //Deserialize to Students class
        Students students = jsonPath.getObject("", Students.class);
        //we deserialize everything to Students class which is holding list of Student
        System.out.println("students = " + students);
        Student student1 = students.getStudents().get(0);
        System.out.println("student1 = " + student1);
        Student student =jsonPath.getObject("students[0]",Student.class );
        System.out.println("student = " + student);
        Map<String,Object> mapOfPojo=jsonPath.getMap("students[0]");
        System.out.println("mapOfPojo = " + mapOfPojo);

    }

    @Then("information about new student from api and UI should match")
    public void informationAboutNewStudentFromApiAndUIShouldMatch() {


    }


}
