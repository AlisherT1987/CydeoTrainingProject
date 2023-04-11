package com.school.pages;

import com.school.pojo.cydeo.Student;
import com.school.pojo.cydeo.Students;
import com.school.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// page_url = https://training.cydeo.com/index.html?
public class DashboardPage extends BasePage {
    public DashboardPage() {
       PageFactory.initElements(Driver.get(), this);}

    @FindBy(xpath = "//span[.=' Students']")
    public WebElement linkStudents;
    @FindBy(xpath = "//a[contains(@href, 'add-student.html')]")
    public WebElement linkAddStudent;
    @FindBy(xpath = "//tbody[1]//tr")
    public WebElement allStudentsRow;
    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logOutBtn;

    @FindBy(xpath = "//img[@alt='Admin']")
    public WebElement image;



    public void studentProfileWithId(int id){
       WebElement profile= Driver.get().findElement(By.xpath("//a[contains(@href,'studentId="+id+"')]"));
profile.click();

    }

    /*
    public List<Map<String, Object>> ListOfStudents(){

        Students students=new Students();


    }

     */




}