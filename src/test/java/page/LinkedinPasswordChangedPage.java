package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinPasswordChangedPage extends LinkedInBasePage {

    @FindBy(xpath = "//input[@class='nav__base--logged-in nav__button--back-to-linkedin']")
        private WebElement goToHomeButton;


        public  LinkedinPasswordChangedPage (WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
         }

        @Override
       boolean isPageLoaded() {
            return goToHomeButton.isDisplayed();
        }



       public void tapGoToHomeButton() {
             goToHomeButton.click();
        }


}
