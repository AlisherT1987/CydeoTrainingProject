package com.school.pages;

import com.school.utilities.BrowserUtils;
import com.school.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

// page_url = https://training.cydeo.com/add-student.html
public class StudentPage extends  BasePage{

    public StudentPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(tagName = "h5")
    public WebElement header;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonSubmit;
    public void validInputs(Map<String,String> newStudent){

        for (Map.Entry<String, String> stringObjectEntry : newStudent.entrySet()) {
if(stringObjectEntry.getKey().equalsIgnoreCase("Gender")||stringObjectEntry.getKey().equalsIgnoreCase("Batch")){
    Select select=new Select(Driver.get().findElement(By.xpath("//div[contains(label,'"+stringObjectEntry.getKey()+"')]//select")));
    BrowserUtils.waitFor(1);
    select.selectByVisibleText(stringObjectEntry.getValue());
    
}
            BrowserUtils.waitFor(1);
            WebElement eachInput= Driver.get().findElement(By.xpath("//div[contains(label,'"+stringObjectEntry.getKey()+"')]//input"));
            BrowserUtils.waitFor(1);
            eachInput.sendKeys(stringObjectEntry.getValue());
            BrowserUtils.waitFor(1);
        }
    }
}