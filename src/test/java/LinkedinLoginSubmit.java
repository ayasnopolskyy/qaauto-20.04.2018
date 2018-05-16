import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmit {
    private WebDriver webDriver;

    private WebElement errorMessage;

    public LinkedinLoginSubmit(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private void initErrorMessage()   {
        errorMessage = webDriver.findElement(By.xpath("//div[@id='control_gen_1']"));
    }


    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }


}
