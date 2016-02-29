// ============================================================================
//  File          : XpInjectionTest
//  Created       : 26.02.2015   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2015 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class XpInjectionTest extends BaseSeleniumTest {
    @Test
    public void newsAreSearchableByText() {
        XpInjectionNewsPage newsPage = new XpInjectionHomePage(driver)
                .open().goToNewsPage();
        int newsCount = newsPage.searchByText("Selenium Camp")
                .getResultsCount();
        assertEquals(10, newsCount);
    }
}
