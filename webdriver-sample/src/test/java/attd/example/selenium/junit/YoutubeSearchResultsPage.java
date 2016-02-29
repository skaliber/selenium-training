// ============================================================================
//  File          : YoutubeSearchResultsPage
//  Created       : 28.02.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class YoutubeSearchResultsPage extends AbstractYoutubePage {
    public YoutubeSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public YoutubeVideoPage openVideo(String videoName) {
        driver.findElement(By.linkText(videoName)).click();
        return new YoutubeVideoPage(driver);
    }
}
