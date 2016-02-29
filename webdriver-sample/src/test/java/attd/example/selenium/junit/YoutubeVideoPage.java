// ============================================================================
//  File          : YoutubeVideoPage
//  Created       : 28.02.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class YoutubeVideoPage extends AbstractYoutubePage {
    @FindBy(css = "#watch7-views-info .watch-view-count")
    private WebElement counter;

    public YoutubeVideoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getViewsCount() {
        String count = counter.getText();
        return Integer.valueOf(StringUtils.remove(count, " "));
    }
}
