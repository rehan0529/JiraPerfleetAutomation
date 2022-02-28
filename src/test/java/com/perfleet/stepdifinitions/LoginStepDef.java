package com.perfleet.stepdifinitions;

import com.perfleet.pages.LoginPage;
import com.perfleet.utilities.BrowserUtils;
import com.perfleet.utilities.ConfigurationReader;
import com.perfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class LoginStepDef {
    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters the {string} information")
    public void the_user_enters_the_information(String userType) {

        String username = null;
        String password = null;

        if (userType.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (userType.equals("sales Manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (userType.equals("store Manager")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }
        //send username and password and login
        loginPage.login(username, password);
    }

    @Then("the user should land on the {string} page")
    public void the_user_should_land_on_the_page(String expectedPage) {

        BrowserUtils.waitFor(5);
        String actualPage = new LoginPage().getPageSubTitle();
        Assert.assertTrue(actualPage.contains(expectedPage));

    }


    @And("copy the url, logout and paste the url in new browser")
    public void copyTheUrlLogoutAndPasteTheUrlInNewBrowser() {


        String copiedUrl = Driver.get().getCurrentUrl();
        new LoginPage().logOut();
        Driver.closeDriver();
        Driver.get().get(copiedUrl);

    }

    @When("the user enters the {string} login and {string}")
    public void theUserEntersTheLoginAnd(String userfromData, String passfromData) {

        loginPage.login(userfromData, passfromData);

    }

    @Then("a warning message {string} is displayed")
    public void aWarningMessageIsDisplayed(String expectedMsg) {
        BrowserUtils.waitFor(5);
        String actualMsg = new LoginPage().passErrorMsg.getText();
        Assert.assertEquals(expectedMsg, actualMsg);

    }

    @When("the user enters the {string} login and {string} password")
    public void theUserEntersTheLoginAndPassword(String blankUserName, String blankPassword) {

        loginPage.login(blankUserName, blankPassword);
    }

    @Then("an alert warning {string} is displayed")
    public void anAlertWarningIsDisplayed(String expectedPromptAlert) {
        BrowserUtils.waitFor(2);
        String actualpromptAlert = loginPage.userName.getAttribute("validationMessage");
        Assert.assertEquals(expectedPromptAlert, actualpromptAlert);
    }

    @When("the user enters the {string} and {string}information")
    public void theUserEntersTheAndInformation(String username, String password) {
        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @Then("the user should see password in bullet signs only while typing")
    public void theUserShouldSeePasswordInBulletSignsOnlyWhileTyping() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(loginPage.password.getAttribute("placeholder").equals("Password"));
    }

    @When("the user click on the {string} link")
    public void theUserClickOnTheLink(String forgotpasswordlink) {
        loginPage.forgotPassword.click();
        BrowserUtils.waitFor(2);
    }

    @Then("he should land on the {string} page")
    public void heShouldLandOnThePage(String forgotpasswrodPage) {
        Assert.assertTrue(Driver.get().getTitle().contains(forgotpasswrodPage));
        Driver.get().get("https://qa.perfleet.com/user/login");
    }


    @And("the user enters the valid username as {string}")
    public void theUserEntersTheValidUsernameAs(String usernamefromfeature) {

        loginPage.forgotPasswordInputBox.sendKeys(usernamefromfeature);
        BrowserUtils.waitFor(3);

    }

    @When("click on {string} link")
    public void clickOnLink(String requestlink) {
        loginPage.request.click();
        BrowserUtils.waitFor(3);

    }

    @Then("the user should see an email is sent to change the password")
    public void theUserShouldSeeAnEmailIsSentToChangeThePassword() {

        //Assert.assertFalse(loginPage.emailSentMsg.isDisplayed());
        Assert.assertEquals("Email is Sent", loginPage.emailSentMsg.getText());
    }

    @When("the user see the {string} checkbox")
    public void theUserSeeTheLink(String checkboxlink) {

        Assert.assertTrue(loginPage.remembermeCheckbox.isDisplayed());
        BrowserUtils.waitFor(3);

    }

    @Then("the user can see and click the checkbox")
    public void theUserCanSeeAndClickTheCheckbox() {
        loginPage.remembermeCheckbox.click();
        Assert.assertTrue(loginPage.remembermeCheckbox.isEnabled());
    }


    @And("the user enters the valid credentials and press the {string} Keys")
    public void theUserEntersTheValidCredentialsAndPressTheKeys(String keys) {
        Actions actions = new Actions(Driver.get());
        loginPage.userName.sendKeys("User1");
        loginPage.password.sendKeys("UserUser123");
        //actions.sendKeys(Keys.ENTER);
        loginPage.submit.sendKeys(Keys.ENTER);
    }


    @Then("the user should see their own {string} in the profile menu")
    public void theUserShouldSeeTheirOwnInTheProfileMenu(String User1) {
        String actualName = loginPage.name.getText();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(User1,actualName);
    }

    @And("the user enters the Sales Manager information")
    public void theUserEntersTheSalesManagerInformation() {
        loginPage.login("salesmanager101","UserUser123");
    }

    @And("the user enters the Store Manager information")
    public void theUserEntersTheStoreManagerInformation() {

        loginPage.login("storemanager85","UserUser123");
    }
}
