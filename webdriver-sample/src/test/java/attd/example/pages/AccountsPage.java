// ============================================================================
//  File          : AccountsPage
//  Created       : 25.02.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package attd.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class AccountsPage extends AbstractPage {
    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public String registerAccount(String name, double amount) {
        getUserInputField().sendKeys(name);
        findById("amount").sendKeys(Double.toString(amount));
        findByXPath("//input[@value='Create']").click();
        return findByXPath("//tbody/tr[1]/td[1]").getText();
    }

    public String getRegisteredUserName(int index) {
        return findByXPath("//tbody/tr[" + index + "]/td[2]").getText();
    }

    public AccountsPage typeFirstLetterOfName(String letter) {
        getUserInputField().sendKeys("j");
        return this;
    }

    public AccountsPage selectFirstSuggestedName() {
        //getUserInputField().sendKeys(Keys.ENTER);
        findByCss(".ac_results li").click();
        return this;
    }

    public AccountsPage waitForSuggestions() {
        new WebDriverWait(driver, 30).until(visibilityOfElementLocated(By.cssSelector(".ac_results")));
        return this;
    }

    public String getUserName() {
        return getUserInputField().getAttribute("value");
    }

    private WebElement getUserInputField() {
        return findById("user");
    }
}
