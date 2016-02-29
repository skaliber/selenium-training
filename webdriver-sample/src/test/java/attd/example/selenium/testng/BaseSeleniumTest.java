// ============================================================================
//  File          : BaseSeleniumTest
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2007 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class BaseSeleniumTest {
    protected static final int APP_PORT = 8080;
    protected static final String APP_URL = "http://localhost:" + APP_PORT;

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @BeforeMethod
    public void openBrowser() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        URL hubUrl = new URL("http://localhost:4444/wd/hub");
        driver.set(new RemoteWebDriver(hubUrl, capabilities));
        driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    protected WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.get().quit();
    }
}