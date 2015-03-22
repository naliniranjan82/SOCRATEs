package com.sg.socrates.service.item.excel.transform;

/**
 * {@link ColumnToAttributeConverter} which simply returns the given value.
 * 
 * @author Nalini Ranjan
 */
public class PassThroughColumnToAttributeConverter implements ColumnToAttributeConverter {

    public String toAttribute(final String column) {
        return column;
    }

    public String toColumn(final String attribute) {
        return attribute;
    }

}
