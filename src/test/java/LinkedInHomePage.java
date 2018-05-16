import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedInHomePage {

        private WebDriver webDriver;

        private WebElement profileMenu;

        public LinkedInHomePage(WebDriver webDriver) {
            this.webDriver = webDriver;
            initElements();
        }

        public void initElements() {
            try {
                sleep (5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            profileMenu = webDriver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        }

        public boolean isProfileMenuDisplayed(){
            return profileMenu.isDisplayed();
        }

}
