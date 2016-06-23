package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by vr1470 on 20-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class LottoPowerBall extends BaseClass {
    public LottoPowerBall(WebDriver driver) {
        super(driver);
    }

    @FindBy(how= How.LINK_TEXT, using="Text service")
    public static WebElement TextService;
}
