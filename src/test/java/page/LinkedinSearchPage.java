package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * page object for LinkedinSearchPage
 */
public class LinkedinSearchPage extends LinkedInBasePage {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileMenu;

    @FindBy(xpath = "//h3[contains(text(), 'results')]")
    List<WebElement> searchResults;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    WebElement resultsCounter;

    /**
     * constructor for LinkedinSearchPage class
     * @param webDriver - current webDriver object
     * variables are initialized, but assigns values at the time of the call
     */
    public LinkedinSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * checks that page is loaded
     * @return true or false
     */
    @Override
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(resultsCounter, 40);
        return resultsCounter.isDisplayed();
    }

    /**
     * checks that search results lists contains text on each element
     */
    public List<String> getResultsList() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement  searchResult:searchResults) {
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", searchResult);
            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }

    /**
     * gets and returns count of search results
     */
    public int getResultsCount() {return searchResults.size();
    }
}













