package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Page object for LinkedInHome Page with methods and variables
 */
public class LinkedInHomePage extends LinkedInBasePage {

    @FindBy (xpath = "//li[@id='profile-nav-item']")
    private WebElement profileMenu;
    @FindBy (xpath = "//input[@role and @placeholder='Search']")
    private WebElement searchField;

    /**
     * Constructor of LinkedinLoginPage class
     * @param webDriver - current webDriver object
     *  variables are initialized, but assigns values at the time of the call
     */
    public LinkedInHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * checks that page is loaded. returns true or false
     */
    @Override
    public boolean isPageLoaded() {
        return profileMenu.isDisplayed();
    }


    /**
     * method sends search query to according field and pressing thw Enter key
     * @return redirects to Linkedin Search Page
     */
    public LinkedinSearchPage search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return PageFactory.initElements(webDriver, LinkedinSearchPage.class);
        //return new LinkedinSearchPage(webDriver);

    }



}
