// ============================================================================
//  File          : BaseSeleniumTest
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2007 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import attd.example.selenium.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class BaseSeleniumTest {
    private static final int APP_PORT = 8080;
    private static final String APP_URL = "http://localhost:" + APP_PORT;

    protected WebDriver driver;

    @Before
    public void openBrowser() throws Exception {
        driver = WebDriverFactory.configureIE();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    protected void open(String relativePath) {
        driver.get(APP_URL + relativePath);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}