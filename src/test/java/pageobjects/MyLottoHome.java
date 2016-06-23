package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by vr1470 on 20-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class MyLottoHome extends BaseClass {


    public MyLottoHome(WebDriver driver) {
        super(driver);

    }
    @FindBy(how=How.ID, using="loginLink")
    public static WebElement login;

    @FindBy(how=How.ID, using="loginForm_UserName")
    public static  WebElement userName;

    @FindBy(how=How.ID, using="loginForm_Password")
    public static WebElement passWord;

    @FindBy(how= How.ID, using="loginForm_action_login")
    public static WebElement loginSubmit;

    @FindBy(how = How.ID, using="accountLogout")
    public static WebElement Logout;

}
