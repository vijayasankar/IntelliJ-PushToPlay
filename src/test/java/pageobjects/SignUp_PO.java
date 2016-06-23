package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by vr1470 on 21-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class SignUp_PO extends BaseClass {
    public SignUp_PO(WebDriver driver) {
        super(driver);
    }

    @FindBy(how= How.ID, using = "signupLink")
    public static WebElement SignUpLink;

    @FindBy(how= How.ID, using = "Form_SignupForm_FirstName")
    public static WebElement SignUp_FName;

    @FindBy(how= How.ID, using = "Form_SignupForm_LastName")
    public static WebElement SignUp_LName;

    @FindBy(how= How.ID, using = "BirthdayDay")
    public static WebElement BDay;

    @FindBy(how= How.ID, using = "BirthdayMonth")
    public static WebElement BMonth;

    @FindBy(how= How.ID, using = "BirthdayYear")
    public static WebElement BYear;

    @FindBy(how= How.ID, using = "Form_SignupForm_Gender_M")
    public static WebElement GenderM;

    @FindBy(how= How.ID, using = "Form_SignupForm_Gender_M")
    public static WebElement GenderF;

    @FindBy(how= How.ID, using = "LocationArea")
    public static WebElement Location;

    @FindBy(how= How.ID, using = "Form_SignupForm_PhoneAreaCode")
    public static WebElement AreaCode;

    @FindBy(how= How.ID, using = "Form_SignupForm_PhoneNumber")
    public static WebElement PhoneNumber;

    @FindBy(how= How.ID, using = "Form_SignupForm_Email")
    public static WebElement Email;

    @FindBy(how= How.ID, using = "Form_SignupForm_ConfirmEmail")
    public static WebElement ConfirmEmail;

    @FindBy(how= How.ID, using = "Form_SignupForm_Password")
    public static WebElement Password;

    @FindBy(how= How.ID, using = "Form_SignupForm_ConfirmPassword")
    public static WebElement ConfirmPassword;

    @FindBy(how= How.ID, using = "Form_SignupForm_Question")
    public static WebElement Question;

    @FindBy(how= How.ID, using = "Form_SignupForm_Answer")
    public static WebElement Answer;

    @FindBy(how= How.ID, using = "Form_SignupForm_TermsAndConditionsAgreed")
    public static WebElement Terms;

    @FindBy(how= How.ID, using = "signupButton")
    public static WebElement SignUpSubmit;

    @FindBy(how= How.ID, using = "loginForm_Password_")
    public static WebElement Login_password;









}
