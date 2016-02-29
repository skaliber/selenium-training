// ============================================================================
//  File          : MainSlandoPage
//  Created       : 16.03.2014   
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
public class MainSlandoPage extends AbstractSlandoPage {
    public MainSlandoPage(WebDriver driver) {
        super(driver);
    }

    public MainSlandoPage open() {
        driver.get("http://slando.ua");
        return this;
    }

    public CategoryPage chooseCategory(String category) {
        clickLink(category);
        return new CategoryPage(driver);
    }
}
