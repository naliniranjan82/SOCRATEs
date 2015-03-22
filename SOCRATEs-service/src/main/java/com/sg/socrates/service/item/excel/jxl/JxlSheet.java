package com.sg.socrates.service.item.excel.jxl;

import jxl.Cell;

import com.sg.socrates.service.item.excel.Sheet;
import com.sg.socrates.service.item.excel.util.JxlUtils;

/**
 * {@link Sheet} implementation for JXL.
 * 
 * @author Nalini Ranjan
 *
 */
public class JxlSheet implements Sheet {

    private final jxl.Sheet delegate;

    /**
     * Constructor which takes the delegate sheet.
     * 
     * @param delegate the JXL sheet
     */
    JxlSheet(final jxl.Sheet delegate) {
        super();
        this.delegate = delegate;
    }

    /**
     * {@inheritDoc}
     */
    public int getNumberOfRows() {
        return this.delegate.getRows();
    }

    /**
     * {@inheritDoc}
     */
    public String[] getHeader() {
        return this.getRow(0);
    }

    /**
     * {@inheritDoc}
     */
    public String[] getRow(final int rowNumber) {
        final Cell[] row = this.delegate.getRow(rowNumber);
        return JxlUtils.extractContents(row);
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return this.delegate.getName();
    }

    /**
     * {@inheritDoc}
     */
    public int getNumberOfColumns() {
        return this.delegate.getColumns();
    }

}
