// ============================================================================
//  File          : CategoryPage
//  Created       : 16.03.2014   
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
public class CategoryPage extends AbstractSlandoPage {
    @FindBy(id = "chooselocList")
    private WebElement locationsList;

    @FindBy(id = "search-text")
    private WebElement searchText;

    @FindBy(id = "search-submit")
    private WebElement searchButton;

    public CategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CategoryPage chooseRegion(String region) {
        locationsList.click();
        clickLink(region);
        return this;
    }

    public CategoryPage findByKeywords(String keywords) {
        searchText.sendKeys(keywords);
        searchButton.click();
        return new CategoryPage(driver);
    }

    public boolean hasResults() {
        return !getText(By.id("listContainer")).contains("Нет результатов");
    }
}
