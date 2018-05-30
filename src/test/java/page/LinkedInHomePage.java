package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedInHomePage extends LinkedInBasePage {

    @FindBy (xpath = "//li[@id='profile-nav-item']")
    private WebElement profileMenu;
    @FindBy (xpath = "//input[@role and @placeholder='Search']")
    private WebElement searchField;

    public LinkedInHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return profileMenu.isDisplayed();
    }


    public LinkedinSearchPage search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return PageFactory.initElements(webDriver, LinkedinSearchPage.class);
        //return new LinkedinSearchPage(webDriver);

    }



}
