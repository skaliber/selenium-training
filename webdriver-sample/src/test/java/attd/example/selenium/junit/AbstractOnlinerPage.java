// ============================================================================
//  File          : AbstractOnlinerPage
//  Created       : 16.05.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.openqa.selenium.WebDriver;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class AbstractOnlinerPage {
    protected final WebDriver driver;

    public AbstractOnlinerPage(WebDriver driver) {
        this.driver = driver;
    }
}
