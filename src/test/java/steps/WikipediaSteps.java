package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.WikipediaSearchPage;
import utils.Driver;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class WikipediaSteps {
    WebDriver driver;
    WikipediaSearchPage wikipediaSearchPage;
    @Before
    public void setup(){
        driver = Driver.getDriver();
        wikipediaSearchPage = new WikipediaSearchPage();
    }

    @When("user searches for {string} on Wikipedia")
    public void user_searches_for_on_Wikipedia(String key) {
        wikipediaSearchPage.searchBox.sendKeys(key);
        wikipediaSearchPage.searchButton.click();
    }
    @Then("user should see {string} in the first heading")
    public void user_should_see_in_the_first_heading(String heading) {
    Assert.assertTrue(wikipediaSearchPage.heading.isDisplayed());
    Assert.assertEquals(heading,wikipediaSearchPage.heading.getText());
    }

    @Then("user should see below languages around the logo")
    public void user_should_see_below_languages_around_the_logo(DataTable language) {
        for (int i = 0; i < language.asList().size(); i++) {
            Assert.assertEquals(language.asList().get(i),wikipediaSearchPage.listOfL.get(i).getText());
        }

    }



}
