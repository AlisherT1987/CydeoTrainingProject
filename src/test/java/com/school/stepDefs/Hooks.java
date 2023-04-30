package com.school.stepDefs;

import com.school.utilities.DB_Util;
import com.school.utilities.Driver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks {
    protected WebDriver driver;
    @Before("@db")
    public void dbHook() {
        System.out.println("creating database connection");
        DB_Util.createConnection();
    }

    @After("@db")
    public void afterDbHook() {
        System.out.println("closing database connection");
        DB_Util.destroy();

    }

    @Before("@ui")
    public void setUp() {
        // we put a logic that should apply to every scenario
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();

    }

    @After("@ui")
    public void tearDown(Scenario scenario) throws MalformedURLException {
        // only takes a screenshot if the scenario fails
        if (scenario.isFailed()) {
            // taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","screenshot");
        }
        Driver.closeDriver();
    }
    @Before("@mobile")
    public void mobileHook() throws MalformedURLException {
    /*    DesiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        URL url = new URL("http://localhost:4723/wd/hub");

        driver = new RemoteWebDriver(url, desiredCapabilities);

     */
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().get("https://training.cydeo.com/students-list.html");
    }

    @After("@mobile")
    public void afterMobileHook() {
        Driver.closeDriver();

    }
}
