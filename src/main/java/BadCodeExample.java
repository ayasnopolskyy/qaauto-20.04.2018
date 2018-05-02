import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.*;
import java.util.List;

import static java.lang.Thread.sleep;


public class BadCodeExample {

    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello world!!!");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.google.com");
        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys("Selenium" );
        searchField.sendKeys(Keys.RETURN);
        sleep (3000);
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        System.out.println("Number of results: "+searchResults.size());
        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            if (searchResultText.contains("Selenium")) {
                System.out.println("Search term found in result");
            }
            System.out.println("XXXX");
            System.out.println(searchResultText);

        }

        sleep (5000);
        webDriver.close();


    }


}
