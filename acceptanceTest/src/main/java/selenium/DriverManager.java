package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private Logger log = Logger.getLogger(getClass());
    private WebDriver driver;
    private WebDriverWait wait;

    private static DriverManager instance = null;

    protected DriverManager() {
        initialize();
    }

    public static DriverManager getInstance() {
        if(instance == null || instance.driver == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Initializes the WebDriver, the WebDriverWait and opens the browser
     */
    private void initialize() {
        String browser = System.getProperty("browserName");
        log.info("Initialize Selenium Web Driver");
        if (browser.equalsIgnoreCase("firefox")) {
            ProfilesIni allProfiles = new ProfilesIni();
            FirefoxProfile profile = allProfiles.getProfile("default-1473338308263");

            //Select the "Always ask me where to save files" option in firefox
            profile.setPreference("browser.download.useDownloadDir", false);
            profile.setPreference("plugin.state.npnpdraganddropplugin", 2);
            profile.setPreference("plugin.state.npasperaweb", 2);
            driver = new FirefoxDriver(profile);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(driverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 40, 500);
    }

    /**
     * Gets the WebDriver
     * @return
     */
    public WebDriver getWebDriver() {
        return driver;
    }

    /**
     * Gets the WebDriver Wait
     * @return
     */
    public WebDriverWait getWait() {
        return wait;
    }

    public int getImplicitWait() {
        return 30;
    }

    /**
     * Closes all the browser instances
     */
    public void quitDriver() {
        try {
            log.info("Quit driver");
            driver.quit();
        } catch (Exception e) {
            log.error("Unable to quit the WebDriver", e);
        }
        driver = null;
    }
}