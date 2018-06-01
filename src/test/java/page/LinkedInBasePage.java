package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * class with methods for  inheritance
 */
public abstract class LinkedInBasePage {

        protected WebDriver webDriver;
        public static GMailService gMailService = new GMailService();


    /**
     * Constructor for LinkedinBasePage class
     * @param webDriver - current webDriver object
     */
        public LinkedInBasePage(WebDriver webDriver){
            this.webDriver=webDriver;
        }



    /**
     *get page title text to check that correct page is opened. used in login test
     */
        public String getCurrentPageTitle() {
            return webDriver.getTitle();
        }

    /**
     * method with abstract requirements that should be used on each class
     */
        abstract boolean isPageLoaded();

        public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
                WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
               return webElement;
           }
}
