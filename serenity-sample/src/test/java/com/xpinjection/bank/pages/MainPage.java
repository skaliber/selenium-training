// ============================================================================
//  File          : MainPage
//  Created       : 05.10.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package com.xpinjection.bank.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
@DefaultUrl("http://localhost:8080/bank")
public class MainPage extends PageObject {
    @FindBy(linkText = "Manage Accounts")
    private WebElement manageAccountsLink;

    public MainPage(final WebDriver driver) {
        super(driver);
    }

    public void openAccountsPage() {
        clickOn(manageAccountsLink);
        waitForTitleToAppear("Bank Accounts");
    }
}
