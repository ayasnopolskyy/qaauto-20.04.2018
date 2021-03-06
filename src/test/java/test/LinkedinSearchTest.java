package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInHomePage;
import page.LinkedinSearchPage;

import java.util.List;


/**
 * Class with Seacrh test method
 */
public class LinkedinSearchTest extends LinkedinBaseTest {


    /**
     * method with basic search flow test
     * uses login, isPageLoaded, getResultsCount, getResultList
     * redirects from home page to search results page
     */
    @Test
    public void basicSearchTest () {
        String searchTerm = "HR";
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedInHomePage linkedInHomePage = linkedinLoginPage.login("gor1362@gmail.com","1p0o9P)O(");

        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded");

        LinkedinSearchPage linkedinSearchPage = linkedInHomePage.search(searchTerm);
        Assert.assertTrue(linkedinSearchPage.isPageLoaded(), "Home page is not loaded");

        Assert.assertEquals(linkedinSearchPage.getResultsCount(), 10, "search results count is wrong.");
        List<String> resultsList = linkedinSearchPage.getResultsList();
        for (String result:resultsList){
            Assert.assertTrue(result.contains(searchTerm),
                    "Searchterm" +searchTerm+"is missing in following result: \n"+result );}

    }
}
