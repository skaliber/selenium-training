// ============================================================================
//  File          : SlandoTest
//  Created       : 16.03.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class SlandoTest extends BaseSeleniumTest {
    @Test
    public void itIsImpossibleToFindGreatGostinka() {
        CategoryPage categoryPage = new MainSlandoPage(driver).open()
                .chooseCategory("Недвижимость");
        boolean resultsFound = categoryPage.chooseRegion("Крым")
                .findByKeywords("крутая гостинка")
                .hasResults();
        assertFalse(resultsFound);
    }

    @Test
    public void impossibleKeywordsWillNotGiveResults() {
        CategoryPage categoryPage = new MainSlandoPage(driver)
                .open().chooseCategory("Недвижимость");
        boolean resultsFound = categoryPage.findByKeywords("akalakakala")
                .hasResults();
        assertFalse(resultsFound);
    }
}
