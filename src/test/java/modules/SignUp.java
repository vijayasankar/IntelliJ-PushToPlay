package modules;

import cucumber.api.java.ro.Si;
import helpers.GlobalVariables;
import helpers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import pageobjects.BankDetails;
import pageobjects.BaseClass;
import pageobjects.SignUp_PO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by vr1470 on 21-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class SignUp extends BaseClass {
    public SignUp(WebDriver driver) {
        super(driver);
    }


    public WebDriver  driver;

    public static void Execute(WebDriver driver,HashMap<String,String> map) throws Exception{

        driver.get(GlobalVariables.mylotto_url);
        SignUp_PO.SignUpLink.click();
        Log.info("Sign Up is started");
        Reporter.log("Sign up is started");
        SignUp_PO.SignUp_FName.sendKeys("Automation");
        SignUp_PO.SignUp_LName.sendKeys("User");
        Select dSelect = new Select(SignUp_PO.BDay);
        dSelect.selectByVisibleText("06");
        Select mSelect = new Select(SignUp_PO.BMonth);
        mSelect.selectByVisibleText("July");
        Select ySelect = new Select(SignUp_PO.BYear);
        ySelect.selectByVisibleText("1985");

        SignUp_PO.GenderM.click();

        Select location = new Select(SignUp_PO.Location);
        location.selectByVisibleText("Auckland");

        SignUp_PO.AreaCode.sendKeys("022");
        SignUp_PO.PhoneNumber.sendKeys("5123453");


        final String randomEmail = randomEmail();

        SignUp_PO.Email.sendKeys(randomEmail);
        SignUp_PO.ConfirmEmail.sendKeys(randomEmail);

        SignUp_PO.Password.sendKeys("password1");
        SignUp_PO.ConfirmPassword.sendKeys("password1");



        Select qSelect = new Select(SignUp_PO.Question);
        qSelect.selectByValue("1");

        SignUp_PO.Answer.sendKeys("puppy");
        SignUp_PO.Terms.click();
        SignUp_PO.SignUpSubmit.click();


        driver.navigate().to(activationLink());
        SignUp_PO.Login_password.sendKeys("password1");

        BankDetails.Account1.sendKeys(map.get("Account1"));
        BankDetails.Account2.sendKeys(map.get("Account2"));
        BankDetails.Account3.sendKeys(map.get("Account3"));
        BankDetails.Account4.sendKeys(map.get("Account4"));
        BankDetails.SaveAccount.click();


    }

    private static String randomEmail() {
        return "push" + UUID.randomUUID().toString() + "@test.com";
    }
    private static String activationLink() throws Exception {


        String dbUrl = "jdbc:db2//10.2.71.130:50000/esi_db";

        String username = "gtkinst1";

        String password = "gtkinst1";

        Class.forName("com.ibm.db2.jcc.DB2Driver");

        Connection con = DriverManager.getConnection(dbUrl,username,password);

        Statement stmt = con.createStatement();

        String activationIDQuery = "select activation_id from nzdev.es_security where user_name = "+ "random";

        ResultSet rs= stmt.executeQuery(activationIDQuery);

        String activationID  = rs.getString(1);

        return GlobalVariables.mylotto_url+"activation?activationid="+activationID;
    }
}
