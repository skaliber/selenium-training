// ============================================================================
//  File          : IdealAccountsPage
//  Created       : 06.10.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package attd.example;

import attd.example.elements.Form;
import attd.example.elements.Table;
import attd.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class IdealAccountsPage extends AbstractPage {
    //wrapped automatically by name or id
    private Form accountForm;

    @FindBy(css = "table")
    private Table accounts;

    public IdealAccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AbstractPage open() {
        open("/manageAccounts");
        return this;
    }

    public AbstractPage registerAccount(String name, double amount) {
        accountForm.set("user", name)
                .set("amount", "" + amount)
                .submit();
        return new IdealAccountsPage(driver);
    }

    public int getRegisteredUsersCount() {
        return accounts.getRowCount();
    }
}




