import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LinkedinBaseTest {

    WebDriver webDriver;

    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void after () {
        webDriver.close();
    }


}
