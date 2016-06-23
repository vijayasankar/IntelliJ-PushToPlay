package pageobjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by vr1470 on 20-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class BaseClass {
    public static WebDriver driver;
    public static boolean bResult;

    public  BaseClass(WebDriver driver){
        BaseClass.driver = driver;
        BaseClass.bResult = true;
    }
}
