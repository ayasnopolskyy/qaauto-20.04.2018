package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedinLoginPage;

/**
 * Class for method inheritance
 */
public class LinkedinBaseTest {

    WebDriver webDriver;
    LinkedinLoginPage linkedinLoginPage;


    /**
     * The annotated method will be run before each test method.
     * opens Firefox browser and going to linkedin.com
     * used by each Test Class by inheritance
      */
    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
        linkedinLoginPage = new LinkedinLoginPage (webDriver);
    }

    /**
     * The annotated method will be run after each test method.
     * Close Firefox browser
     * used by each Test Class by inheritance
     */
    @AfterMethod
    public void after () {
        webDriver.close();
    }


}
