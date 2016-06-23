package stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

/**
 * Created by vr1470 on 20-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class Hooks{
    public static WebDriver driver;


    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
        System.out.println("Called openBrowser");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }


    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
        driver.quit();

    }

}
