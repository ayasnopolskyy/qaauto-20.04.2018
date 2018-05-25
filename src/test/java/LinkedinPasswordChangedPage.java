import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinPasswordChangedPage extends LinkedInBasePage {


        private WebElement goToHomeButton;


        public  LinkedinPasswordChangedPage (WebDriver webDriver) {
            super(webDriver);
            initElements();
        }

        @Override
        boolean isPageLoaded() {
            return goToHomeButton.isDisplayed();
        }


        private void initElements() {
            goToHomeButton = webDriver.findElement(By.xpath("//input[@class='nav__base--logged-in nav__button--back-to-linkedin']"));

        }

         public void tapGoToHomeButton() {
             goToHomeButton.click();
        }


}
