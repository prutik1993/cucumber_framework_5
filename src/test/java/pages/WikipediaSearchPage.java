package pages;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class WikipediaSearchPage {

    public WikipediaSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "searchInput")
    public WebElement searchBox;
    @FindBy(css = "i[data-jsl10n='search-input-button']")
    public WebElement searchButton;
    @FindBy(css = "#firstHeading>span")
    public WebElement heading;
    @FindBy(css = ".link-box > strong")
    public List<WebElement> listOfL;

}
