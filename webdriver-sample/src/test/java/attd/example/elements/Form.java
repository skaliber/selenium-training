// ============================================================================
//  File          : Form
//  Created       : 25.02.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package attd.example.elements;

import org.openqa.selenium.WebElement;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class Form extends AbstractElement {
    public Form(WebElement element) {
        super(element);
    }

    public Form set(String fieldName, String value) {
        findByName(fieldName).sendKeys(value);
        return this;
    }

    public String getFieldValue(String fieldName) {
        return findByName(fieldName).getAttribute("value");
    }

    public void submit() {
        context.submit();
    }
}
