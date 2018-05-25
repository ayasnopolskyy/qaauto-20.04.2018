package page;

import org.openqa.selenium.*;
import page.LinkedInBasePage;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Thread.sleep;

public class LinkedinSearchPage extends LinkedInBasePage {

    private WebElement profileMenu;
    List<WebElement> searchResults;
    WebElement resultsCounter;

    public LinkedinSearchPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    public boolean isPageLoaded() {
        return resultsCounter.isDisplayed();

    }

    public void initElements() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resultsCounter = webDriver.findElement(By.xpath("//h3[contains(text(), 'results')]"));
        profileMenu = webDriver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        searchResults = webDriver.findElements(By.xpath("//li[contains(@class, 'search-result__occluded-item')]"));
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













