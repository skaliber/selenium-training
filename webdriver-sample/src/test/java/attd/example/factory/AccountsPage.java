// ============================================================================
//  File          : AccountsPage
//  Created       : 25.02.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package attd.example.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class AccountsPage extends AbstractPage {
    @FindBy(id = "user")
    @CacheLookup
    private WebElement userName;

    @CacheLookup
    private WebElement amount;

    @FindBy(xpath = "//input[@value='Create']")
    @CacheLookup
    private WebElement createButton;

    public AccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountsPage registerAccount(String name, double money) {
        userName.sendKeys(name);
        amount.sendKeys(Double.toString(money));
        createButton.click();
        return new AccountsPage(driver);
    }

    public String getRegisteredUserId(int index) {
        return findByXPath("//tbody/tr[" + index + "]/td[1]").getText();
    }

    public String getRegisteredUserName(int index) {
        return findByXPath("//tbody/tr[" + index + "]/td[2]").getText();
    }

    public AccountsPage typeFirstLetterOfName(String letter) {
        userName.sendKeys("j");
        return this;
    }

    public AccountsPage selectFirstSuggestedName() {
        //userName.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".ac_results li")).click();
        return this;
    }

    public AccountsPage waitForSuggestions() {
        new WebDriverWait(driver, 30).until(visibilityOfElementLocated(By.cssSelector(".ac_results")));
        return this;
    }

    public String getUserName() {
        return userName.getAttribute("value");
    }
}
