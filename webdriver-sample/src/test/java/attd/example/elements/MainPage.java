// ============================================================================
//  File          : MainPage
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
public class MainPage extends AbstractPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        open("/bank");
        return this;
    }

    public AccountsPage openAccountsManagement() {
        clickLink("Manage Accounts");
        return new AccountsPage(context);
    }
}
