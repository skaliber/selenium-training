// ============================================================================
//  File          : MainPage
//  Created       : 25.02.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package attd.example.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class MainPage extends AbstractPage {
    @FindBy(linkText = "Manage Accounts")
    @CacheLookup
    private WebElement manageAccountsLink;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        open("/bank");
        return this;
    }

    public AccountsPage openAccountsManagement() {
        manageAccountsLink.click();
        return new AccountsPage(driver);
    }
}
