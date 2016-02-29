// ============================================================================
//  File          : AbstractRozetkaPage
//  Created       : 09.02.2014   
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
public class AbstractRozetkaPage {
    private static final String BASE_URL = "http://rozetka.com.ua";

    protected final WebDriver driver;

    public AbstractRozetkaPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    protected void open(String relativePath) {
        driver.navigate().to(BASE_URL + relativePath);
    }
}
