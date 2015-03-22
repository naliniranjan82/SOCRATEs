package com.sg.socrates.service.item.excel.transform;

import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/** 
 * {@link ColumnToAttributeConverter} which maps the names to columns and vice versa based on the provide mapping
 * configuration. If a mapping cannot be found it returns the name as is.
 * 
 * @author Nalini Ranjan
 */
public class MappingColumnToAttributeConverter implements ColumnToAttributeConverter {

    private final Map<String, String> mapping = new HashMap<String, String>();

    public String toAttribute(final String column) {
        if (this.mapping.containsKey(column)) {
            return this.mapping.get(column);
        }
        return column;
    }

    public String toColumn(final String attribute) {
        if (this.mapping.containsValue(attribute)) {
            for (Map.Entry<String, String> entry : this.mapping.entrySet()) {
                if (ObjectUtils.nullSafeEquals(attribute, entry.getValue())) {
                    return entry.getKey();
                }
            }
        }
        return attribute;
    }

    public void setMappings(final Map<String, String> mappings) {
        this.mapping.clear();
        this.mapping.putAll(mappings);
    }
}
