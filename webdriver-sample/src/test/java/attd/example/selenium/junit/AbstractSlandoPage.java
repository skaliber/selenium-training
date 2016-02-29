// ============================================================================
//  File          : AbstractSlandoPage
//  Created       : 16.03.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class AbstractSlandoPage {
    protected final WebDriver driver;

    public AbstractSlandoPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickLink(String category) {
        driver.findElement(By.linkText(category)).click();
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
