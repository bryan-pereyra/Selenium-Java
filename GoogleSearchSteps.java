package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.GoogleSearchPage;

public class GoogleSearchSteps {

    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        /*
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("window-size=1920,1200");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        */

        driver = new ChromeDriver();
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Given("the user is on the Google search page")
    public void the_user_is_on_the_google_search_page() {
        googleSearchPage.goTo();
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String searchTerm) {
        googleSearchPage.searchFor(searchTerm);
    }

    @Then("the search results are displayed")
    public void the_search_results_are_displayed() {
        Assert.assertTrue(googleSearchPage.validateResultsAreDisplayed(), "No se encontraron resultados de búsqueda");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
