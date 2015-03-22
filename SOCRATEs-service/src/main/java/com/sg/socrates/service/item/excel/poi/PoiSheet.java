package com.sg.socrates.service.item.excel.poi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.sg.socrates.service.item.excel.Sheet;

/**
 * Sheet implementation for Apache POI.
 * 
 * @author Nalini Ranjan
 *
 */
public class PoiSheet implements Sheet {

    private final org.apache.poi.ss.usermodel.Sheet delegate;

    /**
     * Constructor which takes the delegate sheet.
     * 
     * @param delegate the apache POI sheet
     */
    PoiSheet(final org.apache.poi.ss.usermodel.Sheet delegate) {
        super();
        this.delegate = delegate;
    }

    /**
     * {@inheritDoc}
     */
    public int getNumberOfRows() {
        return this.delegate.getLastRowNum() + 1;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return this.delegate.getSheetName();
    }

    /**
     * {@inheritDoc}
     */
    public String[] getRow(final int rowNumber) {
        if (rowNumber > this.delegate.getLastRowNum()) {
            return null;
        }
        final Row row = this.delegate.getRow(rowNumber);
        final List<String> cells = new LinkedList<String>();

        final Iterator<Cell> cellIter = row.iterator();
        while (cellIter.hasNext()) {
            final Cell cell = cellIter.next();
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                cells.add(String.valueOf(cell.getNumericCellValue()));
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cells.add(String.valueOf(cell.getBooleanCellValue()));
                break;
            case Cell.CELL_TYPE_STRING:
            case Cell.CELL_TYPE_BLANK:
                cells.add(cell.getStringCellValue());
                break;
            default:
                throw new IllegalArgumentException("Cannot handle cells of type " + cell.getCellType());
            }
        }
        return cells.toArray(new String[cells.size()]);
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
    public int getNumberOfColumns() {
        final String[] columns = this.getHeader();
        if (columns != null) {
            return columns.length;
        }
        return 0;
    }
}
