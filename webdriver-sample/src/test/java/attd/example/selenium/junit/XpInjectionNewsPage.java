// ============================================================================
//  File          : XpInjectionNewsPage
//  Created       : 26.02.2015   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2015 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class XpInjectionNewsPage {
    private final WebDriver driver;

    @FindBy(name = "s")
    private WebElement searchInput;

    @FindBy(css = "#searchform .submit")
    private WebElement searchButton;

    public XpInjectionNewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public XpInjectionNewsPage searchByText(String keywords) {
        searchInput.sendKeys(keywords);
        searchButton.click();
        return new XpInjectionNewsPage(driver);
    }

    public int getResultsCount() {
        return driver.findElements(By.className("post")).size();
    }
}
