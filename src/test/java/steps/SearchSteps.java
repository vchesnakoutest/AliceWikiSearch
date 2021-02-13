package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import pages.WikiMainPage;
import pages.WikiSearchPage;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;

public class SearchSteps {
    private static final String WIKI_URL = "http://en.wikipedia.org";
    private WikiSearchPage searchPage;
    private WebDriver driver;
    private WikiMainPage wikiMainPage;
    private String searchItem;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("Keyword for search is {string}")
    public void searchKeywordIsString(String keyword) {
        searchItem = keyword;
    }

    @When("User does search")
    public void search() {
        driver.get(WIKI_URL);
        wikiMainPage = new WikiMainPage(driver);
        wikiMainPage.searchByKeyword(searchItem);
        searchPage = new WikiSearchPage(driver);
    }

    @Then("Wiki page {string} is on the first page")
    public void assertSearchResult(String result) {
        assertThat(String.format("There are no results for search string '%s' on first search page", result),
                searchPage.getResultLinks(), 
                hasItem(result));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^I open Facebook URL and create new accounts with below data$")
    public void i_open_Facebook_URL_and_create_new_accounts_with_below_data(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).get("First Name"));
            System.out.println(list.get(i).get("Last Name"));
        }
    }
}

