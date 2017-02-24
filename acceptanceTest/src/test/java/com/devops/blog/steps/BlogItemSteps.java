package com.devops.blog.steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.BlogPage;
import selenium.DriverManager;

import static org.testng.Assert.*;

/**
 * Created by Marylin Moya on 2/19/2017.
 */
public class BlogItemSteps {
    /**
     * Creates a Collection with Assets by the API
     */
    @Given("^I navigate to Blog site page$")
    public void goToBlogSite() {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        driver.navigate().to(System.getProperty("blogUrl"));
    }

    @Given("^I found \"(.*?)\" in Blog page$")
    public void searchAuthor(String author) {
        BlogPage blogPage = new BlogPage();
        assertEquals(blogPage.getAuthor(),"Posted on None by "+author);
    }

    @Given("^\"(.*?)\" and \"(.*?)\" are displayed$")
    public void verifyTitleAndBody(String title, String bodyText) {
        BlogPage blogPage = new BlogPage();
        assertEquals(blogPage.getTitle(),title);
        assertEquals(blogPage.getBodyText(),bodyText);
    }
}
