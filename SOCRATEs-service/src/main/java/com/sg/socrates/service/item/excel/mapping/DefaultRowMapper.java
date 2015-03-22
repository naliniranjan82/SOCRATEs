package com.sg.socrates.service.item.excel.mapping;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.sg.socrates.service.item.excel.RowMapper;
import com.sg.socrates.service.item.excel.Sheet;
import com.sg.socrates.service.item.excel.transform.DefaultRowTokenizer;
import com.sg.socrates.service.item.excel.transform.RowTokenizer;

/**
 * @author Nalini Ranjan
 *
 * @param <T>
 */
public class DefaultRowMapper<T> implements RowMapper<T>, InitializingBean {

    private RowTokenizer rowTokenizer = new DefaultRowTokenizer();
    private FieldSetMapper<T> fieldSetMapper;

    public T mapRow(final Sheet sheet, final String[] row, final int rowNum) throws Exception {
        return this.fieldSetMapper.mapFieldSet(this.rowTokenizer.tokenize(sheet, row));
    }

    public void setFieldSetMapper(final FieldSetMapper<T> fieldSetMapper) {
        this.fieldSetMapper = fieldSetMapper;
    }

    /**
     * Set the {@link RowTokenizer} to use to create a {@link FieldSet}. Default uses the {@link DefaultRowTokenizer}.
     * 
     * @param rowTokenizer to use
     */
    public void setRowTokenizer(final RowTokenizer rowTokenizer) {
        this.rowTokenizer = rowTokenizer;
    }

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.rowTokenizer, "The RowTokenizer must be set");
        Assert.notNull(this.fieldSetMapper, "The FieldSetMapper must be set");
    }
}
