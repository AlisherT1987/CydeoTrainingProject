package com.school.stepDefs;

import com.github.javafaker.Faker;
import com.school.utilities.BrowserUtils;
import com.school.utilities.DB_Util;
import com.school.utilities.Driver;
import com.school.utilities.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static io.restassured.RestAssured.given;

public class UpdateStudentInfo {
    Faker faker=new Faker();
    Response response;
    JsonPath jsonPath ;
    String id="116";
    String emailUI=faker.internet().emailAddress();
    String emailAPI;
    String emailDB;

    @Given("Student on {string} page")
    public void student_on_page(String string) {

    }
    @Given("type id in {string} search box")
    public void type_id_in_search_box(String string) {
        BrowserUtils.waitFor(2);
        WebElement studentName= Driver.get().findElement(By.tagName("input"));
        studentName.sendKeys(id+ Keys.ENTER);
        BrowserUtils.waitFor(2);

    }
    @Given("click {string} button")
    public void click_button(String search) {
        WebElement searchBtn=Driver.get().findElement(By.xpath("//a[.=' "+search+" ']"));
        searchBtn.click();
        BrowserUtils.waitFor(2);

    }

    @Given("click edit button on student information row")
    public void click_edit_button_on_student_information_row() {
        WebElement editBtn=Driver.get().findElement(By.xpath("//a[@href='edit-student.html?studentId=116']"));
        editBtn.click();
        BrowserUtils.waitFor(2);

    }
    @And("delete existing email and put new email address")
    public void deleteExistingEmailAndPutNewEmailAddress() {
        WebElement email=Driver.get().findElement(By.xpath("//label[.='Email']/..//input"));
        email.clear();
        email.sendKeys(emailUI);
        BrowserUtils.waitFor(2);
    }
    @And("after click {string} button")
    public void afterClickButton(String submit) {
        WebElement submitBtn=Driver.get().findElement(By.xpath("//button[.='"+submit+"']"));
        submitBtn.click();
        BrowserUtils.waitFor(2);
    }
    @Then("sent get request to {string} endpoint")
    public void sentGetRequestToEndpoint(String endpoint) {
        response=given().accept(ContentType.JSON).pathParam("id", id).
                when().get(Environment.BASE_URL+endpoint).then().extract().response();
        jsonPath=response.jsonPath();
    }

    @And("get email address from API")
    public void getEmailAddressFromAPI() {
        emailAPI=jsonPath.getString("students.contact.emailAddress[0]");
    }
    @Given("get email address from DB by using id")
    public void get_email_address_from_db_by_using_id() {
        String query="select email_address from contacts\n" +
                "where student_id=116";
        DB_Util.runQuery(query);
        emailDB=DB_Util.getFirstRowFirstColumn();
    }

    @Then("compare all datas from DB and UI and API and should be match")
    public void compareAllDatasFromDBAndUIAndAPIAndShouldBeMatch() {
        System.out.println("emailDB = " + emailDB);
        System.out.println("emailUI = " + emailUI);
        System.out.println("emailAPI = " + emailAPI);
        Assert.assertEquals(emailUI, emailDB);
        Assert.assertEquals(emailUI, emailAPI);
    }

}
