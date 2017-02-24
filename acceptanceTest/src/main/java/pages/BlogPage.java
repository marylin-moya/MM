package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.DriverManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marylin Moya on 2/20/2017.
 */
public class BlogPage {
    By titleWebElement = By.cssSelector("h1");
    By bodyTextWebElement = By.cssSelector("h2");
    By authorWebElement = By.cssSelector("h3");
    private WebDriver driver;

    public BlogPage(){
        this.driver = DriverManager.getInstance().getWebDriver();
    }


    public String getTitle() {
        return driver.findElement(titleWebElement).getText();
    }

    public String getBodyText() {
        return driver.findElement(bodyTextWebElement).getText();
    }
    public String getAuthor() {

        return driver.findElement(authorWebElement).getText();
    }
}
