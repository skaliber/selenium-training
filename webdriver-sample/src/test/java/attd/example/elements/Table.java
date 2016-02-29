// ============================================================================
//  File          : Table
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
public class Table extends AbstractElement {
    public static final String ROW_XPATH_LOCATOR = "//tbody/tr";

    private static String getCellXpathLocator(int row, int column) {
        return ROW_XPATH_LOCATOR + "[" + row + "]/td[" + column + "]";
    }

    public Table(WebElement element) {
        super(element);
    }

    public Cell getCell(int row, int column) {
        return new Cell(row, column);
    }

    public int getRowCount() {
        return findAllByXPath(ROW_XPATH_LOCATOR).size();
    }

    public class Cell extends AbstractElement {
        private int row;
        private int column;

        public Cell(int row, int column) {
            super(Table.this.findByXPath(getCellXpathLocator(row, column)));
            this.row = row;
            this.column = column;
        }

        public String getText() {
            return context.getText();
        }

        public Cell nextInRow() {
            return new Cell(row, column + 1);
        }

        public Cell previousInRow() {
            return new Cell(row, column - 1);
        }
    }
}
