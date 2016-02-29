// ============================================================================
//  File          : YoutubeTest
//  Created       : 28.02.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class YoutubeTest extends BaseSeleniumTest {
    @Test
    public void viewsCountForDisabledVideoIsNotChanged() {
        YoutubeSearchResultsPage searchResultsPage = new MainYoutubePage(driver)
                .open().searchByKeywords("selenium camp");
        YoutubeVideoPage videoPage = searchResultsPage.openVideo("Николай Алименков Автоматизация тестирования Web UI");
        assertEquals(2831, videoPage.getViewsCount());
    }
}
