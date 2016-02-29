// ============================================================================
//  File          : RozetkaTest
//  Created       : 27.02.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Zoral, Ukraine
// ============================================================================
package attd.example.selenium.junit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class RozetkaTest extends BaseSeleniumTest {
    private BaseSteps baseSteps;

    @Before
    public void initSteps() {
        baseSteps = new BaseSteps(driver);
    }

    @Test
    public void searchForItemCategoryIsEnabled() {
        SearchResultsPage resultsPage = new HomePage(driver).open()
                .searchByKeyword("буй");
        int itemsCount = resultsPage.chooseCategory("Mares")
                .getItemsCount();
        assertEquals(9, itemsCount);
    }




    @Test
    public void itemDetailsIsAccessibleForReview() {
        RozetkaHomePage homePage = new RozetkaHomePage(driver).open();
        RozetkaSearchResultsPage resultsPage = homePage.searchByKeywords("phone iphone");
        assumeTrue(resultsPage.getItemsCount() > 0);

        RozetkaItemPage itemPage = resultsPage.chooseElementByIndex(0);
        assertEquals("iPhone 6s", itemPage.getItemName());
    }


    @Test
    public void phonesAreAvailableInTheShop() {
        openHomePage();
        searchByText("jdhfkjsdf");

        String foundItems = driver.findElement(By.id("counter")).getText();
        assertEquals(100, Integer.parseInt(foundItems));
    }

    @Test
    public void compositeItemsAreAvailableInTheShop() {
        openHomePage();
        searchByText("phone gap");
        String foundItems = driver.findElement(By.id("counter")).getText();
        assertEquals(100, Integer.parseInt(foundItems));
    }

    private void searchByText(String s) {
        driver.findElement(By.name("text")).sendKeys(s);
        driver.findElement(By.name("search-button")).click();
    }

    private void openHomePage() {
        baseSteps.openHomePage();
    }

    private class BaseSteps {
        private final WebDriver driver;

        public BaseSteps(WebDriver driver) {
            this.driver = driver;
        }

        public void openHomePage() {
            driver.get("http://rozetka.com.ua");
        }
    }

    private class RozetkaHomePage {
        private final WebDriver driver;

        @FindBy(name = "text")
        private WebElement searchBox;

        public RozetkaHomePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public RozetkaHomePage open() {
            driver.navigate().to("http://rozetka.com.ua");
            return this;
        }

        public RozetkaSearchResultsPage searchByKeywords(String keywords) {
            searchBox.sendKeys(keywords);
            return new RozetkaSearchResultsPage(driver);
        }
    }

    private class RozetkaSearchResultsPage {
        private final WebDriver driver;

        public RozetkaSearchResultsPage(WebDriver driver) {
            //todo<lumii> implement me
            this.driver = driver;
        }

        public int getItemsCount() {
            return 0;//todo<lumii> implement me
        }

        public RozetkaItemPage chooseElementByIndex(int index) {
            return new RozetkaItemPage(driver);
        }
    }

    private class RozetkaItemPage {
        private final WebDriver driver;

        public RozetkaItemPage(WebDriver driver) {
            //todo<lumii> implement me
            this.driver = driver;
        }

        public String getItemName() {
            return null;//todo<lumii> implement me
        }
    }
}
