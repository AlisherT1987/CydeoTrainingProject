package com.school.pages;

import com.school.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentPageAPK {
    public StudentPageAPK(){
        PageFactory.initElements(Driver.get(),this );

    }
    @FindBy (tagName = "input")
    public WebElement studentName;
    @FindBy (xpath = "//a[@href='edit-student.html?studentId=116']")
    public WebElement editBtn;
    @FindBy (xpath = "//label[.='Email']/..//input")
    public WebElement email;
    @FindBy (tagName = "h5")
    public WebElement headerName;

    @FindBy (xpath = " //label[.='Student ID']")
    public WebElement studentID;


}
