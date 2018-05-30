package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class LinkedinSearchPage extends LinkedInBasePage {

    @FindBy(xpath = "//h3[contains(text(), 'results')]")
    private WebElement profileMenu;
    @FindBy(xpath = "//li[@id='profile-nav-item']")
    List<WebElement> searchResults;
    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    WebElement resultsCounter;

    public LinkedinSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return resultsCounter.isDisplayed();
    }

    public List<String> getResultsList() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement  searchResult:searchResults) {
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", searchResult);
            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }

    public int getResultsCount() {return searchResults.size();
    }
}













