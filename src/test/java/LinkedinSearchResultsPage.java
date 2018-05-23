
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

import static java.lang.Thread.sleep;


public class LinkedinSearchResultsPage extends LinkedInBasePage {


    private WebElement profileMenu;
    List<WebElement> searchResults;

    public LinkedinSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    boolean isPageLoaded() {
        return profileMenu.isDisplayed();

    }

    public void initElements() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profileMenu = webDriver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        searchResults = webDriver.findElements(By.xpath("//div[@class='search-entity search-result search-result--person search-result--occlusion-enabled ember-view']"));
    }


    public boolean isSearchResultsCountValid() {
        //List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='search-entity search-result search-result--person search-result--occlusion-enabled ember-view']"));
        System.out.println(searchResults.size());
        return searchResults.size()==10;
    }

     public boolean isSearchResultsContentValid() {
        //List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='search-entity search-result search-result--person search-result--occlusion-enabled ember-view']"));
        int listItemsCount =0;
        for (WebElement searchResult : searchResults)
                System.out.println(searchResult.getText());
            //if (searchResult.getText().contains("*HR*"))
        {listItemsCount++;}
        return listItemsCount==10;
    }

}













