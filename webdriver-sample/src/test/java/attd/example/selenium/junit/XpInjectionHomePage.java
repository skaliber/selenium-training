// ============================================================================
//  File          : XpInjectionHomePage
//  Created       : 26.02.2015   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2015 Zoral, Ukraine
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
public class XpInjectionHomePage {
    private final WebDriver driver;

    @FindBy(linkText = "БЛОГ")
    private WebElement blogLink;

    public XpInjectionHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public XpInjectionHomePage open() {
        driver.navigate().to("http://xpinjection.com");
        return this;
    }

    public XpInjectionNewsPage goToNewsPage() {
        blogLink.click();
        return new XpInjectionNewsPage(driver);
    }
}
