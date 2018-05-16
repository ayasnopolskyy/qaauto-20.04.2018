import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmit {
    private WebDriver webDriver;

    private WebElement errorMessageElement;

    public LinkedinLoginSubmit(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    private void initElements()   {

        errorMessageElement = webDriver.findElement(By.xpath("//div[@role='alert']"));
    }


    //public boolean isErrorMessageDisplayed() {
      //  return errorMessageElement.isDisplayed();
    //}

    public String getErrorMessageText(){
        return errorMessageElement.getText();
    }


}
