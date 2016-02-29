// ============================================================================
//  File          : UniqueAccountsTest
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2007 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class UniqueAccountsTest extends BaseSeleniumTest {
    @Before
    public void openAccountsManagement() {
        open("/bank");
        driver.findElement(By.linkText("Manage Accounts")).click();
    }

    @Test
    public void createDifferentAccounts() {
        String bobAccountId = registerAccount("Bob", 5);
        String johnAccountId = registerAccount("John", 2);
        Assert.assertFalse(bobAccountId.equals(johnAccountId));
    }

    @Test
    public void userNameSuggestions() {
        typeFirstLetterOfName("j");
        waitForSuggestions();
        selectFirstSuggestedName();
        Assert.assertEquals("John", driver.findElement(By.id("user")).getAttribute("value"));
    }

    //----------- Details -----------------------------------------------------------

    private void typeFirstLetterOfName(String firstLetter) {
        driver.findElement(By.id("user")).sendKeys(firstLetter);
    }

    private void selectFirstSuggestedName() {
        //driver.findElement(By.id("user")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".ac_results li")).click();
    }

    private void waitForSuggestions() {
        new WebDriverWait(driver, 30).until(visibilityOfElementLocated(By.cssSelector(".ac_results")));
    }

    private String registerAccount(String name, double amount) {
        driver.findElement(By.id("user")).sendKeys(name);
        driver.findElement(By.id("amount")).sendKeys(Double.toString(amount));
        driver.findElement(By.xpath("//input[@value='Create']")).click();
        return driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
    }
}
