package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * PageObject for LinkedinPasswordChangedPage
 */
public class LinkedinPasswordChangedPage extends LinkedInBasePage {

    @FindBy(xpath = "//input[@class='nav__base--logged-in nav__button--back-to-linkedin']")
        private WebElement goToHomeButton;


    /**
     * constructor for LinkedinPasswordChangePage
     * @param webDriver - current webDriver object
     * variables are initialized, but assigns values at the time of the call
     */
        public  LinkedinPasswordChangedPage (WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
         }

    /**
     * checks that page is loaded by searching go to Home button
     */
        @Override
       boolean isPageLoaded() {
            return goToHomeButton.isDisplayed();
        }


    /**
     * clicks go to Home button
     */
       public void tapGoToHomeButton() {
             goToHomeButton.click();
        }


}
