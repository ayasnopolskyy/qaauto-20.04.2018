import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedInHomePage extends LinkedInBasePage {

       private WebElement profileMenu;

    public LinkedInHomePage(WebDriver webDriver) {
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
    }

    public boolean isProfileMenuDisplayed() {
        return profileMenu.isDisplayed ();
    }


}