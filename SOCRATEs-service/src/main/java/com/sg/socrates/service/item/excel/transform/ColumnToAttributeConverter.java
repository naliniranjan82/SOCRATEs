package com.sg.socrates.service.item.excel.transform;

/**
 * Convert a column name to an attribute name and vice versa.
 * 
 * @author Nalini Ranjan
 */
public interface ColumnToAttributeConverter {

    /**
     * Convert a column name to an attribute name.
     * 
     * @param column to convert
     * @return the attribute name
     */
    String toAttribute(String column);

    /**
     * Convert an attribute name to a column name.
     * 
     * @param attribute to convert
     * @return the column name
     */
    String toColumn(String attribute);

}
