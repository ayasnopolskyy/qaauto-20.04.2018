package page;

import org.openqa.selenium.WebDriver;

public abstract class LinkedInBasePage {

        protected WebDriver webDriver;

        public LinkedInBasePage(WebDriver webDriver){
            this.webDriver=webDriver;
        }

        public String getCurrentPageTitle() {
            return webDriver.getTitle();
        }

        abstract boolean isPageLoaded();
}
