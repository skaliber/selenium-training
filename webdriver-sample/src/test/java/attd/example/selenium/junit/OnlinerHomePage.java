// ============================================================================
//  File          : OnlinerHomePage
//  Created       : 16.05.2014   
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
public class OnlinerHomePage extends AbstractOnlinerPage {
    @FindBy(linkText = "Каталог и цены")
    private WebElement catalogueLink;

    public OnlinerHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public OnlinerCataloguePage openCatalogue() {
        catalogueLink.click();
        return new OnlinerCataloguePage(driver);
    }

    public OnlinerHomePage open() {
        driver.get("http://onliner.by");
        return this;
    }
}
