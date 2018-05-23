import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


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
    public void basicSearchTest () {
        String searchTerm = "HR";
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");
        linkedinLoginPage.login("gor1362@gmail.com","p0o9P)O(");

        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(webDriver);
        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded");
        linkedInHomePage.search(searchTerm);

        LinkedinSearchPage linkedinSearchPage = new LinkedinSearchPage(webDriver);
        Assert.assertTrue(linkedinSearchPage.isPageLoaded(), "Home page is not loaded");

        //Assert.assertTrue(linkedinSearchPage.isSearchResultsCountValid(), "Search results count is not valid");
        //Assert.assertTrue(linkedinSearchPage.isSearchResultsContentValid(), "Search result is not contains HR");
        Assert.assertEquals(linkedinSearchPage.getResultsCount(), 10, "search results count is wrong.");
        List<String> resultsList = linkedinSearchPage.getResultsList();
        for (String result:resultsList){
            Assert.assertTrue(result.contains(searchTerm),
                    "Searchterm" +searchTerm+"is missing in following result: \n"+result );}


    }
}
