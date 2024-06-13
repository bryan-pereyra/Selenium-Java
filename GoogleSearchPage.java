package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(css = "div.g")
    private List<WebElement> searchResults;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://www.google.com.mx/?hl=es");
    }

    public void searchFor(String searchFor) {
        searchBox.sendKeys(searchFor);
        searchBox.submit();

        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
    }

    public boolean validateResultsAreDisplayed() {
        return searchResults.size() > 0;
    }
}
