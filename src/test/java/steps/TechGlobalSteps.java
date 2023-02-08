package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utils.AlertHandler;
import utils.Driver;

public class TechGlobalSteps {


    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalAlertsPage techGlobalAlertsPage;
    TechGlobalLoginFormPage techGlobalLoginFormPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage= new TechGlobalDynamicTablesPage();
        techGlobalAlertsPage = new TechGlobalAlertsPage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
    }

    @When("user clicks on Practices dropdown in the header")
    public void userClicksOnPracticesDropdownInTheHeader() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
    }

    @And("user selects the {string} option")
    public void userSelectsTheOption(String option) {
        switch (option) {
            case "Frontend Testing":
                techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
                break;
            case "Dynamic Tables":
            case "Alerts":
            case "Login Form":
                techGlobalFrontendTestingHomePage.clickOnCard(option);
                break;
            default:
                throw new NotFoundException();
        }
    }

    @Then("user should see {string} heading")
    public void userShouldSeeHeading(String headerText) {
        switch (headerText){
            case "Dynamic Tables":
                Assert.assertEquals(headerText, techGlobalDynamicTablesPage.headingText.getText());
                break;
            case "Alerts":
                Assert.assertEquals(headerText, techGlobalAlertsPage.headingText.getText());
                break;
            case "Login Form":
                Assert.assertEquals(headerText, techGlobalLoginFormPage.header.getText());
                break;
            default:
                throw  new NotFoundException("The heading text is not defined");

        }

    }

    @When("user clicks the {string} button")
    public void userClicksTheButton(String argument) {
        switch (argument){
            case "ADD PRODUCT":
                techGlobalDynamicTablesPage.addProductButton.click();
                break;
            case "CLOSE":
                techGlobalDynamicTablesPage.closeButton.click();
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file");
        }
    }

    @Then("validate {string} pop-up is displayed")
    public void validatePopUpIsDisplayed(String popup) {
        Assert.assertEquals(popup, techGlobalDynamicTablesPage.modalCardTitle.getText());
    }

    @Then("user should not see Add New Product pop-up")
    public void userShouldNotSeeAddNewProductPopUp() {
        try{
        Assert.assertFalse(techGlobalDynamicTablesPage.modalCardTitle.isDisplayed());
        }catch(NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @Then("user should see buttons as {string}, {string}, and {string}")
    public void user_should_see_buttons_as_and(String warning, String conformation, String prompt) {
        Assert.assertEquals(warning,techGlobalAlertsPage.alertButtons.get(0).getText());
        Assert.assertEquals(conformation,techGlobalAlertsPage.alertButtons.get(1).getText());
        Assert.assertEquals(prompt,techGlobalAlertsPage.alertButtons.get(2).getText());
    }

    @Then("user should see {string} text")
    public void user_should_see_text(String resultText) {
        Assert.assertEquals(resultText,techGlobalAlertsPage.resultTitle.getText());
    }

    @When("user clicks on {string} box")
    public void user_clicks_on_box(String warningAlert) {
        techGlobalAlertsPage.clickOnAlert(warningAlert);
    }

    @Then("user should see a popup displaying message {string}")
    public void user_should_see_a_popup_displaying_message(String expectedText) {
        Assert.assertEquals(expectedText, AlertHandler.getAlertText());
        AlertHandler.acceptAlert();
    }
    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {
     techGlobalLoginFormPage.inputs.get(0).sendKeys(username);
     techGlobalLoginFormPage.inputs.get(1).sendKeys(password);
     techGlobalLoginFormPage.loginButton.click();
    }
    @Then("user should see a {string} message")
    public void user_should_see_a_message(String message) {
        switch (message){
            case "Invalid Username entered!":
            case "Invalid Password entered!":
                Assert.assertEquals(message,techGlobalLoginFormPage.errorMessage.getText());
                break;
            case "You are logged in":
                Assert.assertEquals(message,techGlobalLoginFormPage.messageAfterSuccessfulLogin.getText());
                break;
            default:
                throw new NotFoundException("The error is not defined properly in the feature file");
        }
    }


}