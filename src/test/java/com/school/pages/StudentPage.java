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
import java.util.Objects;

// page_url = https://training.cydeo.com/add-student.html
public class StudentPage extends  BasePage {

    public StudentPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(tagName = "h5")
    public WebElement header;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonSubmit;

    @FindBy(xpath = "//*[@id='message']")
    public WebElement textareaMessage;
    @FindBy(xpath = "(//input)[2]")
    public WebElement studentName;

    @FindBy(xpath = "//a[contains(@class, 'mt-4')]")
    public WebElement linkSearch;

   @FindBy(xpath = "//h3[contains(@class,'user-name')]")
   public WebElement userName;




    public void validInputs(Map<String, String> newStudent) {

        for (Map.Entry<String, String> stringObjectEntry : newStudent.entrySet()) {
            if (!Objects.equals(stringObjectEntry.getKey(), "Gender") && !Objects.equals(stringObjectEntry.getKey(), "Batch")&&!Objects.equals(stringObjectEntry.getKey(), "Permanent Address")) {
                WebElement eachInput = Driver.get().findElement(By.xpath("//div[contains(label,'" + stringObjectEntry.getKey() + "')]//input"));
                BrowserUtils.waitFor(1);
                eachInput.sendKeys(stringObjectEntry.getValue());
            } else if (Objects.equals(stringObjectEntry.getKey(), "Permanent Address")) {
                textareaMessage.sendKeys(stringObjectEntry.getValue());

            } else {
                Select select = new Select(Driver.get().findElement(By.xpath("//div[contains(label,'" + stringObjectEntry.getKey() + "')]//select")));
                BrowserUtils.waitFor(1);
                select.selectByVisibleText(stringObjectEntry.getValue());
            }
        }
    }
    public String searchStudent(String firstName){
        studentName.sendKeys(firstName);
        BrowserUtils.waitFor(1);
        linkSearch.click();
        BrowserUtils.waitFor(1);
        WebElement tagName=Driver.get().findElement(By.xpath("//a[.='"+firstName+"']"));
        tagName.click();
        BrowserUtils.waitFor(1);
        return userName.getText();
    }
}