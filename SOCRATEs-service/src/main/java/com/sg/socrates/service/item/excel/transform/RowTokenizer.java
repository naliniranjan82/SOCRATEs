package com.sg.socrates.service.item.excel.transform;

import org.springframework.batch.item.file.transform.FieldSet;

import com.sg.socrates.service.item.excel.Sheet;

/**
 * Interface that is used by framework to convert a Cell[] into a {@link FieldSet}.
 * 
 * @author Nalini Ranjan
 */

public interface RowTokenizer {

    FieldSet tokenize(Sheet sheet, String[] row);
}
