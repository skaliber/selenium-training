// ============================================================================
//  File          : UniqueAccountsTest
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2007 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.testng;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class UniqueAccountsTest extends BaseSeleniumTest {
    @Test
    public void createDifferentAccounts() {
        WebDriver driver = getDriver();
        driver.get(APP_URL + "/bank");
        driver.findElement(By.linkText("Manage Accounts")).click();
        driver.findElement(By.id("user")).sendKeys("Bob");
        driver.findElement(By.id("amount")).sendKeys("5");
        driver.findElement(By.xpath("//input[@value='Create']")).click();
        String bobAccountId = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
        driver.findElement(By.id("user")).sendKeys("John");
        driver.findElement(By.id("amount")).sendKeys("2");
        driver.findElement(By.xpath("//input[@value='Create']")).click();
        String johnAccountId = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
        Assert.assertFalse(bobAccountId.equals(johnAccountId));
    }

    @Test
    public void userNameSuggestions() {
        WebDriver driver = getDriver();
        driver.get(APP_URL + "/bank");
        driver.findElement(By.linkText("Manage Accounts")).click();
        driver.findElement(By.id("user")).sendKeys("j");
        new WebDriverWait(driver, 30).until(new Predicate<WebDriver>() {
            public boolean apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector(".ac_results")).isDisplayed();
            }
        });
        driver.findElement(By.id("user")).sendKeys(Keys.ENTER);
        //driver.findElement(By.cssSelector(".ac_results li")).click();
        Assert.assertEquals("John", driver.findElement(By.id("user")).getAttribute("value"));
    }
}