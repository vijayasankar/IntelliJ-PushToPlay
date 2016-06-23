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
public class Signout {

    public static void Execute(WebDriver driver, List<HashMap<String,String>> map) throws Exception{
        MyLottoHome.Logout.click();
        Log.info("Sign out is performed");
        Reporter.log("Sign out is performed");
    }
}
