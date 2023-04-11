package com.school.pages;

import com.school.utilities.ConfigurationReader;
import com.school.utilities.Driver;
import com.school.utilities.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://training.cydeo.com/login.html
public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//input[@type='text']")
    public WebElement input;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement input2;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//a[contains(@href, 'forgot')]")
    public WebElement linkForgotYourPassword;



    public void login(){
        input.sendKeys(Environment.USERNAME);
        input2.sendKeys(Environment.USER_PASSWORD);
        buttonLogin.click();
    }
}