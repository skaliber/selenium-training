// ============================================================================
//  File          : AbstractPage
//  Created       : 25.02.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package attd.example.elements;

import org.openqa.selenium.WebDriver;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class AbstractPage extends AbstractSearchContext<WebDriver> {
    protected static final int APP_PORT = 8080;
    protected static final String APP_URL = "http://localhost:" + APP_PORT;

    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    protected void open(String relativePath) {
        context.get(APP_URL + relativePath);
    }

    protected void clickLink(String linkText) {
        findLink(linkText).click();
    }
}
