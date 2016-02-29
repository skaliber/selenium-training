// ============================================================================
//  File          : OnlinerTest
//  Created       : 16.05.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class OnlinerTest extends BaseSeleniumTest {
    @Test
    public void phoneForReachPeopleExists() {
        OnlinerCataloguePage cataloguePage = new OnlinerHomePage(driver).open()
                .openCatalogue();
        OnlinerSearchPage searchPage = cataloguePage.chooseCategory("Мобильные телефоны");
        String modelName = searchPage.filterByPrice(1000).getFirstFoundPhoneModel();
        assertEquals("BlackBerry Porsche Design P9981", modelName);
    }

    @Test
    public void testOnliner() throws Exception {
        driver.get("http://www.onliner.by/");
        driver.findElement(By.cssSelector("a.b-main-navigation__link")).click();
        driver.findElement(By.linkText("Мобильные телефоны")).click();
        driver.findElement(By.name("sp[price][from]")).clear();
        driver.findElement(By.name("sp[price][from]")).sendKeys("1000");
        driver.findElement(By.name("search")).click();
        assertEquals("BlackBerry Porsche Design P9981", driver.findElement(By.cssSelector(".pname > a")).getText());
    }
}
