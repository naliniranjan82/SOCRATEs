package com.sg.socrates.service.item.excel.util;

import jxl.Cell;
import jxl.Workbook;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing utility methods to work with JXL.
 *
 * @author Nalini Ranjan
 *
 */
public final class JxlUtils {

    /** Private constructor to prevent easy instantiation. */
    private JxlUtils() {
    }

    /**
     * Checks if the given cell is emtpy. The cell is empty if it contains no characters, it will trim spaces.

     * @param cell to check
     * @return true/false
     * @see StringUtils#hasText(String)
     */
    public static boolean isEmpty(final Cell cell) {
        return cell == null || !StringUtils.hasText(cell.getContents());
    }

    /**
     * Check if the given row (Cell[]) is empty. It is considered empty when the row is null, the array is empty or all the cells in the row are empty.
     * @param row to check
     * @return true/false
     */
    public static boolean isEmpty(final Cell[] row) {
        if (row == null || row.length == 0) {
            return true;
        }
        for (final Cell cell : row) {
            if (!isEmpty(cell)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the given workbook has any sheets.
     * 
     * @param workbook to check
     * @return true/false
     */
    public static boolean hasSheets(final Workbook workbook) {
        return workbook != null && workbook.getNumberOfSheets() > 0;
    }

    /**
     * Extract the content from the given row. 
     * 
     * @param row the row
     * @return the content as String[]
     */
    public static String[] extractContents(final Cell[] row) {
        final List<String> values = new ArrayList<String>();
        for (final Cell cell : row) {
            values.add(cell.getColumn(), isEmpty(cell) ? null : cell.getContents());
        }
        return values.toArray(new String[values.size()]);
    }
}
