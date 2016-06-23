package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DataHelper;
import helpers.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by vr1470 on 23-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class NewStepDefinition {

    public WebDriver driver;

//   public static List<HashMap<String,String>> datamap;

    public NewStepDefinition()
    {
        driver = Hooks.driver;

    }

    @Given("^I am in MyLotto Site$")
    public void i_am_in_MyLotto_Site() throws Throwable {

        driver.navigate().to(GlobalVariables.mylotto_url);

    }

    @Given("^I Login as registered user$")
    public void i_Login_as_registered_user() throws Throwable {
        PageFactory.initElements(driver, MyLottoHome.class);
        PageFactory.initElements(driver, GlobalVariables.class);

        MyLottoHome.login.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(MyLottoHome.userName));
        username.sendKeys(GlobalVariables.regression_user);
        MyLottoHome.passWord.sendKeys(GlobalVariables.password);
        MyLottoHome.loginSubmit.click();

    }

    @Given("^I navigate to PushToPlay page$")
    public void i_navigate_to_PushToPlay_page() throws Throwable {

        driver.navigate().to(GlobalVariables.p2p_url);

    }

    @Given("^I am logged in$")
    public void i_am_logged_in() throws Throwable {

        Assert.assertTrue(MyLottoHome.Logout.isDisplayed(), "User is logged in");
    }

    @Then("^the continue button should be enabled$")
    public void the_continue_button_should_be_enabled() throws Throwable {
        PageFactory.initElements(driver, PushToPlay.class);
        Assert.assertTrue(PushToPlay.Continue.isDisplayed());

    }

    @Given("^I do not have credit card to my account$")
    public void i_do_not_have_credit_card_to_my_account() throws Throwable {

        Assert.assertTrue(PushToPlay.AddCC.isDisplayed(), "Credit card is attached already");

    }

    @When("^I click Add Credit card$")
    public void i_click_Add_Credit_card() throws Throwable {

        PushToPlay.AddCC.click();


    }

    @Then("^I should be navigated to Add Credit card page$")
    public void i_should_be_navigated_to_Add_Credit_card_page() throws Throwable {
        PageFactory.initElements(driver, CreditCard.class);
        Assert.assertTrue(CreditCard.CreditCardPage.isDisplayed());

    }

    @Given("^I Select Favourite tab$")
    public void i_Select_Favourite_tab() throws Throwable {

        PushToPlay.FavTab.click();
        PushToPlay.TenDollarFav.click();

    }

    @Then("^I should be able to select my favourites$")
    public void i_should_be_able_to_select_my_favourites() throws Throwable {

        Assert.assertTrue(PushToPlay.TenDollarFav.isSelected(), "Unable to select Favourites");
    }
}