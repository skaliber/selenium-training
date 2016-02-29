// ============================================================================
//  File          : AccountsPage
//  Created       : 25.02.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package attd.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class AccountsPage extends AbstractPage {
    private Table accountsTable;
    private Form registrationForm;

    public AccountsPage(WebDriver driver) {
        super(driver);
        initPageElements();
    }

    private void initPageElements() {
        accountsTable = new Table(findByCss("table"));
        registrationForm = new Form(findByCss("form"));
    }

    public String registerAccount(String name, double amount) {
        registrationForm.set("user", name)
                .set("amount", "" + amount)
                .submit();
        initPageElements();
        return accountsTable.getCell(1, 1).getText();
    }

    public int getRegisteredUsersCount() {
        return accountsTable.getRowCount();
    }

    public String getRegisteredUserName(int index) {
        return accountsTable.getCell(index, 2).getText();
    }

    public AccountsPage typeFirstLetterOfName(String letter) {
        registrationForm.set("user", letter);
        return this;
    }

    public AccountsPage selectFirstSuggestedName() {
        //findById("user").sendKeys(Keys.ENTER);
        findByCss(".ac_results li").click();
        return this;
    }

    public AccountsPage waitForSuggestions() {
        new WebDriverWait(context, 30).until(visibilityOfElementLocated(By.cssSelector(".ac_results")));
        return this;
    }

    public String getUserName() {
        return registrationForm.getFieldValue("user");
    }
}
