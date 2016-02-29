// ============================================================================
//  File          : SearchResultsPage
//  Created       : 27.02.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class SearchResultsPage {
    private final WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultsPage chooseCategory(String category) {
        driver.findElement(By.linkText(category)).click();
        return new SearchResultsPage(driver);
    }

    public int getItemsCount() {
        String text = driver.findElement(By.className("filter-active-text")).getText();
        String count = StringUtils.substringBefore(text, " ");
        return Integer.valueOf(count);
    }
}
