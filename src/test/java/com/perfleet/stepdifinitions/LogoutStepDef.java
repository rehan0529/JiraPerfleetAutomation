package com.perfleet.stepdifinitions;

import com.perfleet.pages.LoginPage;
import com.perfleet.pages.LogoutPage;
import com.perfleet.utilities.BrowserUtils;
import com.perfleet.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class LogoutStepDef {
    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @When("user clicks on the {string} button from profile menu")
    public void user_clicks_on_the_button_from_profile_menu(String string) {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(loginPage.logOut);
        BrowserUtils.waitFor(3);
    }

    @Then("the user back is on the login page")
    public void theUserBackIsOnTheLoginPage() {
        String actual = Driver.get().getTitle();
        String expected = "Login";
        Assert.assertEquals("Login",actual);
    }

    @When("the user click on {string} button")
    public void theUserClickOnButton(String backbutton) {
        Actions actions = new Actions(Driver.get());
        actions.sendKeys(Keys.BACK_SPACE);
        BrowserUtils.waitFor(2);


    }

    @When("the user copy the url close all the tabs and paste the Copied url into new Browser")
    public void theUserCopyTheUrlCloseAllTheTabsAndPasteTheCopiedUrlIntoNewBrowser() {

        String OpenedUrl = Driver.get().getCurrentUrl();
        BrowserUtils.waitFor(4);
        Driver.closeDriver();

        Driver.get().get(OpenedUrl);


    }

    @When("the user waits for {int} minutes")
    public void theUserWaitsForMinutes(int seconds) {
        BrowserUtils.waitFor(180);

    }
}
