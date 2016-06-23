package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by vr1470 on 21-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class BankDetails extends BaseClass {
    public BankDetails(WebDriver driver) {
        super(driver);
    }

    @FindBy(how= How.ID, using = "Form_saveAccountSetUp_Account1")
    public static WebElement Account1;

    @FindBy(how= How.ID, using = "Form_saveAccountSetUp_Account2")
    public static WebElement Account2;

    @FindBy(how= How.ID, using = "Form_saveAccountSetUp_Account3")
    public static WebElement Account3;

    @FindBy(how= How.ID, using = "Form_saveAccountSetUp_Account4")
    public static WebElement Account4;

    @FindBy(how= How.ID, using = "Form_saveAccountSetUp_action_saveAccountSetUp")
    public static WebElement SaveAccount;
}
