package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DataHelper;
import helpers.Database;
import helpers.GlobalVariables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CreditCard;
import pageobjects.MyAccount;
import pageobjects.MyLottoHome;
import pageobjects.PushToPlay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by vr1470 on 21-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class stepDefinitions {

    public WebDriver driver;

    public static List<HashMap<String,String>> datamap;

    public stepDefinitions()
    {
        driver = Hooks.driver;
        datamap = DataHelper.data();
       // System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");

    }

    @When("^Fill all the fields and Continue$")
    public void fill_all_fields_and_Continue() throws Throwable {

    PageFactory.initElements(driver, PushToPlay.class);
        PushToPlay.MegaTriple.click();
        PushToPlay.mobileNumber.sendKeys("7657588");
        Assert.assertTrue(PushToPlay.ExistingCC.isDisplayed());
        PushToPlay.TnCBox.click();
        PushToPlay.Continue.click();
   }

    @Then("^I validate title and URL$")
    public void validate_title_url() throws Throwable {
        PageFactory.initElements(driver, GlobalVariables.class);
        assertEquals(GlobalVariables.p2p_url,driver.getCurrentUrl());

    }

    @When("^I enter correct verification code$")
    public void enter_verification_code() throws Throwable {

        Assert.assertTrue(PushToPlay.CodeModal.isDisplayed());

        System.out.println("Verification code modal is displayed.. Waiting for Code......");

        String dbUrl = "jdbc:mysql://10.2.71.187:3306/push2play_int3";
        String username = "resultrelay";
        String password = "resultrelay";
        String query = "select code from push2play_int3.verification_code order by created  desc limit 1;;";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbUrl,username,password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        while (rs.next())
        {
            String code  = rs.getString(1);
            WebElement box = wait.until(ExpectedConditions.elementToBeClickable(PushToPlay.EnterCode));
            box.sendKeys(code);
            System. out.println(code);
        }

        con.close();

        WebDriverWait tick_wait = new WebDriverWait(driver, 10);

        WebElement greenTick = tick_wait.until(ExpectedConditions.elementToBeClickable(PushToPlay.tick));
        Assert.assertTrue(greenTick.isDisplayed());

        PushToPlay.ContinueVerification.click();

        WebDriverWait warning_wait = new WebDriverWait(driver, 10);

        WebElement warning = warning_wait.until(ExpectedConditions.elementToBeClickable(PushToPlay.WarningMessage));
        if(warning.isDisplayed())
        {

            PushToPlay.WaringContinue.click();
            System.out.println("Existing Notification available....");
        }
        else
        {

            System.out.println("New Notification has been set up successfully....");

        }

        WebDriverWait reminder_continue_wait = new WebDriverWait(driver, 10);

        WebElement reminder_continue = reminder_continue_wait.until(ExpectedConditions.elementToBeClickable(By.name("Continue")));
        reminder_continue.click();

    }


    @Then("^I should get success message$")
    public void dispay_success_message() throws Throwable {

        WebDriverWait success_wait = new WebDriverWait(driver, 10);

        WebElement success = success_wait.until(ExpectedConditions.elementToBeClickable(PushToPlay.SuccessMessage));
        Assert.assertTrue(success.isDisplayed());

        PushToPlay.SuccessOK.click();

    }

    @Then("^the details should be displayed in My Accounts page$")
    public void details_MyAccounts_page() throws Throwable {

        PageFactory.initElements(driver, MyAccount.class);
        MyAccount.MyAccountLink.click();
        MyAccount.GoToMyAccountPage.click();
        MyAccount.GoToMyServicesPage.click();
        Assert.assertTrue(MyAccount.P2PContent.isDisplayed());


        System.out.println("Ticket Name" + MyAccount.TicketName);
        System.out.println("Price" + MyAccount.Price);
        System.out.println("Phone Number" + MyAccount.PhoneNumber);

        Assert.assertTrue(driver.findElement(By.xpath("id('myAcccountP2PContentWrapper')/x:div[3]/x:div[4]/x:span/x:a")).isDisplayed());


    }
    @Given("^I am not logged in$")
    public void not_logged_in() throws Throwable {

        driver.get(GlobalVariables.mylotto_url);
        //Assert.assertTrue(MyLottoHome.login.isDisplayed());
        System.out.println("User is not logged in yet");


    }

    @When("^I navigate to PushToPlay homepage$")
    public void navigateTo_p2pHome() throws Throwable {

        driver.get(GlobalVariables.p2p_url);

    }

    @When("^I login successfully$")
    public void i_login_successfully() throws Throwable {






    }

    @Then("^I should be landing in PushToPlay homepage$")
    public void LandingP2PHome() throws Throwable {


    }

    @When("^I enter username and Password$")
    public void EnterUserData() throws Throwable {



    }

    @Then("^I should be logged in successfully$")
    public void i_should_be_logged_in_successfully() throws Throwable {


    }

    @Then("^Favourites should not have existing favourites$")
    public void noFavoritesExisting() throws Throwable {
        PageFactory.initElements(driver, PushToPlay.class);
        PushToPlay.FavTab.click();
        Assert.assertTrue(PushToPlay.LoggedOutState.isDisplayed());


    }

    @Then("^Credit card details should not be displayed$")
    public void noCreditCardDetails() throws Throwable {

        Assert.assertTrue(PushToPlay.DisabledCC.isDisplayed());
    }

    @Then("^Continue button should not be enabled$")
    public void continue_disabled() throws Throwable {

        Assert.assertTrue(PushToPlay.DisabledContinue.isDisplayed());

    }

    @Given("^I am logged in already$")
    public void logged_in_already() throws Throwable {

        driver.get(GlobalVariables.mylotto_url);
        MyLottoHome.login.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(MyLottoHome.userName));
        username.sendKeys("push3@test.com");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(MyLottoHome.passWord));
        password.sendKeys("password1");
        MyLottoHome.loginSubmit.click();

        Assert.assertTrue(MyLottoHome.Logout.isDisplayed());

    }

    @Then("^Credit card details should be displayed$")
    public void displayCreditCardDetails() throws Throwable {


        Assert.assertTrue(PushToPlay.ExistingCC.isDisplayed());
    }

    @Then("^Continue button should be enabled$")
    public void continue_enabled() throws Throwable {


        Assert.assertTrue(PushToPlay.Continue.isDisplayed());

    }

    @When("^I select Dips$")
    public void selectDips() throws Throwable {

        PushToPlay.SuperPlusTriple.click();

    }

    @When("^I enter the phone number$")
    public void enterPhoneNumber() throws Throwable {



        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement mobile = wait.until(ExpectedConditions.elementToBeClickable(PushToPlay.mobileNumber));

        mobile.sendKeys(String.valueOf("7657588"));

    }

    @Then("^Login modal should be displayed$")
    public void displayLoginModal() throws Throwable {
        PushToPlay.outside.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement loginModal = wait.until(ExpectedConditions.elementToBeClickable(PushToPlay.LoginDemand));

        Assert.assertTrue(loginModal.isDisplayed());
    }

    @Given("^I do not have credit card attached with my account$")
    public void noExistingCreditCard() throws Throwable {


        PageFactory.initElements(driver, MyLottoHome.class);
        Assert.assertTrue(MyLottoHome.Logout.isDisplayed());
        driver.get(GlobalVariables.p2p_url);
        MyLottoHome.login.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(MyLottoHome.userName));
        username.sendKeys("random@test24.com");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(MyLottoHome.passWord));
        password.sendKeys("password1");
        MyLottoHome.loginSubmit.click();


        assertEquals(0, PushToPlay.ExistingCC.getSize());
        System.out.println("No Credit card is attached");

    }


    @Given("^I click Add Credit Card$")
    public void AddCreditCard() throws Throwable {


        PushToPlay.AddCC.click();
    }

    @Then("^I should be able to navigated to add credit card page$")
    public void attachCreditCard() throws Throwable {


        Assert.assertTrue(CreditCard.CreditCardPage.isDisplayed());

    }

    @When("^I click change credit card$")
    public void click_change_credit_card() throws Throwable {

        PushToPlay.ChangeCCLink.click();

    }

    @Then("^I should be able to change the credit card$")
    public void change_credit_card() throws Throwable {

        PageFactory.initElements(driver, CreditCard.class);
        Assert.assertTrue(CreditCard.CreditCardPage.isDisplayed());
        CreditCard.Amount.sendKeys("11");
        CreditCard.CardNumber.sendKeys("4111111111111111");
        CreditCard.ExpiryMonth.sendKeys("09");
        CreditCard.ExpiryYear.sendKeys("17");
        CreditCard.CardHolderName.sendKeys("Automation");
        CreditCard.CVC.sendKeys("222");
        CreditCard.password.sendKeys("password1");
        CreditCard.Continue.click();
        Assert.assertTrue(CreditCard.TopUpConfirmed.isDisplayed() );

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement credit = wait.until(ExpectedConditions.elementToBeClickable(CreditCard.OK));
        credit.click();
    }



    @When("^I click terms and conditions$")
    public void click_terms_and_conditions_link() throws Throwable {

        driver.findElement(By.id("tnc")).click();



    }

    @Then("^TnC modal should be displayed$")
    public void display_tnc_modal() throws Throwable {

        Assert.assertTrue(PushToPlay.TermsModal.isDisplayed());


    }

    @When("^I select Favourites tab$")
    public void select_Favourites() throws Throwable {

        PushToPlay.FavTab.click();
        PushToPlay.TenDollarFav.click();

    }

    @When("^I select any dips from Dips tab$")
    public void select_Dips() throws Throwable

    {
        PushToPlay.MegaTriple.click();
    }

    @Then("^I should be able to CONTINUE the PushToPlay setup$")
    public void continue_PushToPlay_setup() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement mobile = wait.until(ExpectedConditions.elementToBeClickable(PushToPlay.mobileNumber));
        mobile.sendKeys(String.valueOf("7657588"));
        Assert.assertTrue(PushToPlay.ExistingCC.isDisplayed());
        PushToPlay.TnCBox.click();
        PushToPlay.Continue.click();


    }


    @When("^I click continue$")
    public void click_continue() throws Throwable {

        PushToPlay.Continue.click();

    }

    @Then("^I should be able to CANCEL the PushToPlay setup$")
    public void cancel_PushToPlay_setup() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(PushToPlay.CodeModal));

        if (cancel.isDisplayed())
        {
           PushToPlay.CodeModalClose.click();
            System.out.println("Push to play Set up cancelled successfully before the verification code");
        }
        else {
            Assert.assertTrue(PushToPlay.WarningMessage.isDisplayed());
            PushToPlay.WarningModalClose.click();
        }

    }
    @When("^I select TnC$")
    public void select_TnC() throws Throwable {
       PushToPlay.TnCBox.click();
    }


    @Given("^I have existing PushToPlay notification$")
    public void existing_PushToPlay_setup() throws Throwable {

        driver.get(GlobalVariables.p2p_url);
        MyLottoHome.login.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(MyLottoHome.userName));
        username.sendKeys("push3@test.com");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(MyLottoHome.passWord));
        password.sendKeys("password1");
        MyLottoHome.loginSubmit.click();


        MyAccount.MyAccountLink.click();
        MyAccount.GoToMyAccountPage.click();
        MyAccount.GoToMyServicesPage.click();

        System.out.println("Printing Existing notifications details....");
        System.out.println("     Existing Ticket Name......"+MyAccount.TicketName);
        System.out.println("     Existing Dollar Value........"+MyAccount.Price);
        System.out.println("     Existing Phone Number......"+MyAccount.PhoneNumber);


        if(MyAccount.Stop.isDisplayed())
        {
            System.out.println("P2P setup already exists");
        }

        else
        {
            System.out.println("P2P setup does not exist");
        }

    }

    @When("^I start new PushToPlay opt in$")
    public void start_PushToPlay_setup() throws Throwable {

        driver.get(GlobalVariables.p2p_url);

        PushToPlay.MegaTriple.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement mobile = wait.until(ExpectedConditions.elementToBeClickable(PushToPlay.mobileNumber));

        mobile.sendKeys(String.valueOf("7657588"));

        Assert.assertTrue(PushToPlay.ExistingCC.isDisplayed());

        PushToPlay.TnCBox.click();
        PushToPlay.Continue.click();
        Assert.assertTrue(PushToPlay.CodeModal.isDisplayed());
        System.out.println("Verification code modal is displayed.. Waiting for Code......");
        WebDriverWait wait1 = new WebDriverWait(driver, 10);

        String dbUrl = "jdbc:mysql://10.2.71.187:3306/push2play_int3";
        String username = "resultrelay";
        String password = "resultrelay";
        String query = "select code from push2play_int3.verification_code order by created  desc limit 1;;";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbUrl,username,password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);
        while (rs.next())
        {
            String code  = rs.getString(1);
            WebElement box = wait1.until(ExpectedConditions.elementToBeClickable(PushToPlay.EnterCode));
            box.sendKeys(code);
            System.out.println(code);
        }

        con.close();


        PushToPlay.ContinueVerification.click();

        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        WebElement warning = wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("dialog-active-existing-notification")));
        warning.click();

        if(!PushToPlay.WarningMessage.isDisplayed())
        {
            PushToPlay.WarningModalClose.click();
        }
        else
        {
            System.out.println("Existing Notification available....");

        }
    }

    @Then("^I should get warning message that existing notification will be removed$")
    public void warning_message_for_existing_notification() throws Throwable {
        Assert.assertTrue(PushToPlay.WarningMessage.isDisplayed());
    }

    @When("^I edit favourite without changing the wager amount$")
    public void editFav_noWagerChange() throws Throwable {

    }

    @Then("^my PushToPlay settings should be updated accordingly$")
    public void update_PushToPlay() throws Throwable {

    }

    @When("^I edit favourite by changing the wager amount$")
    public void editFav_WagerChange() throws Throwable {

    }

    @When("^I delete the favourite$")
    public void i_delete_the_favourite() throws Throwable {

    }

    @Then("^my PushToPlay settings should be deleted$")
    public void delete_PushToPlay() throws Throwable {

        Assert.assertTrue(MyAccount.Create.isDisplayed());
        System.out.println("P2P Notification deleted successfully");

    }

    @When("^I dont select any Dips or favourites$")
    public void noDipsOrFav() throws Throwable {

        PushToPlay.FavTab.click();
        PushToPlay.TripleDipTab.click();
        Assert.assertTrue(!PushToPlay.MegaTriple.isSelected());
        Assert.assertTrue(!PushToPlay.SuperPlusTriple.isSelected());
        Assert.assertTrue(!PushToPlay.SuperTriple.isSelected());
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement mobile = wait.until(ExpectedConditions.elementToBeClickable(PushToPlay.mobileNumber));
        mobile.sendKeys(String.valueOf("7657588"));
        Assert.assertTrue(PushToPlay.ExistingCC.isDisplayed());
        PushToPlay.TnCBox.click();
        PushToPlay.Continue.click();

    }

    @Then("^I should get error message for ticket type selection$")
    public void error_ticketType() throws Throwable {

        Assert.assertTrue(PushToPlay.ErrorModal.isDisplayed());
        String actual_error = PushToPlay.ErrorMessage.getText();
        System.out.println(actual_error);

    }

    @When("^I dont enter any phone number$")
    public void enter_nullPhone() throws Throwable {

       PushToPlay.mobileNumber.click();
       PushToPlay.mobileNumber.click();
       PushToPlay.Jackpot.click();

    }

    @Then("^I should get error message for empty phone number$")
    public void error_nullPhone() throws Throwable {

        //TODO Unable to validate the highlighted text box


        //Assert.assertTrue(driver.findElement(By.className("text message-right invalid")).isDisplayed(), "Error message is Not displayed");
//		String actual_error = driver.findElement(By.className("p2p-error-message")).getText();
//		System.out.println(actual_error);


    }
    @Then("^I should get error message for invalid phone number$")
    public void error_invalidPhone() throws Throwable {


    }
    @Then("^I dont enter NZ standard number$")
    public void enter_invalidPhone() throws Throwable {



    }

    @When("^I enter duplicate phone number$")
    public void enter_duplicatePhone() throws Throwable {


    }

    @Then("^I should get error message for duplicate phone number$")
    public void error_duplicatePhone() throws Throwable {

    }



    @When("^I enter Invalid verification code$")
    public void enter_invalidCode() throws Throwable {




    }

    @Then("^error message should be displayed for wrong verification code$")
    public void error_wrongCode() throws Throwable {







    }

    @When("^I click Stop from Settings page$")
    public void clickStop() throws Throwable {





    }
    @Given("^I edit my favourite without changing the wager amount$")
    public void EditFav_NoWagerChange() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("^I edit my favourite with wager change$")
    public void EditFav_WagerChange() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("^I do not have credit card attached$")
    public void No_CC() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
    @Given("^I click Resend link$")
    public void click_Resend() throws Throwable {

    }

    @When("^I should get new verification code$")
    public void newCode() throws Throwable {

    }

    @Then("^I old verification should be invalid$")
    public void oldCode() throws Throwable {

    }

    @Given("^I am in Push to play homepage$")
    public void P2PHomepage() throws Throwable {

    }

    @When("^I click AreaCode dropdown$")
    public void click_areaCode() throws Throwable {

    }

    @Then("^I should see all the areacode values are displayed$")
    public void areaCode_values() throws Throwable {

    }

    @When("^I click jackpot dropdown$")
    public void clcik_jackpot() throws Throwable {

    }

    @Then("^I should see all the jackpot values are displayed$")
    public void jackpot_values() throws Throwable {

    }

    @Given("^I have filled values in PushToPlay page$")
    public void values_filled() throws Throwable {

    }

    @When("^I navigate away and comeback again$")
    public void navigate_away() throws Throwable {

    }

    @Then("^no valus should be retained$")
    public void value_retention() throws Throwable {

    }

}

