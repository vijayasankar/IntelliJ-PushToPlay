package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by vr1470 on 20-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class PushToPlay extends BaseClass {
    public PushToPlay(WebDriver driver) {
        super(driver);
    }

    @FindBy(how= How.CLASS_NAME, using = "dip-triple")
    public static WebElement TripleDipTab;

    @FindBy(how= How.ID, using = "lotto-triple-mega")
    public static WebElement MegaTriple;

    @FindBy(how=How.ID, using = "lotto-triple-superplus")
    public static WebElement SuperPlusTriple;

    @FindBy(how=How.ID, using = "lotto-triple-super")
    public static WebElement SuperTriple;

    @FindBy(how=How.ID, using = "lotto-triple-basic")
    public static WebElement BasicTriple;

    @FindBy(how=How.ID, using = "mobileCode")
    public static WebElement mobileCode;
    //*[@id="mobileCode"]/div/ul/li[2]

    @FindBy(how=How.CLASS_NAME, using = "fav")
    public static WebElement FavTab;


    @FindBy(how=How.CLASS_NAME, using = " 10dollar")
    public static WebElement TenDollarFav;



    @FindBy(how=How.CLASS_NAME, using = "logged-out-state")
    public static WebElement LoggedOutState;

    @FindBy(how=How.ID, using = "mobileNumber")
    public static WebElement mobileNumber;

    @FindBy(how=How.ID, using = "p2pJackpots")
    public static WebElement Jackpot;

    @FindBy(how=How.ID, using = "Payment_Use_Existing_CreditCard")
    public static WebElement ExistingCC;



    @FindBy(how=How.XPATH, using = "html/body/div[4]/div/div/div/div[2]/div[2]/div[4]/div/div/div/div/div[1]/div)")
    public static WebElement AddCC;



    @FindBy(how=How.ID, using = "SubCreationCCTopUp")
    public static WebElement ChangeCCLink;
    @FindBy(how=How.ID, using = "payment-disabled")
    public static WebElement DisabledCC;

    @FindBy(how=How.ID, using = "dialog-confirm-verification-code")
    public static WebElement CodeModal;

    @FindBy(how=How.ID, using = "Form_codeVerificationForm_Code_")
    public static WebElement EnterCode;

    @FindBy(how=How.ID, using = "tickmark_")
    public static WebElement tick;

    @FindBy(how=How.ID, using = "closeButton")
    public static WebElement CodeModalClose;


    @FindBy(how=How.CLASS_NAME, using = "action action-close")
    public static WebElement WarningModalClose;

    @FindBy(how=How.ID, using = "Form_codeVerificationForm_action_codeVerificationContinue_")
    public static WebElement ContinueVerification;

    @FindBy(how=How.ID, using = "dialog-active-existing-notification")
    public static WebElement WarningMessage;


    @FindBy(how=How.CLASS_NAME, using = "action action-cofirm")
    public static WebElement WaringContinue;


    @FindBy(how=How.ID, using = "dialog-custom-")
    public static WebElement SuccessMessage;

    @FindBy(how=How.ID, using = "button-custom-ok_")
    public static WebElement SuccessOK;

    @FindBy(how=How.ID, using = "dialogBox")
    public static WebElement ErrorModal;



    @FindBy(how=How.CLASS_NAME, using = "p2p-error-message")
    public static WebElement ErrorMessage;



    @FindBy(how=How.ID, using = "tnc")
    public static WebElement Terms;


    @FindBy(how=How.ID, using = "dialog-p2pTermsAndConditions")
    public static WebElement TermsModal;

    @FindBy(how=How.ID, using = "p2pTermsAndConditionsAgreed")
    public static WebElement TnCBox;


    @FindBy(how=How.ID, using = "Form_SetupPlanForm_action_doSetupPlanForm")
    public static WebElement Continue;

    @FindBy(how=How.ID, using = "startNow-disabled")
    public static WebElement DisabledContinue;

    @FindBy(how=How.ID, using = "outerBodyWrapper")
    public static WebElement outside;

    @FindBy(how=How.ID, using = "LoginFormOnDemand_")
    public static WebElement LoginDemand;


}
