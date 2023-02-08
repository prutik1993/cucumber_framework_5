package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.EtcyPage;
import utils.Driver;
import io.cucumber.datatable.DataTable;

public class EtcySteps {
WebDriver driver;
EtcyPage etcyPage;

   @Before
    public void setup(){
    driver = Driver.getDriver();
    etcyPage = new EtcyPage();
}

    @Then("user should see dropdown options")
    public void user_should_see_dropdown_options(DataTable dropdownLabels) {
        for (int i = 0; i < etcyPage.dropdownOptions.size(); i++) {
            Assert.assertEquals(dropdownLabels.asList().get(i),etcyPage.dropdownOptions.get(i).getText());
        }
    }
}
