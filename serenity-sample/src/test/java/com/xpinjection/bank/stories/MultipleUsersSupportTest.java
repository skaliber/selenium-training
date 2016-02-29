// ============================================================================
//  File          : MultipleUsersSupportTest
//  Created       : 05.10.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package com.xpinjection.bank.stories;

import com.xpinjection.bank.BankApplication;
import com.xpinjection.bank.steps.AccountSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertFalse;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */

@Issues({"#123", "#456"})
@RunWith(SerenityRunner.class)
@Story(BankApplication.AccountsManagement.MultipleUsersSupport.class)
public class MultipleUsersSupportTest {
    @Managed
    public WebDriver webDriver;

    @ManagedPages(defaultUrl = "http://localhost:8080")
    public Pages pages;

    @Steps
    public AccountSteps steps;

    @Test
    public void createDifferentAccounts() {
        steps.openAccountsPage();
        String bobAccountId = steps.registerAccount("Bob", 5);
        String johnAccountId = steps.registerAccount("John", 2);

        assertFalse(bobAccountId.equals(johnAccountId));
    }

    @Test
    @Pending
    @Issue("#WIKI-1")
    public void usersWithDifferentCaseInNameAreTheSame() {}
}

