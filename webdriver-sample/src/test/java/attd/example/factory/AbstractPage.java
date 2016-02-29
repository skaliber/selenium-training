// ============================================================================
//  File          : AbstractPage
//  Created       : 25.02.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package attd.example.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class AbstractPage {
    protected static final int APP_PORT = 8080;
    protected static final String APP_URL = "http://localhost:" + APP_PORT;

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void open(String relativePath) {
        driver.get(APP_URL + relativePath);
    }

    protected WebElement findByXPath(String xpathLocator) {
        return driver.findElement(By.xpath(xpathLocator));
    }
}
