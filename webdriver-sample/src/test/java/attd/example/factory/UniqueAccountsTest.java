// ============================================================================
//  File          : UniqueAccountsTest
//  Created       : 25.02.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package attd.example.factory;

import attd.example.selenium.junit.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class UniqueAccountsTest extends BaseSeleniumTest {
    private AccountsPage accountsPage;

    @Before
    public void openAccountsPage() {
        accountsPage = new MainPage(driver).open()
                .openAccountsManagement();
    }

    @Test
    public void createDifferentAccounts() {
        accountsPage = accountsPage.registerAccount("Bob", 5);
        String bobAccountId = accountsPage.getRegisteredUserId(1);
        accountsPage = accountsPage.registerAccount("John", 2);
        String johnAccountId = accountsPage.getRegisteredUserId(1);

        Assert.assertFalse(bobAccountId.equals(johnAccountId));
    }

    @Test
    public void userNameSuggestions() {
        accountsPage.typeFirstLetterOfName("j")
                .waitForSuggestions()
                .selectFirstSuggestedName();

        Assert.assertEquals("John", accountsPage.getUserName());
    }
}
