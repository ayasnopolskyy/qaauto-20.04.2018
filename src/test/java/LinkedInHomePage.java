import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedInHomePage extends LinkedInBasePage {

    private WebElement profileMenu;
    private WebElement searchField;

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
        searchField = webDriver.findElement(By.xpath("//input[@role and @placeholder='Search']"));
    }

    public void search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
    }



}
