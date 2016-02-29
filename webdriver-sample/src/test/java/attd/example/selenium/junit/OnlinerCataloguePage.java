// ============================================================================
//  File          : OnlinerCataloguePage
//  Created       : 16.05.2014   
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
public class OnlinerCataloguePage extends AbstractOnlinerPage {
    public OnlinerCataloguePage(WebDriver driver) {
        super(driver);
    }

    public OnlinerSearchPage chooseCategory(String category) {
        driver.findElement(By.linkText(category)).click();
        return new OnlinerSearchPage(driver);
    }
}
