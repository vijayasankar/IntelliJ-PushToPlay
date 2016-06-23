package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by vr1470 on 20-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class CreditCard extends BaseClass {
    public CreditCard(WebDriver driver) {
        super(driver);
    }




    @FindBy(how= How.ID, using="depositFundsContainer")
    public static WebElement CreditCardPage;

    @FindBy(how= How.ID, using="Form_DepositRegisterCCPart1Form_Amount")
    public static WebElement Amount;

    @FindBy(how= How.ID, using="Form_DepositRegisterCCPart1Form_CardNumber")
    public static WebElement CardNumber;

    @FindBy(how= How.ID, using="Form_DepositRegisterCCPart1Form_ExpiryMonth")
    public static WebElement ExpiryMonth;

    @FindBy(how= How.ID, using="Form_DepositRegisterCCPart1Form_ExpiryYear")
    public static WebElement ExpiryYear;

    @FindBy(how= How.ID, using="Form_DepositRegisterCCPart1Form_CardHolderName")
    public static WebElement CardHolderName;

    @FindBy(how= How.ID, using="Form_DepositRegisterCCPart1Form_Cvc2")
    public static WebElement CVC;

    @FindBy(how= How.ID, using="Form_DepositRegisterCCPart1Form_MylottoPassword")
    public static WebElement password;

    @FindBy(how= How.ID, using="Form_DepositRegisterCCPart1Form_action_DepositRegisterCCPart1Continue")
    public static WebElement Continue;

    @FindBy(how= How.ID, using="depositSuccessWrapper")
    public static WebElement TopUpConfirmed;

    @FindBy(how= How.ID, using="FinishStraightToCC")
    public static WebElement OK;

}

