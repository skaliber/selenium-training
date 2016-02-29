// ============================================================================
//  File          : WebDriverFactory
//  Created       : 06.10.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package attd.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class WebDriverFactory {
    public static WebDriver configureIE() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setJavascriptEnabled(true);
        return new InternetExplorerDriver(capabilities);
    }

    public static WebDriver configureChrome() {
        return new ChromeDriver();
    }

    public static WebDriver configureFirefox() {
        FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        return new FirefoxDriver(capabilities);
    }

    public static WebDriver configureHtmlUnit() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        return new HtmlUnitDriver(capabilities);
    }
}
