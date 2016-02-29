// ============================================================================
//  File          : MainYoutubePage
//  Created       : 28.02.2014   
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
public class MainYoutubePage extends AbstractYoutubePage {
    @FindBy(name = "search_query")
    private WebElement query;
    @FindBy(id = "search-btn")
    private WebElement searchButton;

    public MainYoutubePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainYoutubePage open() {
        driver.get("http://youtube.com");
        return this;
    }

    public YoutubeSearchResultsPage searchByKeywords(String keywords) {
        query.sendKeys(keywords);
        searchButton.click();
        return new YoutubeSearchResultsPage(driver);
    }
}
