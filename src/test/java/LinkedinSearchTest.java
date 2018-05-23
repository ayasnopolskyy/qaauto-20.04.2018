import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LinkedinSearchTest {

    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }


    @Test
    public void LinkedinSearchTest () {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");
        linkedinLoginPage.login("gor1362@gmail.com","p0o9P)O(");

        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(webDriver);
        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded");
        linkedInHomePage.search("HR");

        LinkedinSearchResultsPage linkedinSearchResultsPage = new LinkedinSearchResultsPage(webDriver);
        Assert.assertTrue(linkedinSearchResultsPage.isPageLoaded(), "Home page is not loaded");

        Assert.assertTrue(linkedinSearchResultsPage.isSearchResultsCountValid(), "Search results count is not valid");
        Assert.assertTrue(linkedinSearchResultsPage.isSearchResultsContentValid(), "Search result is not contains HR");

    }
}
