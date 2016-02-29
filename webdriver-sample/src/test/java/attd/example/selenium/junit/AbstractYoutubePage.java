// ============================================================================
//  File          : AbstractYoutubePage
//  Created       : 28.02.2014   
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
public class AbstractYoutubePage {
    protected final WebDriver driver;

    public AbstractYoutubePage(WebDriver driver) {
        this.driver = driver;
    }
}
