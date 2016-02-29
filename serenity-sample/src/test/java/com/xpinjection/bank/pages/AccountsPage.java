// ============================================================================
//  File          : AccountsPage
//  Created       : 05.10.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package com.xpinjection.bank.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
@At("#HOST/bank/accounts.html")
public class AccountsPage extends PageObject {
    @FindBy(id = "user")
    private WebElement userField;

    @FindBy(id = "amount")
    private WebElement amountField;

    public AccountsPage(final WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String userName) {
        enter(userName).into(userField);
    }

    public void enterAmount(double amount) {
        enter(Double.toString(amount)).into(amountField);
    }

    public void registerAccount() {
        userField.submit();
    }

    public String getLastRegisteredAccountId() {
        return getDriver().findElement(By.xpath("//tr[1]/td[1]")).getText();
    }
}

