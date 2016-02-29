// ============================================================================
//  File          : OnlinerSearchPage
//  Created       : 16.05.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
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
public class OnlinerSearchPage extends AbstractOnlinerPage {
    @FindBy(name = "search")
    private WebElement searchButton;

    public OnlinerSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public OnlinerSearchPage filterByPrice(int minPrice) {
        driver.findElement(By.name("sp[price][from]")).sendKeys(Integer.toString(minPrice));
        searchButton.click();
        return new OnlinerSearchPage(driver);
    }

    public String getFirstFoundPhoneModel() {
        return driver.findElement(By.cssSelector(".pname a")).getText().trim();
    }
}
