package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by vr1470 on 20-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class MyAccount extends BaseClass {
    public MyAccount(WebDriver driver) {
        super(driver);
    }

    @FindBy(how= How.ID, using="myAccount")
    public static WebElement MyAccountLink;

    @FindBy(how=How.ID, using="account-details-link")
    public static WebElement GoToMyAccountPage;

    @FindBy(how=How.PARTIAL_LINK_TEXT, using="Services")
    public static WebElement GoToMyServicesPage;

    @FindBy(how=How.CLASS_NAME, using="notifications-content")
    public static WebElement P2PContent;

    @FindBy(how=How.XPATH, using="id('myAcccountP2PContentWrapper')/x:div[3]/x:div[1]")
    public static WebElement TicketName;

    @FindBy(how=How.XPATH, using="id('myAcccountP2PContentWrapper')/x:div[3]/x:div[2]")
    public static WebElement Price;

    @FindBy(how=How.XPATH, using="id('myAcccountP2PContentWrapper')/x:div[3]/x:div[3]")
    public static WebElement PhoneNumber;

    @FindBy(how=How.PARTIAL_LINK_TEXT, using="Stop")
    public static WebElement Stop;

    @FindBy(how=How.CLASS_NAME, using="create-button")
    public static WebElement Create;



}
