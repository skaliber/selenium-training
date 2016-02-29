// ============================================================================
//  File          : AbstractElement
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
public class AbstractElement extends AbstractSearchContext<WebElement> {
    public AbstractElement(WebElement element) {
        super(element);
    }
}
