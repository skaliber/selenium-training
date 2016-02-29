// ============================================================================
//  File          : AccountSteps
//  Created       : 05.10.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package com.xpinjection.bank.steps;

import com.xpinjection.bank.pages.AccountsPage;
import com.xpinjection.bank.pages.MainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class AccountSteps extends ScenarioSteps {
    private static final long serialVersionUID = -5925860936709794564L;

    public AccountSteps(final Pages pages) {
        super(pages);
    }

    @Step
    public String registerAccount(String userName, double amount) {
        AccountsPage accountsPage = pages().get(AccountsPage.class);
        onSamePage().enterUserName(userName);
        onSamePage().enterAmount(amount);
        accountsPage.registerAccount();
        return accountsPage.getLastRegisteredAccountId();
    }

    @Step
    public void enterAmount(double amount) {
        onAccountsPage().enterAmount(amount);
    }

    @Step
    public void enterUserName(String userName) {
        onAccountsPage().enterUserName(userName);
    }

    @Step
    public void openAccountsPage() {
        MainPage mainPage = getPages().get(MainPage.class);
        mainPage.open();
        mainPage.openAccountsPage();
    }

    private AccountsPage onAccountsPage() {
        return getPages().currentPageAt(AccountsPage.class);
    }

    private AccountSteps onSamePage() {
        return onSamePage(AccountSteps.class);
    }
}

