package com.sg.socrates.service.item.excel.jxl;

import jxl.Workbook;
import jxl.read.biff.WorkbookParser;

import org.springframework.core.io.Resource;
import org.springframework.util.ClassUtils;

import com.sg.socrates.service.item.excel.AbstractExcelItemReader;
import com.sg.socrates.service.item.excel.Sheet;

/**
 * 
 * @author Nalini Ranjan
 * 
 * @param <T> the type
 */
public class JxlItemReader<T> extends AbstractExcelItemReader<T> {

    private Workbook workbook;

    public JxlItemReader() {
        super();
        this.setName(ClassUtils.getShortName(JxlItemReader.class));
    }

    @Override
    protected void openExcelFile(final Resource resource) throws Exception {
        this.workbook = WorkbookParser.getWorkbook(resource.getInputStream());
    }

    @Override
    protected void doCloseWorkbook() throws Exception {
        if (this.workbook != null) {
            this.workbook.close();
        }
    }

    @Override
    protected Sheet getSheet(final int sheet) {
        if (sheet < this.workbook.getNumberOfSheets()) {
            return new JxlSheet(this.workbook.getSheet(sheet));
        }
        return null;
    }

    @Override
    protected int getNumberOfSheets() {
        if (this.workbook == null) {
            throw new IllegalStateException("Workbook file not ready for reading!");
        }
        return this.workbook.getNumberOfSheets();
    }

}
