package modules;

import helpers.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pageobjects.MyLottoHome;

import java.util.HashMap;
import java.util.List;

/**
 * Created by vr1470 on 20-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class SignIn {

    public static void Execute(WebDriver driver, List<HashMap<String,String>> map) throws Exception{

        MyLottoHome.login.click();
        Log.info("Login Link is Clicked" );
        MyLottoHome.userName.sendKeys(map.get(0).get("username"));
        Log.info("Email is entered into username" );
        MyLottoHome.userName.sendKeys(map.get(0).get("password"));
        Log.info("Email is entered into username" );
        MyLottoHome.loginSubmit.click();
        Log.info("Click action is performed on Submit button");
        Reporter.log("SignIn Action is successfully perfomred");
    }
}
