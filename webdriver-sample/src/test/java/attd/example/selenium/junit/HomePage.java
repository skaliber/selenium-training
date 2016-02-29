// ============================================================================
//  File          : HomePage
//  Created       : 27.02.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class HomePage {
    @FindBy(name = "text")
    private WebElement searchBox;

    @FindBy(xpath = "//button[text()='Найти']")
    private WebElement searchButton;

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage open() {
        driver.get("http://rozetka.com.ua");
        return this;
    }

    public SearchResultsPage searchByKeyword(String keyword) {
        searchBox.sendKeys(keyword);
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
